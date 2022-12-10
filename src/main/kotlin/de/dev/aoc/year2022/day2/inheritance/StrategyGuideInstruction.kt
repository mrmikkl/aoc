package de.dev.aoc.year2022.day2.inheritance

class StrategyGuideInstruction(private val opponentMove: Move, private val myMove: Move) {
    fun determineMyScore(): Int {
        return myMove.determineScore(opponentMove)
    }

    companion object {
        fun byOpponentAndMyMoves(inputs: List<String>): List<StrategyGuideInstruction> {
            return inputs.map { byOpponentAndMyMoves(it) }
        }

        private fun byOpponentAndMyMoves(input: String): StrategyGuideInstruction {
            val splittedInput: List<String> = input.split(" ")
            val opponentMove: Move = MoveFactory.byEncryption(splittedInput[0])
            val myMove: Move = MoveFactory.byEncryption(splittedInput[1])
            return StrategyGuideInstruction(opponentMove, myMove)
        }

        fun byOpponentMoveAndWishedResult(inputs: List<String>): List<StrategyGuideInstruction> {
            return inputs.map { byOpponentMoveAndWishedResult(it) }
        }

        private fun byOpponentMoveAndWishedResult(input: String): StrategyGuideInstruction {
            val splittedInput: List<String> = input.split(" ")
            val opponentMove: Move = MoveFactory.byEncryption(splittedInput[0])
            val wishedResult: Result = Result.byEncryption(splittedInput[1])
            val myMove: Move = MoveFactory.byResult(wishedResult, opponentMove)
            return StrategyGuideInstruction(opponentMove, myMove)
        }
    }

    override fun toString(): String {
        return "SGM(my:$myMove, opp:$opponentMove)"
    }
}
