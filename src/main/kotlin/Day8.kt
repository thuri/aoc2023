package net.lueckonline.aoc2023.kotlin

class Day8 {

  fun part1(input : List<String>) : Long {

    val iterator = input.iterator()
    val directions = iterator.next().toCharArray()
    val graph = Graph.parse(iterator)

    var currentNode = graph.edges["AAA"]!!
    var counter = 0L;
    var nextNode = ""

    while (nextNode != "ZZZ") {
      for (c in directions) {
        nextNode = if (c == 'L') currentNode.first else currentNode.second
        counter++
        if(nextNode === "ZZZ") break;
        currentNode = graph.edges[nextNode]!!
      }
    }

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