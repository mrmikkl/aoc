package de.dev.aoc.year2022.day1


data class Elf(val calory: Int) {
    companion object {
        fun byCaloryList(calories: List<String>): Elf {
            val sumedCalory = calories.map(String::toInt)
                .reduce { sum, calory -> sum + calory }

            return Elf(sumedCalory)
        }
    }
}
