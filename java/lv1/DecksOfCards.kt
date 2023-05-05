package lv1

import java.util.*

class DecksOfCards {
    fun solution(cards1: Array<String>, cards2: Array<String>, goal: Array<String>): String {
        val deck1 = makeDeck(cards1)
        val deck2 = makeDeck(cards2)
        goal.forEach { card ->
            if (card != deck1.peek() && card != deck2.peek()) {
                return "No"
            }
            if (card == deck1.peek()) deck1.pop()
            if (card == deck2.peek()) deck2.pop()
        }
        return "Yes"
    }

    private fun makeDeck(cards: Array<String>): ArrayDeque<String> {
        val deck = ArrayDeque<String>()
        for (i in cards.indices.reversed()) {
            deck.addFirst(cards[i])
        }
        return deck
    }

}