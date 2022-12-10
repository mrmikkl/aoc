package de.dev.aoc.year2022.day2.inheritance

import de.dev.aoc.year2022.day2.inheritance.exception.MissingResultMappingException


enum class Result(val score: Int) {
    LOOSE(0),
    DRAW(3),
    WIN(6);

    companion object {
        fun byEncryption(encryption: String): Result {
            return when (encryption) {
                "X" -> LOOSE
                "Y" -> DRAW
                "Z" -> WIN
                else -> {
                    throw MissingResultMappingException()
                }
            }
        }
    }
}
