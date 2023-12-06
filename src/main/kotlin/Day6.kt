package net.lueckonline.aoc2023.kotlin

class Day6 {
  fun part1(input: List<String>): Long {
    return getRacesFromInput(input)
      .map { it.waysToWin() }
      .fold(1L) { product, factor -> product * factor }
  }

  fun part2(input: List<String>): Long {
    return getRacesFromInput(input).map { it.waysToWin() }.first()
  }

  private fun getRacesFromInput(input: List<String>): Sequence<Race> {
    val numberRegex = Regex("\\d+")
    val times = numberRegex.findAll(input[0]).map { it.value.toLong() }
    val durations = numberRegex.findAll(input[1]).map { it.value.toLong() }.toList()

    return times.mapIndexed { index, time -> Race(time, durations[index]) }
  }

}

class Race (private val maxTime : Long, private val record : Long) {
  fun waysToWin() : Long {
    return 0.rangeUntil(maxTime)
      .fold(0) { sum, btnDownTime -> sum + if (wins(btnDownTime)) 1 else 0 }
  }

  private fun wins(btnDownTime : Long) : Boolean {
    return distance(btnDownTime) > record
  }

  private fun distance(btnDownTime: Long) = maxTime * btnDownTime - btnDownTime * btnDownTime
}