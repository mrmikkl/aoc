package de.dev.aoc.year2022.day2.inheritance

private val moveTypeByEncryption: Map<String, Class<out Move>> = mapOf(
    Pair("A", Move.Rock::class.java),
    Pair("X", Move.Rock::class.java),
    Pair("B", Move.Paper::class.java),
    Pair("Y", Move.Paper::class.java),
    Pair("C", Move.Scissor::class.java),
    Pair("Z", Move.Scissor::class.java),
)

private val winningMoveAgainstMove: Map<Class<out Move>, Class<out Move>> = mapOf(
    Pair(Move.Rock::class.java, Move.Paper::class.java),
    Pair(Move.Paper::class.java, Move.Scissor::class.java),
    Pair(Move.Scissor::class.java, Move.Rock::class.java)
)

class MoveFactory private constructor() {
    companion object {
        fun byEncryption(encryption: String): Move {
            return byType(moveTypeByEncryption[encryption])
        }

        fun byResult(wishedResult: Result, opponentMove: Move): Move {
            return when (wishedResult) {
                Result.DRAW -> byType(opponentMove::class.java)
                Result.LOOSE -> byType(winningMoveAgainstMove.entries.find { it.value == opponentMove::class.java }?.key)
                Result.WIN -> byType(winningMoveAgainstMove[opponentMove::class.java])
            }
        }

        private fun byType(clazz: Class<out Move>?): Move {
            return when (clazz) {
                Move.Rock::class.java -> Move.Rock()
                Move.Paper::class.java -> Move.Paper()
                Move.Scissor::class.java -> Move.Scissor()
                else -> {
                    throw MissingMoveMappingException()
                }
            }
        }
    }
}

// `Class<out Move>` is called Declaration-site variance
// means you can only use reading methods of Move
abstract class Move protected constructor(private val score: Int) {
    fun determineScore(otherMove: Move): Int {
        return score +
                if (this.javaClass == otherMove.javaClass)
                    Result.DRAW.score
                else if (this.javaClass == winningMoveAgainstMove[otherMove.javaClass])
                    Result.WIN.score
                else
                    Result.LOOSE.score
    }

    override fun toString(): String {
        return "MOVE(${this::class.java.simpleName}, S:$score)"
    }

    internal class Rock() : Move(1) {
    }

    internal class Paper() : Move(2) {
    }

    internal class Scissor() : Move(3) {
    }
}


