package ru.dchertanov

import java.io.FileInputStream
import ru.dchertanov.book.epub.EpubBookParser
import ru.dchertanov.book.general.BookNodePrettyPrinter

fun main() {
    testEpubParsing()
}

private fun testEpubParsing() {
    val firstBookNode = FileInputStream("/path/to/your/book.epub").use { epubInputStream ->
        EpubBookParser().parseBook(epubInputStream)
    }

    BookNodePrettyPrinter.prettyPrint(firstBookNode)
}