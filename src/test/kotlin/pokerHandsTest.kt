package com.varokas.kata

import org.junit.Test
import kotlin.test.assertEquals

class PokerHandsTest {
    @Test fun tieWhenSameHands() = assertOutput("tie", "Black: 2H 3D 5S 9C KD  White: 2H 3D 5S 9C KD")

    private fun assertOutput(output: String, input: String):Unit = assertEquals(output, pokerHands(input))
}