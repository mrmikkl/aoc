package de.dev.aoc.year2022.day3

class Rucksack(val firstCompartment: String, val secondCompartment: String) {
    companion object {
        fun byInputStrings(rucksackAsStrings: List<String>): List<Rucksack> = rucksackAsStrings.map { byInputString(it) }
        private fun byInputString(rucksackString: String): Rucksack {
            val chunkedRucksackString: List<String> = rucksackString.chunked(rucksackString.length / 2)
            return Rucksack(chunkedRucksackString.first(), chunkedRucksackString.last())
        }
    }

    fun prioritize(): Priority {
        val sharedChar: Char = firstCompartment.asSequence().find { secondCompartment.contains(it) }!!
        return Priority.byChar(sharedChar)
    }

    fun content(): String = firstCompartment + secondCompartment
}
