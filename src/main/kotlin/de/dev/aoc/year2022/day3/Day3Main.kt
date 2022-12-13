package de.dev.aoc.year2022.day3

import de.dev.aoc.ResourceLoader


fun main() {
    solveDay3SimpleInput()
    solveDay3Part1()
    solveDay3Part2()
}

private fun solveDay3SimpleInput() {
    val rucksackAsStrings: List<String> = ResourceLoader.loadLines("/year2022/day3/simple_input.txt")
    val rucksacks: List<Rucksack> = Rucksack.byInputStrings(rucksackAsStrings)
    val priorities: List<Priority> = rucksacks.map { it.prioritize() }
    val sumedPriorites: Int = priorities.sumOf { it.value }
    println("Day 3 - Simple Input - Sumed Priorities is: $sumedPriorites")
}

fun solveDay3Part1() {
    val rucksackAsStrings: List<String> = ResourceLoader.loadLines("/year2022/day3/input.txt")
    val rucksacks: List<Rucksack> = Rucksack.byInputStrings(rucksackAsStrings)
    val priorities: List<Priority> = rucksacks.map { it.prioritize() }
    val sumedPriorites: Int = priorities.sumOf { it.value }
    println("Day 3 - Part 1 - Sumed Priorities is: $sumedPriorites")
}

fun solveDay3Part2() {
    val rucksackGroupsAsStringLists: List<List<String>> = ResourceLoader.loadLines("/year2022/day3/input.txt").chunked(3)
    val rucksackGroups: List<RucksackGroup> = rucksackGroupsAsStringLists.map { RucksackGroup.byInputStrings(it) }
    val priorities: List<Priority> = rucksackGroups.map { it.prioritize() }
    val sumedPriorites: Int = priorities.sumOf { it.value }
    println("Day 3 - Part 2 - Sumed Priorities is: $sumedPriorites")
}
