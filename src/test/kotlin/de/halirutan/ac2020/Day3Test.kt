package de.halirutan.ac2020

import org.junit.Assert.*
import org.junit.Test

class Day3Test {

    @Test
    fun testSimpleCase() {
        Day3("/day3test.txt").apply {
            assertEquals(7, solve(3, 1))
        }
    }
}