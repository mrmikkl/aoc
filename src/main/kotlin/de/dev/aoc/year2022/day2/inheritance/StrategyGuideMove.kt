package de.dev.aoc.year2022.day2.inheritance

class StrategyGuideMove(private val opponentMove: Move, private val myMove: Move) {
    fun determineMyScore(): Int {
        return myMove.determineScore(opponentMove)
    }

    companion object {
        fun byOpponentAndMyMoves(inputs: List<String>): List<StrategyGuideMove> {
            return inputs.map { byOpponentAndMyMoves(it) }
        }

        private fun byOpponentAndMyMoves(input: String): StrategyGuideMove {
            val splittedInput: List<String> = input.split(" ")
            val opponentMove: Move = MoveFactory.byEncryption(splittedInput[0])
            val myMove: Move = MoveFactory.byEncryption(splittedInput[1])
            return StrategyGuideMove(opponentMove, myMove)
        }

        fun byOpponentMoveAndWishedResult(inputs: List<String>): List<StrategyGuideMove> {
            return inputs.map { byOpponentMoveAndWishedResult(it) }
        }

        private fun byOpponentMoveAndWishedResult(input: String): StrategyGuideMove {
            val splittedInput: List<String> = input.split(" ")
            val opponentMove: Move = MoveFactory.byEncryption(splittedInput[0])
            val wishedResult: Result = Result.byEncryption(splittedInput[1])
            val myMove: Move = MoveFactory.byResult(wishedResult, opponentMove)
            return StrategyGuideMove(opponentMove, myMove)
        }
    }

    override fun toString(): String {
        return "SGM(my:$myMove, opp:$opponentMove)"
    }
}
