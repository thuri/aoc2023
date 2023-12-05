package net.lueckonline.aoc2023.kotlin

import kotlin.math.pow

class Day4 {
  fun getWorth(input: String): Int {

    val split = input.split("\n")
    return split
     .filter { it.isNotBlank() }
     .map { it.split(Regex("\\|"), 2) }
     .map { Card.create(it[0]).worth(Regex("(\\d+)").findAll(it[1]).map { number -> number.groups[1]?.value?.toInt()!! }.toList())}
     .fold(0) { sum, add -> sum + add}
  }

}

class Card(private val winningNumbers : List<Int>) {

  fun worth(numbersWeHave : List<Int>) : Int {
    val power = numbersWeHave.sorted()
      .fold(0) {sum, numberToCheck -> sum + if (this.winningNumbers.contains(numberToCheck)) 1 else 0}
    return if(power == 0) 0 else 2.0.pow(power.toDouble() -1).toInt()
  }

  companion object {
    private val splitRegex = Regex(":")
    private val numberRegex = Regex("(\\d+)")

    fun create(serialized : String) : Card {
      val cardNumberString = serialized.split(splitRegex, 2)[1]
      val winningNumbers = numberRegex.findAll(cardNumberString)
        .map { it.groups[1]?.value?.toInt()!! }
        .sorted()
        .toList()

      return Card(winningNumbers)
    }
  }
}

