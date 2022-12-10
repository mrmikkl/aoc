package de.dev.aoc.year2022.day2

class StrategyGuideMove(val opponentMove: Move, val myMove: Move) {
    fun determineMyScore(): Int {
        return myMove.determineScore(opponentMove)
    }

    companion object {
        fun byOpponentAndMyMovesAsString(inputs: List<String>): List<StrategyGuideMove> {
            return inputs.map { byOpponentAndMyMovesAsString(it) }
        }

        private fun byOpponentAndMyMovesAsString(input: String): StrategyGuideMove {
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
            println("opp: $opponentMove, res: $wishedResult, my: $myMove")
            return StrategyGuideMove(opponentMove, myMove)
        }
    }

    override fun toString(): String {
        return "SGM(my:$myMove, opp:$opponentMove)"
    }
}
