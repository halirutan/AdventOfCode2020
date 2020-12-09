package de.halirutan.ac2020

import java.lang.RuntimeException

class Day2(file: String) {
    private val lines: List<String> = javaClass.getResource(file).readText().trim().split("\n")
    private val regex = Regex("(\\d+)-(\\d+) (\\w): (\\w+)")

    private data class LineInfo(val start: Int, val end: Int, val c: Char, val passwd: String)

    private fun parse(line: String): LineInfo {
        val result = regex.find(line)?.groupValues
        result?.let {
            if (result.size == 5) {
                return LineInfo(
                    start = result[1].toInt(),
                    end = result[2].toInt(),
                    c = result[3][0],
                    passwd = result[4]
                )
            }
        }
        throw RuntimeException("Could not parse: $line")
    }

    private fun isValidPasswd(info: LineInfo): Boolean {
        val num = info.passwd.toCharArray().count { it == info.c }
        if (num >= info.start && num <= info.end) {
            return true
        }
        return false
    }

    private fun isValidPasswd2(info: LineInfo): Boolean {
        return (info.passwd[info.start-1] == info.c).xor(info.passwd[info.end - 1] == info.c)
    }

    fun solve1() {
        println("Part 1, number of correct passwords: ${lines.count { isValidPasswd(parse(it))} }")
    }

    fun solve2() {
        println("Part 2, number of correct passwords: ${lines.count { isValidPasswd2(parse(it))} }")
    }

}

fun main() {
    val day2 = Day2("/day2.txt")
    day2.solve1()
    day2.solve2()
}