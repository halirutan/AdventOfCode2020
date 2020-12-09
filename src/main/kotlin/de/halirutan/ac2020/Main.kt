package de.halirutan.ac2020

fun main() {

    println("------------------------------")
    println("Day 1")
    println("---------------")
    Day1("/day1.txt").apply {
        solve1()
        solve2()
    }
    println()

    println("------------------------------")
    println("Day 2")
    println("---------------")
    Day2("/day2.txt").apply {
        solve1()
        solve2()
    }
    println()

    println("------------------------------")
    println("Day 3")
    println("---------------")
    Day3("/day3.txt").apply {
        solveA()
        solveB()
    }
    println()

    println("------------------------------")
    println("Day 4")
    println("---------------")
    Day4("/day4.txt").apply {
        solveA()
        solveB()
    }
    println()

    println("------------------------------")
    println("Day 5")
    println("---------------")
    Day5("/day5.txt").apply {
        solveA()
        solveB()
    }
    println()
}