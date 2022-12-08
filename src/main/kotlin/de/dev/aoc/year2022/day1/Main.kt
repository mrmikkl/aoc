package de.dev.aoc.year2022.day1

import de.dev.aoc.year2022.day1.file.CaloryFileLoader


fun main() {
    solveDay1SimpleInput()
    solveDay1Part1()
    solveDay1Part2()
}

private fun solveDay1SimpleInput() {
    val elves: List<Elf> = CaloryFileLoader.loadSimpleInput()
    println("Highest calories are: ${elves.maxOfOrNull { it.calory }}")
}

fun solveDay1Part1() {
    val elves: List<Elf> = CaloryFileLoader.loadInput()
    println("Highest calories are: ${elves.maxOfOrNull { it.calory }}")
}

fun solveDay1Part2() {
    val elves: List<Elf> = CaloryFileLoader.loadInput()
    val threeMostCaloryElves: List<Elf> = elves.sortedByDescending { it.calory }.take(3)
    println("Highest 3 calories sumed up are: ${threeMostCaloryElves.sumOf { it.calory }}")
}
