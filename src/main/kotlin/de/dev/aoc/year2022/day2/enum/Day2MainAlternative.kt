package de.dev.aoc.year2022.day2.enum

import de.dev.aoc.ResourceLoader


fun main() {
    solveDay2SimpleInputWithEnum()
    solveDay2InputWithEnum()
}


fun solveDay2SimpleInputWithEnum() {
    val strategyGuideStrings: List<String> = ResourceLoader.loadLines("/year2022/day2/simple_input.txt")
    val strategyGuideInstructions: List<StrategyGuideInstruction> = StrategyGuideInstruction.byMoveInput(strategyGuideStrings)
    val score: Int = Game.determineScore(strategyGuideInstructions)
    println("Day 2 - Alternative - Simple Input - Score is: $score")

}

fun solveDay2InputWithEnum() {
    val strategyGuideStrings: List<String> = ResourceLoader.loadLines("/year2022/day2/input.txt")
    val strategyGuideInstructions: List<StrategyGuideInstruction> = StrategyGuideInstruction.byMoveInput(strategyGuideStrings)
    val score: Int = Game.determineScore(strategyGuideInstructions)
    println("Day 2 - Alternative - Simple Input - Score is: $score")
}
