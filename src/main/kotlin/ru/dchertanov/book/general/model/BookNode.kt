package ru.dchertanov.book.general.model

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

    //TODO Отрефакторить
    fun getChildes(): List<BookNode> = childes
}