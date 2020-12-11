package de.halirutan.ac2020

import org.junit.Test

import org.junit.Assert.*

class Day4Test {

    @Test
    fun testContainsAllKeys() {
        Day4("/day4valid.txt").apply {
            passports.map {
                assertTrue(containsAllKeys(it))
            }
        }
    }

    @Test
    fun verifyPassport() {
        Day4("/day4valid.txt").apply {
            passports.map {
                assertTrue(verifyPassport(it))
            }
        }

        Day4("/day4invalid.txt").apply {
            passports.map {
                assertFalse(verifyPassport(it))
            }
        }
    }
}