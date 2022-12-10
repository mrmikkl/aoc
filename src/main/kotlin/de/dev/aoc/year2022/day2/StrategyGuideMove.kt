package de.dev.aoc.year2022.day2

class StrategyGuideMove(val opponentMove: Move, val myMove: Move) {
    fun determineMyScore(): Int {
        return myMove.determineScore(opponentMove)
    }

    fun determineOpponentScore(): Int {
        return opponentMove.determineScore(myMove)
    }

    companion object {
        fun byMovesAsString(movesAsStrings: List<String>): List<StrategyGuideMove> {
            return movesAsStrings.map { byMovesAsString(it) }
        }

        private fun byMovesAsString(movesAsString: String): StrategyGuideMove {
            val moves: List<String> = movesAsString.split(" ")
            val opponentMove: Move = Move.byEncryption(moves[0])
            val myMove: Move = Move.byEncryption(moves[1])
            return StrategyGuideMove(opponentMove, myMove)
        }
    }

    override fun toString(): String {
        return "SGM(my:$myMove, opp:$opponentMove)"
    }
}
