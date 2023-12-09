package net.lueckonline.aoc2023.kotlin

class Day8 {

  fun part1(input : List<String>) : Long {

    val iterator = input.iterator()
    val directions = iterator.next().toCharArray()
    val graph = Graph.parse(iterator)

    var currentNode = graph.edges["AAA"]!!
    var counter = 0L;
    var nextNode = ""

    do {
      for (c in directions) {
        nextNode = if (c == 'L') currentNode.first else currentNode.second
        counter++
        currentNode = graph.edges[nextNode]!!
      }
    } while (nextNode != "ZZZ")

    return counter;
  }

  fun part2(input: List<String>): Long {

    val iterator = input.iterator()
    val directions = iterator.next().toCharArray()
    val graph = Graph.parse(iterator)

    var currentNodes = graph.edges.filter { it.key.endsWith('A') }.values.toList()
    var counter = 0L;
    var nextNodes = listOf<String>()

    var endCondition = { nodes : List<String> -> nodes.filter { it.endsWith('Z') }.size == nodes.size }

    do {
      for (c in directions) {
        nextNodes = currentNodes.map { if(c == 'L') it.first else it.second }.toList()
        counter++
        currentNodes = nextNodes.map { graph.edges[it]!! }.toList()
      }
      println("Iteration $counter")
    } while (!endCondition.invoke(nextNodes))

    return counter;
  }

  class Graph (val edges : Map<String, Pair<String, String>>) {

    companion object {

      private val regex = Regex("(.{3}) = \\((.{3}), (.{3})\\)")

      fun parse(lineIterator : Iterator<String>) : Graph {

        val edges = mutableMapOf<String, Pair<String,String>>()
        while (lineIterator.hasNext()) {
          val groups = regex.find(lineIterator.next())?.groups!!
          edges[groups[1]!!.value] = Pair(groups[2]!!.value, groups[3]!!.value)
        }

        return Graph(edges)
      }
    }
  }

}