package net.lueckonline.aoc2023.kotlin

class Day7 {
  fun part1(input: List<String>): Long {

    return input.map { Hand.parse(it) }
      .sorted()
      .foldIndexed(0L) {index, sum, hand -> sum + (index + 1) * hand.bid}
  }

  fun part2(input: List<String>): Long {
    return input.map { Hand.parse(it, true) }
      .sorted()
      .foldIndexed(0L) {index, sum, hand -> sum + (index + 1) * hand.bid}
  }

  enum class Card(val value : Int, val label : Char) {
    ACE  (14, 'A'),
    KING (13, 'K'),
    QUEEN(12, 'Q'),
    JACK (11, 'J'),
    TEN  (10, 'T'),
    NINE (9,  '9'),
    EIGHT(8,  '8'),
    SEVEN(7,  '7'),
    SIX  (6,  '6'),
    FIVE (5,  '5'),
    FOUR (4,  '4'),
    THREE(3,  '3'),
    TWO  (2,  '2'),
    JOKER(1,  'J');

    companion object {
      private val labelMap = Card.entries.groupBy { it.label }
      fun fromLabel(label: Char, withJoker: Boolean = false) = labelMap[label]?.filterNot{ it == if(withJoker) JACK else JOKER }?.first!!
    }
  }
}

class Hand (private val cards : List<Day7.Card>, val bid : Long) : Comparable<Hand>{

  private val jokerGroupSize = cards.filter { it == Day7.Card.JOKER }.size

  private val nonJokerGroups = cards.filterNot { it == Day7.Card.JOKER }.groupBy { it.label }

  private val maxGroupSize = this.nonJokerGroups.map { it.value.size }.maxOrNull() ?: 0

  companion object {
    private val handRegex = Regex("(.{5}) (\\d+)")
    fun parse(line : String, withJoker : Boolean = false) : Hand {
      val groups = handRegex.find(line)?.groups!!
      return Hand (
        groups[1]!!.value.toCharArray().map { Day7.Card.fromLabel(it, withJoker) }.toList(),
        groups[2]!!.value.toLong()
      )
    }
  }

  override fun compareTo(other: Hand): Int {

    var compareResult = other.nonJokerGroups.size.coerceAtLeast(1) - this.nonJokerGroups.size.coerceAtLeast(1)
    if(compareResult == 0)
      compareResult = (this.maxGroupSize + this.jokerGroupSize) - (other.maxGroupSize + other.jokerGroupSize)
    if(compareResult == 0) {
      compareResult = firstHighestCard(this.cards, other.cards)
    }

    println("${this.toString()} - ${other.toString()}: $compareResult (${this.nonJokerGroups.size}, ${this.jokerGroupSize}, ${this.maxGroupSize}), (${other.nonJokerGroups.size}, ${other.jokerGroupSize}, ${other.maxGroupSize})")

    return compareResult
  }

  override fun toString() = this.cards.toString()

  private fun firstHighestCard(thisHand: List<Day7.Card>, other: List<Day7.Card>) =
    thisHand
    .mapIndexed { index, card -> card.value.compareTo(other[index].value) }
    .first { it != 0 }
}