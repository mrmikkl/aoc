package de.dev.aoc.year2022.day4

class Range(override val start: Int, override val endInclusive: Int) : ClosedRange<Int>, Iterable<Int> {
    override fun iterator(): Iterator<Int> = RangeIterator(start, endInclusive)
    fun containsCompletely(other: Range): Boolean = other.all { this.contains(it) }
    fun containsPartOf(other: Range): Boolean = other.any { this.contains(it) }
}

class RangeIterator(start: Int, private val end: Int) : Iterator<Int> {
    private var initValue: Int = start
    override fun hasNext(): Boolean = initValue <= end

    override fun next(): Int = initValue++
}
