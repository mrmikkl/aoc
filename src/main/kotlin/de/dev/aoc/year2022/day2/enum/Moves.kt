package de.dev.aoc.year2022.day2.enum


enum class Moves(val score: Int, vararg val encryptedBy: String) {
    Rock(1, "A", "X") {
        override val winsAgainst: Moves
            get() = Scissor
    },
    Paper(2, "B", "Y") {
        override val winsAgainst: Moves
            get() = Rock
    },
    Scissor(3, "C", "Z") {
        override val winsAgainst: Moves
            get() = Paper
    };

    fun against(otherMove: Moves): Int {
        return when {
            this == otherMove -> Result.DRAW.score
            this == otherMove.winsAgainst -> Result.LOOSE.score
            else -> {
                Result.WIN.score
            }
        }
    }

    abstract val winsAgainst: Moves

    companion object {
        fun byEncrypted(encrypted: String): Moves {
            return Moves.values().find { it.encryptedBy.contains(encrypted) } ?: throw RuntimeException("$encrypted cannot be mapped to Moves")
        }
    }
}
