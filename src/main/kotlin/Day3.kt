package net.lueckonline.aoc2023.kotlin

import java.util.regex.Matcher

class Day3 {
  fun part1(input: String): Int {

    val window = Window.create(input)

    var sum = 0
    do {
      val p = window.next()
      sum += if(p?.containsSymbols() == true) p.number else 0
    } while (p != null)

    return sum
  }

  fun part2(input: String): Int {

    val window = Window.create(input)
    val gearMap : MutableMap<Coordinate, MutableList<Int>> = mutableMapOf()

    do {
      val p = window.next()
      p?.gearCoordinates()?.forEach {
        val numbersForGear = gearMap.getOrDefault(it, mutableListOf())
        numbersForGear.add(p.number)
        gearMap[it] = numbersForGear
      }
    } while (p != null)

    return gearMap.filter { it.value.size == 2 }
      .map { it.value.fold(1){ product, factor -> product*factor}}
      .fold(0) { sum, summand -> sum + summand}
  }
}

class Window private constructor(private val lines: Iterator<IndexedValue<String>>){

  private val queue : ArrayDeque<IndexedValue<String>> = ArrayDeque()

  private val regex = Regex("(\\d+)")

  private var matcher : Matcher

  init {
    val padding = ".".repeat(140)
    queue.add(IndexedValue(-1, padding))
    queue.add(if (lines.hasNext()) lines.next() else IndexedValue(0, padding))
    queue.add(if (lines.hasNext()) lines.next() else IndexedValue(1, padding))

    matcher = regex.toPattern().matcher(queue[1].value)
  }
  companion object {
    fun create(input : String) = Window(input.split("\n").filter { it.isNotBlank() }.withIndex().iterator())
  }

  fun next() : Perimeter? {
    return if(matcher.find()) {
      Perimeter(listOf(queue[0], queue[1], queue[2]), matcher.start(), matcher.end(), matcher.group(1).toInt())
    } else {
      queue.add(if (lines.hasNext()) lines.next() else IndexedValue(queue.last().index + 1, "LASTLINE" ))
      if ("LASTLINE" == queue.removeFirst().value) null else {
        matcher = regex.toPattern().matcher(queue[1].value)
        next()
      }
    }
  }
}

class Perimeter(
  private val lines: List<IndexedValue<String>>,
  start: Int,
  end: Int,
  val number: Int
){

  private val text : String
  private val startIdx : Int
  private val endIdx : Int

  init {
    startIdx = 0.coerceAtLeast(start - 1)
    endIdx   = 140.coerceAtMost(end + 1)

    text = lines
      .map{ it.value }
      .map{ it.substring(startIdx.coerceAtMost(it.length), endIdx.coerceAtMost(it.length))}
      .fold("") { text, add -> text + add}
  }

  fun containsSymbols() : Boolean {
    return symbolRegex.find(text) != null
  }

  fun gearCoordinates() : List<Coordinate> {
    val perimeterLength = endIdx - startIdx
    val gearRegex = Regex("\\*")
    return gearRegex.findAll(text)
      .map { it.range.first }
      .map { Coordinate( it % perimeterLength, it / perimeterLength)}
      .map { Coordinate( startIdx + it.x, lines[it.y].index)}
      .toList()
  }

  private companion object {
    val symbolRegex = Regex("[^0-9.]")
  }
}

class Coordinate(val x : Int, val y : Int) {
  override fun toString(): String {
    return "($x,$y)"
  }

  override fun equals(other: Any?): Boolean {
    if(other == null) return false
    if(other is Coordinate) {
      return other.x == x && other.y == y
    }
    return false
  }

  override fun hashCode(): Int {
    var result = x
    result = 31 * result + y
    return result
  }
}