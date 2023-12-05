package net.lueckonline.aoc2023.kotlin

import kotlin.math.pow

class Day4 {
  fun part1(input: List<String>): Int {

    return input
     .map { Card.create(it).worth() }
     .fold(0) { sum, add -> sum + add}
  }

  fun part2(input : List<String>) : Int {

    return input
      .map { Card.create(it) }
      .reversed()
      .fold(ArrayList<Int>()) { wonCards, card ->
        val power = card.power()
        wonCards.add(0, wonCards.take(power).sum() + power )
        wonCards
      }.sum() + input.size
  }

}

class Card(val id : Int, private val winningNumbers : List<Int>, private val numbersWeHave: List<Int>) {

  fun worth() : Int {
    val power = power()
    return if(power == 0) 0 else 2.0.pow(power.toDouble() -1).toInt()
  }

  fun power(): Int {
    return this.numbersWeHave.sorted()
      .fold(0) { sum, numberToCheck -> sum + if (this.winningNumbers.contains(numberToCheck)) 1 else 0 }
  }

  companion object {
    private val splitRegex = Regex("(\\d+): (.*)")
    private val numberRegex = Regex("(\\d+)")

    fun create(serialized : String) : Card {

      val pipeSplit = serialized.split(Regex("\\|"), 2)

      val groups = splitRegex.find(pipeSplit[0])?.groups!!
      val cardId = groups[1]!!.value.toInt()
      val winningNumbers   = numberRegex.findAll(groups[2]!!.value)
        .map { it.groups[1]?.value?.toInt()!! }
        .sorted()
        .toList()

      val numbersWeHave = numberRegex
        .findAll(pipeSplit[1])
        .map { number -> number.groups[1]?.value?.toInt()!! }.toList()

      return Card(cardId, winningNumbers, numbersWeHave)
    }
  }
}

