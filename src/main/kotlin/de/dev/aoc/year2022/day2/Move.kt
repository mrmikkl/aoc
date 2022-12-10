package de.dev.aoc.year2022.day2

private val moveTypeByEncryption: Map<String, Class<out Move>> = mapOf(
    Pair("A", Rock::class.java),
    Pair("X", Rock::class.java),
    Pair("B", Paper::class.java),
    Pair("Y", Paper::class.java),
    Pair("C", Scissor::class.java),
    Pair("Z", Scissor::class.java),
)

private val winningMoveAgainstMove: Map<Class<out Move>, Class<out Move>> = mapOf(
    Pair(Rock::class.java, Paper::class.java),
    Pair(Paper::class.java, Scissor::class.java),
    Pair(Scissor::class.java, Rock::class.java)
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
                Rock::class.java -> Rock()
                Paper::class.java -> Paper()
                Scissor::class.java -> Scissor()
                else -> {
                    throw MissingMoveMappingException()
                }
            }
        }
    }
}

// `Class<out Move>` is called Declaration-site variance
// means you can only use reading methods of Move
abstract class Move(private val encryption: List<String>, private val score: Int) {
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
        return "MOVE(${this::class.java.simpleName}, E:$encryption, S:$score)"
    }
}

class Rock() : Move(listOf("A", "X"), 1) {
}

class Paper() : Move(listOf("B", "Y"), 2) {
}

class Scissor() : Move(listOf("C", "Z"), 3) {
}
