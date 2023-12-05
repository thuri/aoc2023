package net.lueckonline.aoc2023.kotlin

class Day5 {

  fun part1(input: List<String>): Int {

    val seeds = Regex("\\d+").findAll(input[0]).map { it.value.toInt() }.toList()

    return 0;
  }
}

class AlmanacMap (private val ranges : MutableList<AlmanacRange>) {

  init {
    this.ranges.sortBy { it.sourceRangeStart }
  }
  fun get(sourceCategory: Int) : Int {
    return ranges.firstOrNull() { it.matches(sourceCategory) }?.get(sourceCategory) ?:  sourceCategory
  }
}

class AlmanacRange(
  private val destinationRangeStart: Int,
  val sourceRangeStart: Int,
  private val rangeLength: Int
){

  fun get(sourceCategory: Int) : Int {
    val diff = sourceCategory - sourceRangeStart
    return destinationRangeStart + diff
  }

  fun matches(sourceCategory: Int) : Boolean {
    val diff = sourceCategory - sourceRangeStart
    return diff in 0..<rangeLength
  }
}