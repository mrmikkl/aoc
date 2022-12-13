package de.dev.aoc.year2022.day4


class CleanAssignments(private val values: List<CleanAssignment>) {
    companion object {
        fun byInputs(inputs: List<String>): CleanAssignments {
            return CleanAssignments(CleanAssignment.byInputs(inputs))
        }
    }

    fun sumOfCompletelyOverlapping(): Int {
        return values.sumOf {
            when {
                it.rangesCompletelyOverlap() -> 1 as Int
                else -> 0 as Int
            }
        }
    }

    fun sumOfOverlapping(): Int {
        return values.sumOf {
            when {
                it.rangesOverlap() -> 1 as Int
                else -> 0 as Int
            }
        }
    }
}
