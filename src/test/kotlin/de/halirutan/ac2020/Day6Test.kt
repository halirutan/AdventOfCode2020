package de.halirutan.ac2020

import org.junit.Test

import org.junit.Assert.*

class Day6Test {

    @Test
    fun testNumberOfYes() {
        Day6("/day6test.txt").apply {
            val result = groups.map(::getNumberOfAnyoneYes).toIntArray()
            assertArrayEquals(result, intArrayOf(3, 3, 3, 1, 1))
        }
    }

    @Test
    fun testNumberOfEveryoneYes() {
        Day6("/day6test.txt").apply {
            val result = groups.map(::getNumberOfEveryoneYes).toIntArray()
            assertArrayEquals(result, intArrayOf(3, 0, 1, 1, 1))
        }
    }
}