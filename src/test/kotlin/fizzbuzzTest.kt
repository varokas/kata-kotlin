package com.varokas.kata

import org.junit.Test
import org.junit.Assert.*

public class FizzBuzzTest {
    @Test fun oneIsOne() = assertEquals("1", fizzbuzz(1))
    @Test fun threeIsFizz() = assertEquals("fizz", fizzbuzz(3))
    @Test fun sixIsFizz() = assertEquals("fizz", fizzbuzz(6))
    @Test fun fiveIsBuzz() = assertEquals("buzz", fizzbuzz(5))
    @Test fun tenIsBuzz() = assertEquals("buzz", fizzbuzz(10))
    @Test fun fifteenIsFizzBuzz() = assertEquals("fizzbuzz", fizzbuzz(15))
    @Test fun thirtyIsFizzBuzz() = assertEquals("fizzbuzz", fizzbuzz(30))
}