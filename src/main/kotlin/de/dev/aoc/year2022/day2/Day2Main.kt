package de.dev.aoc.year2022.day2

import de.dev.aoc.ResourceLoader
import de.dev.aoc.year2022.day2.inheritance.StrategyGuideInstruction


fun main() {
    solveDay2SimpleInputWithInheritance()
    solveDay2Part1WithInheritance()
    solveDay2Part2WithInheritance()
    solveDay2SimpleInputWithEnum()
}

private fun solveDay2SimpleInputWithInheritance() {
    val strategyGuideStrings: List<String> = ResourceLoader.loadLines("/year2022/day2/simple_input.txt")
    val strategyGuideInstructions: List<StrategyGuideInstruction> = StrategyGuideInstruction.byOpponentAndMyMoves(strategyGuideStrings)
    val myScore: Int = strategyGuideInstructions.fold(0) { scoreSum, strategyGuideMove -> scoreSum + strategyGuideMove.determineMyScore() }
    println("Day 2 - Simple Input - Solution is: $myScore")
}

fun solveDay2Part1WithInheritance() {
    val strategyGuideStrings: List<String> = ResourceLoader.loadLines("/year2022/day2/input.txt")
    val strategyGuideInstructions: List<StrategyGuideInstruction> = StrategyGuideInstruction.byOpponentAndMyMoves(strategyGuideStrings)
    val myScore: Int = strategyGuideInstructions.fold(0) { scoreSum, strategyGuideMove -> scoreSum + strategyGuideMove.determineMyScore() }
    println("Day 2 - Part 1 - Input - Solution is: $myScore")
}

fun solveDay2Part2WithInheritance() {
    val strategyGuideStrings: List<String> = ResourceLoader.loadLines("/year2022/day2/input.txt")
    val strategyGuideInstructions: List<StrategyGuideInstruction> = StrategyGuideInstruction.byOpponentMoveAndWishedResult(strategyGuideStrings)
    val myScore: Int = strategyGuideInstructions.fold(0) { scoreSum, strategyGuideMove -> scoreSum + strategyGuideMove.determineMyScore() }
    println("Day 2 - Part 2 - Input - Solution is: $myScore")
}

fun solveDay2SimpleInputWithEnum() {
    val strategyGuideStrings: List<String> = ResourceLoader.loadLines("/year2022/day2/simple_input.txt")
}
