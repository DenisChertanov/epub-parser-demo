package ru.dchertanov.book.general

import ru.dchertanov.book.general.model.BookNode

object BookNodePrettyPrinter {

    fun prettyPrint(firstBookNode: BookNode) {
        println("\nPRETTY PRINT START")

        printNode(firstBookNode, depth = 1)

        println("\nPRETTY PRINT END")
    }

    private fun printNode(node: BookNode?, depth: Int) {
        if (node == null) {
            return
        }

        println("${"-".repeat(depth)} ${node.title}")

        printNode(node = node.getChildes().firstOrNull(), depth + 1)
        printNode(node = node.nextNode, depth)
    }
}