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
    val gearMap : Map<Coordinate, MutableList<Int>> = mutableMapOf()

    do {
      val p = window.next()
      p?.gearCoordinates()?.forEach {
        gearMap.getOrDefault(it, mutableListOf()).add(p.number)
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
    queue.add(IndexedValue(-1, ""))
    queue.add(if (lines.hasNext()) lines.next() else IndexedValue(0,""))
    queue.add(if (lines.hasNext()) lines.next() else IndexedValue(1, ""))

    matcher = regex.toPattern().matcher(queue[1].value)
  }
  companion object {
    fun create(input : String) = Window(input.split("\n").withIndex().iterator())
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
  val start: Int,
  val end: Int,
  val number: Int
){

  private val text : String

  init {
    val startIdx = 0.coerceAtLeast(start - 1)
    val endIdx   = 140.coerceAtMost(end + 1)

    text = lines
      .map{ it.value }
      .map{ it.substring(startIdx.coerceAtMost(it.length), endIdx.coerceAtMost(it.length))}
      .fold("") { text, add -> text + add}
  }

  fun containsSymbols() : Boolean {
    return symbolRegex.find(text) != null
  }

  fun gearCoordinates() : List<Coordinate> {
    TODO("Not yet implemented")
  }

  private companion object {
    val symbolRegex = Regex("[^0-9.]")
  }
}

class Coordinate(x : Int, y : Int)