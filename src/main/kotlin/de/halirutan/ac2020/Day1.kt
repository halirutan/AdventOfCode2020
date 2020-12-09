package de.halirutan.ac2020

class Day1(file: String) {

    private val nums : List<Long>

    init {
        val input = javaClass.getResource(file).readText().trim()
        nums = input.split("\n").map {
            it.toLong()
        }
    }

    fun solve1() {
        for (i in nums.indices) {
            for (j in i until nums.size) {
                if (nums[i] + nums[j] == 2020L) {
                    println("Part 1, correct answer is: ${nums[i] * nums[j]}")
                    return
                }
            }
        }
        throw RuntimeException("Could not find solution")
    }

    fun solve2() {
        for (i in nums.indices) {
            for (j in i until nums.size) {
                for (k in j until nums.size) {
                    if (nums[i] + nums[j] + nums[k] == 2020L) {
                        println("Part 2, correct answer is: ${nums[i] * nums[j] * nums[k]}")
                        return
                    }
                }
            }
        }
        throw RuntimeException("Could not find solution")
    }
}

fun main() {
    Day1("/day1.txt").apply {
        solve1()
        solve2()
    }
}