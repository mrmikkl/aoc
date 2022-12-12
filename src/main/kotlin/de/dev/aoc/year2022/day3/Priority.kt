package de.dev.aoc.year2022.day3

data class Priority(val value: Int) {
    companion object {
        fun byChar(sharedChar: Char): Priority = Priority(sharedChar.toPriority())
    }
}

private fun Char.toPriority(): Int {
    return if (this.isUpperCase()) {
        this.code - 38
    } else {
        this.code - 96
    }
}
