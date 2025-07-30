package ru.dchertanov.book.general.model

import java.util.Collections

class BookNode(
    val title: String = "",
    val text: String = "",
) {

    private val childes: MutableList<BookNode> = ArrayList<BookNode>()

    var previousNode: BookNode? = null
    var nextNode: BookNode? = null

    fun appendChild(child: BookNode) {
        childes.add(child)
    }

    fun appendAllChildes(childes: List<BookNode>) {
        this.childes.addAll(childes)
    }

    fun getChildes(): List<BookNode> = Collections.unmodifiableList(childes)
}