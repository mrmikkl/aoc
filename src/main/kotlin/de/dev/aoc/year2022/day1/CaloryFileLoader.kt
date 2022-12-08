package de.dev.aoc.year2022.day1

import de.dev.aoc.ResourceLoader


class CaloryFileLoader {
    companion object {
        fun loadSimpleInput(): List<Elf> {
            return load(CaloryFilePaths.simpleInput)
        }

        fun loadInput(): List<Elf> {
            return load(CaloryFilePaths.input)
        }

        private fun load(path: String): List<Elf> {
            return ResourceLoader.load(path)
                .trim()
                .split("\n\n")
                .map { Calories.byCaloriesString(it) }
                .map { Elf.byCalories(it) }
        }
    }
}
