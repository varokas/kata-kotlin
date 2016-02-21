package com.varokas.kata

fun fizzbuzz(x: Int):String = when {
    x % 15 == 0 -> "fizzbuzz"
    x % 3 == 0 -> "fizz"
    x % 5 == 0 -> "buzz"
    else -> x.toString()
}

