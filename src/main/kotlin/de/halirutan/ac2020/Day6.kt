package de.halirutan.ac2020

typealias CustomsGroup = MutableList<CharArray>

class Day6(file: String) {

    val groups = mutableListOf<CustomsGroup>()

    init {
        val text = javaClass.getResource(file).readText().trim()

        var g: CustomsGroup = mutableListOf()
        groups.add(g)

        for (l in text.lineSequence()) {
            if (l.isBlank()) {
                g = mutableListOf()
                groups.add(g)
                continue
            }
            g.add(l.trim().toCharArray())
        }
    }

    fun getNumberOfAnyoneYes(g: CustomsGroup): Int {
        val unique = mutableSetOf<Char>()
        g.forEach {
            unique.addAll(it.asList())
        }
        return unique.size
    }

    fun getNumberOfEveryoneYes(g: CustomsGroup): Int {
        val unique = mutableSetOf<Char>()
        g.forEach {
            unique.addAll(it.asList())
        }
        g.forEach { arr ->
            unique.removeAll { c -> !arr.contains(c) }
        }
        return unique.size
    }

    fun solveA() {
        println("Part 1, the sum of the counts is: ${groups.map(::getNumberOfAnyoneYes).sum()}")
    }

    fun solveB() {
        println("Part 2, the sum of the counts is: ${groups.map(::getNumberOfEveryoneYes).sum()}")
    }
}

fun main() {
    Day6("/day6.txt").apply {
        solveA()
        solveB()
    }
}