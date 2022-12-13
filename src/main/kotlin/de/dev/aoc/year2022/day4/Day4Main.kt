package de.dev.aoc.year2022.day4

import de.dev.aoc.ResourceLoader


fun main() {
    solveDay4SimpleInput()
    solveDay4Part1()
    solveDay4Part2()
}

private fun solveDay4SimpleInput() {
    val cleanAssignmentsAsStrings: List<String> = ResourceLoader.loadLines("/year2022/day4/simple_input.txt")
    val cleanAssignments: CleanAssignments = CleanAssignments.byInputs(cleanAssignmentsAsStrings)
    val numberOfCompletelyOverlappingCleanAssignments: Int = cleanAssignments.sumOfCompletelyOverlapping()
    println("Day 4 - Simple Input - Overlapping Clean Assignments: $numberOfCompletelyOverlappingCleanAssignments")
}

fun solveDay4Part1() {
    val cleanAssignmentsAsStrings: List<String> = ResourceLoader.loadLines("/year2022/day4/input.txt")
    val cleanAssignments: CleanAssignments = CleanAssignments.byInputs(cleanAssignmentsAsStrings)
    val numberOfCompletelyOverlappingCleanAssignments: Int = cleanAssignments.sumOfCompletelyOverlapping()
    println("Day 4 - Part 1 - Completely Overlapping Clean Assignments: $numberOfCompletelyOverlappingCleanAssignments")
}

fun solveDay4Part2() {
    val cleanAssignmentsAsStrings: List<String> = ResourceLoader.loadLines("/year2022/day4/input.txt")
    val cleanAssignments: CleanAssignments = CleanAssignments.byInputs(cleanAssignmentsAsStrings)
    val numberOfOverlappingCleanAssignments: Int = cleanAssignments.sumOfOverlapping()
    println("Day 4 - Part 2 - Overlapping Clean Assignments: $numberOfOverlappingCleanAssignments")
}
