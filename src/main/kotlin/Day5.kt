package net.lueckonline.aoc2023.kotlin

import java.util.stream.LongStream

class Day5 {

  fun part1(input: List<String>): Long {

    val lineIterator = input.iterator()
    val seeds = Regex("\\d+").findAll(lineIterator.next()).map { it.value.toLong() }.toList()

    val mapOfMaps = parseInputFile(lineIterator)

    return seeds
      .map { sourceToDestination(it, "seed", mapOfMaps) }
      .minBy { it.first }
      .first
  }

  fun part2(input: List<String>): Long {

    val lineIterator = input.iterator()
    val firstLine = lineIterator.next()
    val mapOfMaps = parseInputFile(lineIterator)

    val seeds = Regex("(\\d+) (\\d+)")
      .findAll(firstLine)
      .map { matchResult ->
        val groups = matchResult.groups
        val start = groups[1]?.value?.toLong()!!
        val range = groups[2]?.value?.toLong()!!

        println("seed range - $start -> ${start +range}")

        LongStream.range(start, start + range)
          .map { sourceToDestination(it, "seed", mapOfMaps).first }
          .min()
          .orElse(0)
      }
      .min()

    return seeds
  }

  private fun parseInputFile(lineIterator: Iterator<String>): MutableMap<String, AlmanacMap> {
    val mapOfMaps = mutableMapOf<String, AlmanacMap>()
    val linesOfMap = mutableListOf<String>()
    for (line in lineIterator) {
      if (line.isBlank() && linesOfMap.isNotEmpty()) {
        buildAlmanacOfCurrentLines(linesOfMap, mapOfMaps)
      } else if (line.isNotBlank()) {
        linesOfMap.add(line)
      }
    }
    buildAlmanacOfCurrentLines(linesOfMap, mapOfMaps)
    return mapOfMaps
  }

  private fun buildAlmanacOfCurrentLines(
    linesOfMap: MutableList<String>,
    mapOfMaps: MutableMap<String, AlmanacMap>
  ) {
    val almanacMap = AlmanacMap.create(linesOfMap)
    mapOfMaps[almanacMap.sourceName] = almanacMap
    linesOfMap.clear()
  }

  private fun sourceToDestination(sourceValue: Long, sourceName: String, mapOfMaps : Map<String, AlmanacMap>) : Pair<Long, String> {

    return if(mapOfMaps.containsKey(sourceName)) {
      val currentMap = mapOfMaps[sourceName]!!
      val destinationValue = currentMap.get(sourceValue)
      sourceToDestination(destinationValue, currentMap.destinationName, mapOfMaps)
    } else {
      Pair(sourceValue, sourceName)
    }
  }
}

class AlmanacMap (val sourceName : String, val destinationName : String, ranges : List<AlmanacRange>) {

  private val ranges : List<AlmanacRange>

  init {
    this.ranges = ranges.sortedBy { it.sourceRangeStart }
  }
  fun get(sourceCategory: Long) : Long {
    return ranges.firstOrNull() { it.matches(sourceCategory) }?.get(sourceCategory) ?:  sourceCategory
  }

  companion object {

    private val mapNameRegex = Regex("(.*)-to-(.*) map:")

    fun create(lines : List<String>) : AlmanacMap {
      val groups = mapNameRegex.find(lines[0])?.groups!!
      return AlmanacMap(
        groups[1]!!.value,
        groups[2]!!.value,
        lines.subList(1, lines.size).map { AlmanacRange.create(it)}.toList()
      )
    }
  }
}

class AlmanacRange(
  private val destinationRangeStart: Long,
  val sourceRangeStart: Long,
  private val rangeLength: Long
){

  fun get(sourceCategory: Long) : Long {
    val diff = sourceCategory - sourceRangeStart
    return destinationRangeStart + diff
  }

  fun matches(sourceCategory: Long) : Boolean {
    val diff = sourceCategory - sourceRangeStart
    return diff in 0..<rangeLength
  }

  companion object {
    private val rangeRegex = Regex("(\\d+) (\\d+) (\\d+)")
    fun create(line: String) : AlmanacRange {
      val groups = rangeRegex.find(line)?.groups!!
      return AlmanacRange(
        groups[1]?.value?.toLong()!!,
        groups[2]?.value?.toLong()!!,
        groups[3]?.value?.toLong()!!
      )
    }
  }
}