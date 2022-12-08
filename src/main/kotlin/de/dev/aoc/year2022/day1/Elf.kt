package de.dev.aoc.year2022.day1


data class Elf(val summedCalorie: Int) {
    companion object {
        fun byCalories(calories: Calories): Elf {
            return Elf(calories.calorieSum())
        }
    }
}
