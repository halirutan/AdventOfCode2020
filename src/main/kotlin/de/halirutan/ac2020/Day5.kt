package de.halirutan.ac2020

class Day5(file: String) {

    private val seatEncodings = javaClass
        .getResource(file)
        .readText()
        .trim()
        .split("\n")

    fun decodeSeatNumber(enc: String): Int {
        val chars = enc.toCharArray()
        assert(chars.size == 10)
        var rowLow = 0
        var rowHigh = 127
        var rowDelta = 64
        for (i in 0..6) {
            when (chars[i]) {
                'F' -> rowHigh -= rowDelta
                'B' -> rowLow += rowDelta
                else -> throw RuntimeException("Row neither 'F' nor 'B'")
            }
            rowDelta /= 2
        }
        assert(rowHigh == rowLow)

        var colLow = 0
        var colHigh = 7
        var colDelta = 4
        for (i in 7..9) {
            when (chars[i]) {
                'L' -> colHigh -= colDelta
                'R' -> colLow += colDelta
                else -> throw RuntimeException("Column neither 'L' nor 'R'")
            }
            colDelta /= 2
        }
        assert(colHigh == colLow)
        return 8 * rowHigh + colHigh
    }

    fun solveA() {
        println("Part 1, maximum seat number: ${seatEncodings.map(::decodeSeatNumber).maxOrNull()}")
    }

    fun solveB() {
        val seatsOccupied = seatEncodings.map(::decodeSeatNumber).sorted()
        val possible = mutableListOf<Int>()
        for (i in 7 until 8 * 128 - 8) {
            if (!seatsOccupied.contains(i) &&
                seatsOccupied.contains(i - 1) &&
                seatsOccupied.contains(i + 1)
            ) {
                possible.add(i)
            }
        }
        println("Part 2, your seat number is $possible")
    }
}

fun main() {
    Day5("/day5.txt").apply {
        solveA()
        solveB()
    }
}