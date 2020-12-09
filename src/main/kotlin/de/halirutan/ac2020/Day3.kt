package de.halirutan.ac2020

class Day3(file: String) {

    private val lines = javaClass.getResource(file).readText().trim().split("\n")

    private data class Point(var x: Int, var y: Int) {
        fun move(length: Int, dx: Int, dy: Int): Point {
            x = (x + dx) % length
            y += dy
            return this
        }
    }

    private val trees = mutableSetOf<Point>()

    init {
        var len: Int
        assert(lines.map { it.length }.also { len = it[0] }.all { it == len })
        lines.mapIndexed { idy, line ->
            line.mapIndexed { idx, c ->
                if (c == '#') {
                    trees.add(Point(idx, idy))
                }
            }
        }
    }

    private fun solve(dx: Int, dy: Int): Int {
        var count = 0
        val pts = Point(0, 0)
        val len = lines[0].length
        for (y in 0..lines.size) {
            if (trees.contains(pts)) {
                count++
            }
            pts.move(len, dx, dy)
        }
        return count
    }

    fun solveA() {
        println("Part 1, number of trees hit: ${solve(3, 1)}")
    }

    fun solveB() {
        val slopes = listOf(
            Pair(1, 1),
            Pair(3, 1),
            Pair(5, 1),
            Pair(7, 1),
            Pair(1, 2)
        )
        val result = slopes.map {
            solve(it.first, it.second)
        }
        println("Intermediate results: $result")
        // Be aware to use long here to prevent overflow
        println("Part 2, multiplied trees hit: ${result.map { it.toLong() }.reduce { acc, v -> acc * v }}")
    }
}

fun main() {
    Day3("/day3.txt").apply {
        solveA()
        solveB()
    }
}