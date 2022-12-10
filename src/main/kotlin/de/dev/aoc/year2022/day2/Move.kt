package de.dev.aoc.year2022.day2

// `Class<out Move>` is called Declaration-site variance
// means you can only use reading methods of Move
abstract class Move(private val encryption: List<String>, private val winsAgainst: Class<out Move>, private val score: Int) {
    companion object {
        fun byEncryption(encryption: String): Move {
            return when (encryption) {
                "A", "X" -> Rock()
                "B", "Y" -> Paper()
                "C", "Z" -> Scissor()
                else -> throw MissingMoveMappingException()
            }
        }
    }

    fun determineScore(otherMove: Move): Int {
        return score +
                if (this.javaClass == otherMove.javaClass)
                    Result.DRAW.score
                else if (this.winsAgainst == otherMove.javaClass)
                    Result.WIN.score
                else
                    Result.LOOSE.score
    }

    override fun toString(): String {
        return "MOVE(${this::class.java.simpleName}, E:$encryption, W:${winsAgainst.simpleName}, S:$score)"
    }
}

class Rock() : Move(listOf("A", "X"), Scissor::class.java, 1) {
}

class Paper() : Move(listOf("B", "Y"), Rock::class.java, 2) {
}

class Scissor() : Move(listOf("C", "Z"), Paper::class.java, 3) {
}
