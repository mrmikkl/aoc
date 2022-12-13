package de.dev.aoc.year2022.day4

class CleanAssignment(val firstRange: Range, val secondRange: Range) {
    companion object {
        fun byInputs(inputs: List<String>): List<CleanAssignment> {
            return inputs.map { byInput(it) }
        }

        private fun byInput(input: String): CleanAssignment {
            val ranges: List<Int> = input.split("""\D+""".toRegex())
                .map { it.toInt() }
            return CleanAssignment(Range(ranges[0], ranges[1]), Range(ranges[2], ranges[3]))
        }

    }

    fun rangesCompletelyOverlap(): Boolean {
        return firstRange.containsCompletely(secondRange) || secondRange.containsCompletely(firstRange)
    }

    fun rangesOverlap(): Boolean {
        return firstRange.containsPartOf(secondRange) || secondRange.containsPartOf(firstRange)
    }
}
