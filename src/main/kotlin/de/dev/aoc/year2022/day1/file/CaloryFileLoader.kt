package de.dev.aoc.year2022.day1.file

import de.dev.aoc.ResourceLoader
import de.dev.aoc.year2022.day1.Elf


class CaloryFileLoader {
    companion object {
        fun loadSimpleInput(): List<Elf> {
            return this.load(CaloryFilePaths.simpleInput)
        }

        fun loadInput(): List<Elf> {
            return this.load(CaloryFilePaths.input)
        }

        private fun load(path: String): List<Elf> {
            return ResourceLoader.load(path)
                .trim()
                .split("\n\n")
                .map { it.split("\n") }
                .map { Elf.byCaloryList(it) }
        }
    }
}
