package de.dev.aoc.year2022.day3

import de.dev.aoc.ResourceLoader


fun main() {
    solveDay3SimpleInput()
    solveDay1Part1()
    solveDay1Part2()
}

private fun solveDay3SimpleInput() {
    val rucksackAsString: List<String> = ResourceLoader.loadLines("/year2022/day3/simple_input.txt")
    val rucksacks: List<Rucksack> = Rucksack.byInputStrings(rucksackAsString)
    val priorities: List<Priority> = rucksacks.map { it.prioritize() }
    val sumedPriorites: Int = priorities.sumOf { it.value }
    println("Day 3 - Simple Input - Sumed Priorities is: $sumedPriorites")
}

fun solveDay1Part1() {
    val rucksackAsString: List<String> = ResourceLoader.loadLines("/year2022/day3/input.txt")
    val rucksacks: List<Rucksack> = Rucksack.byInputStrings(rucksackAsString)
    val priorities: List<Priority> = rucksacks.map { it.prioritize() }
    val sumedPriorites: Int = priorities.sumOf { it.value }
    println("Day 3 - Part 1 - Sumed Priorities is: $sumedPriorites")
}

fun solveDay1Part2() {
    val rucksackGroupsAsStringList: List<List<String>> = ResourceLoader.loadLines("/year2022/day3/input.txt").chunked(3)
    val rucksackGroups: List<RucksackGroup> = rucksackGroupsAsStringList.map { RucksackGroup.byInputStrings(it) }
    val priorities: List<Priority> = rucksackGroups.map { it.prioritize() }
    val sumedPriorites: Int = priorities.sumOf { it.value }
    println("Day 3 - Part 2 - Sumed Priorities is: $sumedPriorites")
}
