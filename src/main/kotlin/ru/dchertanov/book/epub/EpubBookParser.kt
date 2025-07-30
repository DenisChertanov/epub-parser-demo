package ru.dchertanov.book.epub

import java.io.InputStream
import nl.siegmann.epublib.domain.TOCReference
import nl.siegmann.epublib.epub.EpubReader
import ru.dchertanov.book.general.BookParser
import ru.dchertanov.book.general.model.BookNode
import ru.dchertanov.book.general.model.BookType

class EpubBookParser : BookParser {

    override val supportedBookType = BookType.EPUB

    override fun parseBook(inputStream: InputStream): BookNode {
        val book = EpubReader().readEpub(inputStream)

        val bookNodes = traverseToc(tocRefs = book.tableOfContents.tocReferences, depth = 1)
        check(bookNodes.isNotEmpty()) { "List of BookNode can't be empty" }

        return bookNodes.first()
    }

    fun traverseToc(tocRefs: List<TOCReference>, depth: Int): List<BookNode> {
        var previousNode: BookNode? = null
        val nodes = tocRefs.map { toc ->
            val childes = traverseToc(toc.children, depth + 1)
            val title = toc.title
            val text = toc.resource?.let { String(it.data) }

            val node =
                BookNode(
                    title = title,
                    text = text ?: "",
                ).apply {
                    appendAllChildes(childes)
                }

            node.previousNode = previousNode
            if (previousNode != null) {
                previousNode.nextNode = node
            }
            previousNode = node

            node
        }

        return nodes
    }
}