package de.dev.aoc.year2022.day2

import de.dev.aoc.ResourceLoader


fun main() {
    solveDay2SimpleInput()
    solveDay2Part1()
    solveDay2Part2()
}

private fun solveDay2SimpleInput() {
    val strategyGuideStrings: List<String> = ResourceLoader.loadLines("/year2022/day2/simple_input.txt")
    val strategyGuideMoves: List<StrategyGuideMove> = StrategyGuideMove.byOpponentAndMyMovesAsString(strategyGuideStrings)
    val myScore: Int = strategyGuideMoves.fold(0) { scoreSum, strategyGuideMove -> scoreSum + strategyGuideMove.determineMyScore() }
    println("Day 2 - Simple Input - Solution is: $myScore")
}

fun solveDay2Part1() {
    val strategyGuideStrings: List<String> = ResourceLoader.loadLines("/year2022/day2/input.txt")
    val strategyGuideMoves: List<StrategyGuideMove> = StrategyGuideMove.byOpponentAndMyMovesAsString(strategyGuideStrings)
    val myScore: Int = strategyGuideMoves.fold(0) { scoreSum, strategyGuideMove -> scoreSum + strategyGuideMove.determineMyScore() }
    println("Day 2 - Part 1 - Input - Solution is: $myScore")
}

fun solveDay2Part2() {
    val strategyGuideStrings: List<String> = ResourceLoader.loadLines("/year2022/day2/input.txt")
    val strategyGuideMoves: List<StrategyGuideMove> = StrategyGuideMove.byOpponentMoveAndWishedResult(strategyGuideStrings)
    val myScore: Int = strategyGuideMoves.fold(0) { scoreSum, strategyGuideMove -> scoreSum + strategyGuideMove.determineMyScore() }
    println("Day 2 - Part 2 - Input - Solution is: $myScore")
}
