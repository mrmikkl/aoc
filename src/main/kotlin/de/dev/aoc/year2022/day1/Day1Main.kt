package de.dev.aoc.year2022.day1


fun main() {
    solveDay1SimpleInput()
    solveDay1Part1()
    solveDay1Part2()
}

private fun solveDay1SimpleInput() {
    val elves: List<Elf> = CaloryFileLoader.loadSimpleInput()
    println("Day 1 - Simple Input - Highest calories are: ${elves.maxOfOrNull { it.summedCalorie }}")
}

fun solveDay1Part1() {
    val elves: List<Elf> = CaloryFileLoader.loadInput()
    println("Day 1 - Part 1 - Highest calories are: ${elves.maxOfOrNull { it.summedCalorie }}")
}

fun solveDay1Part2() {
    val elves: List<Elf> = CaloryFileLoader.loadInput()
    val threeMostCaloryElves: List<Elf> = elves.sortedByDescending { it.summedCalorie }.take(3)
    println("Day 1 - Part 2 - Highest 3 calories sumed up are: ${threeMostCaloryElves.sumOf { it.summedCalorie }}")
}
