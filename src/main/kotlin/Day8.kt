package net.lueckonline.aoc2023.kotlin

import java.util.function.Predicate

class Day8 (lines : List<String>){

  private val edges = mutableMapOf<String, Pair<String,String>>()
  private val directions : CharArray
  private val regex = Regex("(.{3}) = \\((.{3}), (.{3})\\)")
  init{
    val iterator = lines.iterator()
    directions = iterator.next().toCharArray()

    while (iterator.hasNext()) {
      val groups = regex.find(iterator.next())?.groups!!
      edges[groups[1]!!.value] = Pair(groups[2]!!.value, groups[3]!!.value)
    }
  }

  private fun shortestPathLength(startNode : String, endCondition : Predicate<String>) : Pair<String, Long> {
    var currentNode = edges[startNode]!!
    var counter = 0L;
    var nextNode = ""

    do {
      for (c in directions) {
        if(currentNode.first == currentNode.second && nextNode == currentNode.first) //dead end like XXX = (XXX,XXX)
          return Pair(startNode, -1L)
        nextNode = if (c == 'L') currentNode.first else currentNode.second
        counter++
        currentNode = edges[nextNode]!!
      }
    } while (!endCondition.test(nextNode))

    return Pair(nextNode,counter)
  }

  fun part1() : Long {
    return shortestPathLength("AAA") { it == "ZZZ" }.second
  }

  fun part2(): Long {

    val shortestPaths = edges
      .filter { it.key.endsWith("A") || it.key.endsWith("Z") }
      .mapValues {
        val shortestPath = shortestPathLength(it.key){ node -> node.endsWith("Z")}
        Pair(shortestPath.first, shortestPath.second / directions.size)
      }

    var nodes = shortestPaths.filter { it.key.endsWith("A") }
    var latestMaxLoops = shortestPaths.maxBy { it.value.second }.value.second
    var previousMaxLoops = 0L

    do {
      previousMaxLoops = latestMaxLoops
      nodes = nodes.mapValues {

        var nextNode = it.value.first
        var currentNodeMax = it.value.second
        while(currentNodeMax < latestMaxLoops) {
          val pathToNextEndNode = shortestPaths[nextNode]!!
          currentNodeMax += pathToNextEndNode.second
          nextNode = pathToNextEndNode.first
        }
        latestMaxLoops = currentNodeMax

        Pair(nextNode, currentNodeMax)
      }
    } while (latestMaxLoops != previousMaxLoops)

    return latestMaxLoops * directions.size;
  }
}