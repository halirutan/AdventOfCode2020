package de.halirutan.ac2020

typealias PassPort = MutableMap<String, String>

class Day4(file: String) {

    val passports = mutableListOf<PassPort>()

    init {
        val text = javaClass.getResource(file).readText().trim()
        var pass: PassPort = mutableMapOf()
        passports.add(pass)

        for (l in text.lineSequence()) {
            if (l.isBlank()) {
                pass = mutableMapOf()
                passports.add(pass)
                continue
            }
            l.trim().split(" ").forEach {
                val keyVal = it.split(":")
                if (keyVal.size != 2) {
                    throw RuntimeException("Expected Key/Value, got $keyVal")
                }
                pass[keyVal[0]] = keyVal[1]
            }
        }
    }

    fun containsAllKeys(pass: PassPort): Boolean {
        val necessaryKeys = listOf(
            "byr", "iyr", "eyr", "hgt", "hcl", "ecl", "pid"
        )
        return necessaryKeys.fold(true) { acc, key -> acc && pass.containsKey(key) }
    }

    fun solveA() {
        println("Part 1, number of correct passports: ${passports.count(::containsAllKeys)}")
    }

    fun verifyPassport(pass: PassPort): Boolean {
        val yearRegex = Regex("(\\d{4})")
        val heightRegex = Regex("(\\d{2,3})(cm|in)")
        val colorRegex = Regex("#[0-9a-f]{6}")
        val eyeRegex = Regex("amb|blu|brn|gry|grn|hzl|oth")
        val pidRegex = Regex("\\d{9}")
        if (containsAllKeys(pass)) {
            fun yearTest(acc: String, start: Int, end: Int): Boolean {
                if (pass[acc]!!.matches(yearRegex)) {
                    yearRegex.find(pass[acc]!!)!!.groupValues[1].toInt().apply {
                        if (this in start..end) return true
                    }
                }
                return false
            }
            if (!yearTest("byr", 1920, 2002)) return false
            if (!yearTest("iyr", 2010, 2020)) return false
            if (!yearTest("eyr", 2020, 2030)) return false
            if (pass["hgt"]!!.matches(heightRegex)) {
                val find = heightRegex.find(pass["hgt"]!!)
                val height = find!!.groupValues[1].toInt()
                val unit = find.groupValues[2]
                if ("cm" == unit && height !in 150..193) return false
                if ("in" == unit && height !in 59..76) return false
            } else return false
            if (!colorRegex.matches(pass["hcl"]!!)) return false
            if (!eyeRegex.matches(pass["ecl"]!!)) return false
            if (!pidRegex.matches(pass["pid"]!!)) return false
            return true
        }
        return false
    }

    fun solveB() {
        println("Part 2, number of correct passports: ${passports.count(::verifyPassport)}")
    }
}

fun main() {
    Day4("/day4.txt").apply {
        solveA()
        solveB()
    }
}