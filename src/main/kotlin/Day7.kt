package net.lueckonline.aoc2023.kotlin

class Day7 {
  fun part1(input: List<String>): Long {

    return input.map { Hand.parse(it) }
      .sorted()
      .foldIndexed(0L) {index, sum, hand -> sum + (index + 1) * hand.bid}
  }

  enum class Card(val value : Int, val label : Char) {
    ACE(14, 'A'),
    KING(13, 'K'),
    QUEEN(12, 'Q'),
    JACK(11, 'J'),
    TEN(10, 'T'),
    NINE(9, '9'),
    EIGHT(8, '8'),
    SEVEN(7, '7'),
    SIX(6, '6'),
    FIVE(5, '5'),
    FOUR(4, '4'),
    THREE(3, '3'),
    TWO(2, '2');

    companion object {
      private val labelMap = Card.entries.associateBy { it.label }
      fun fromLabel(label: Char) = labelMap[label]
    }
  }
}

class Hand (private val cards : List<Day7.Card>, val bid : Long) : Comparable<Hand>{

  private val groups = cards.groupBy { it.label }

  private val maxGroupSize = this.groups.map { it.value.size }.max()

  companion object {
    private val handRegex = Regex("(.{5}) (\\d+)")
    fun parse(line : String) : Hand {
      val groups = handRegex.find(line)?.groups!!
      return Hand (
        groups[1]!!.value.toCharArray().map { Day7.Card.fromLabel(it)!! }.toList(),
        groups[2]!!.value.toLong()
      )
    }
  }

  override fun compareTo(other: Hand): Int {

    var compareResult = other.groups.size - this.groups.size
    if(compareResult == 0)
      compareResult = this.maxGroupSize - other.maxGroupSize
    if(compareResult == 0) {
      compareResult = firstHighestCard(this.cards, other.cards)
    }
    return compareResult
  }

  private fun firstHighestCard(thisHand: List<Day7.Card>, other: List<Day7.Card>) =
    thisHand
    .mapIndexed { index, card -> card.value.compareTo(other[index].value) }
    .first { it != 0 }
}