package de.dev.aoc.year2022.day2.enum

class Game {
    companion object {
        fun determineScore(strategyGuideInstructions: List<StrategyGuideInstruction>): Int {
            return strategyGuideInstructions.fold(0) { acc, instruction -> acc + instruction.score() }
        }
    }

}
