package com.varokas.kata

data class PokerHand(val blacks:List<String>, val whites:List<String>)

fun pokerHands(input: String):String {
    val tokens = input.trim().split(" ").filter{ !it.equals("") }.map{ it.trim() }
    val hands = parseHands(tokens)

    return when {
        hands.blacks.equals(hands.whites) -> "tie"
        else -> "undefined"
    }
}

private fun parseHands(tokens: List<String>): PokerHand {
    val blacks = arrayListOf<String>()
    val whites = arrayListOf<String>()

    var readToList = blacks
    for (token in tokens) {
        when (token) {
            "Black:" -> readToList = blacks
            "White:" -> readToList = whites
            else -> readToList.add(token)
        }
    }

    return PokerHand(blacks, whites)
}
