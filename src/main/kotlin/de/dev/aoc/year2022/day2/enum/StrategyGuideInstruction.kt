package de.dev.aoc.year2022.day2.enum


data class StrategyGuideInstruction(val opponentMove: Moves, val myMove: Moves) {
    fun score(): Int {
        val gameScore: Int = myMove.against(opponentMove)
        val moveScore: Int = myMove.score
        return gameScore + moveScore
    }

    companion object {
        fun byMoveInput(strategyGuideStrings: List<String>): List<StrategyGuideInstruction> {
            return strategyGuideStrings.map { byMoveInput(it) }
        }

        private fun byMoveInput(strategyGuideString: String): StrategyGuideInstruction {
            val splitString = strategyGuideString.split(" ")
            val opponentMove = Moves.byEncrypted(splitString.first())
            val myMove = Moves.byEncrypted(splitString.last())
            return StrategyGuideInstruction(opponentMove, myMove)
        }
    }
}
