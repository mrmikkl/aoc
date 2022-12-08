package de.dev.aoc

import java.io.FileNotFoundException
import java.io.InputStream
import java.util.*


private fun String.asStreamResource(): InputStream {
    return Optional.ofNullable(Unit.javaClass.getResourceAsStream(this))
        .orElseThrow { FileNotFoundException("File for Resource at $this could not be found!") }
}

class ResourceLoader {
    companion object {
        fun load(path: String): String = path.asStreamResource().bufferedReader().readText()
        fun loadLines(path: String): List<String> = path.asStreamResource().bufferedReader().readLines()
    }
}
