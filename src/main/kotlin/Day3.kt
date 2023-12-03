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
}

class Window private constructor(private val lines : Iterator<String>){

  private val queue : ArrayDeque<String> = ArrayDeque()

  private val regex = Regex("(\\d+)")

  private var matcher : Matcher

  init {
    queue.add("")
    queue.add(if (lines.hasNext()) lines.next() else "")
    queue.add(if (lines.hasNext()) lines.next() else "")

    matcher = regex.toPattern().matcher(queue[1])
  }
  companion object {
    fun create(input : String) = Window(input.split("\n").iterator())
  }

  fun next() : Perimeter? {
    return if(matcher.find()) {
      val start = 0.coerceAtLeast(matcher.start() - 1)
      val end   = 140.coerceAtMost(matcher.end() + 1)

      Perimeter(
        queue[0].substring(start.coerceAtMost(queue[0].length), end.coerceAtMost(queue[0].length)),
        queue[1].substring(start.coerceAtMost(queue[1].length), end.coerceAtMost(queue[1].length)),
        queue[2].substring(start.coerceAtMost(queue[2].length), end.coerceAtMost(queue[2].length)),
        matcher.group(1)?.toInt()!!
      )
    } else {
      queue.add(if (lines.hasNext()) lines.next() else "LASTLINE" )
      if ("LASTLINE" == queue.removeFirst()) null else {
        matcher = regex.toPattern().matcher(queue[1])
        next()
      }
    }
  }
}

class Perimeter (inLastLine: String, inCurrentLine: String, inNextLine: String, val number : Int){

  private val text : String

  init {
    text = inLastLine + inCurrentLine + inNextLine
  }

  fun containsSymbols() : Boolean {
    return symbolRegex.find(text) != null
  }

  private companion object {
    val symbolRegex = Regex("[^0-9.]")
  }

}