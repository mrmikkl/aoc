package de.dev.aoc.year2022.day1


data class Calories(val values: List<Calorie>) {
    companion object {
        fun byCaloriesString(caloriesString: String): Calories {
            val calories: List<Calorie> = caloriesString.split("\n")
                .map { Calorie(it.toInt()) }
            return Calories(calories)
        }
    }

    fun calorieSum(): Int {
        return values.fold(0) { sum, calorie -> sum + calorie.value }
    }
}
