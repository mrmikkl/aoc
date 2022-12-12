package de.dev.aoc.year2022.day3

class RucksackGroup(val firstRucksack: Rucksack, val secondRucksack: Rucksack, val thirdRucksack: Rucksack) {
    companion object {
        fun byInputStrings(rucksackGroupAsString: List<String>): RucksackGroup {
            val rucksacks: List<Rucksack> = Rucksack.byInputStrings(rucksackGroupAsString)
            return RucksackGroup(rucksacks[0], rucksacks[1], rucksacks[2])
        }
    }

    fun prioritize(): Priority {
        val sharedChar: Char = firstRucksack.content().find { secondRucksack.content().contains(it) && thirdRucksack.content().contains(it) }!!
        return Priority.byChar(sharedChar)
    }
}
