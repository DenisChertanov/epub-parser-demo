package ru.dchertanov.book.general

import java.io.InputStream
import ru.dchertanov.book.general.model.BookNode
import ru.dchertanov.book.general.model.BookType

interface BookParser {

    val supportedBookType: BookType

    /**
     * @return first BookNode of the given book
     */
    fun parseBook(inputStream: InputStream): BookNode
}