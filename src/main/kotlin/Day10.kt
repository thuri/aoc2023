package net.lueckonline.aoc2023.kotlin

import java.util.Stack
import java.util.Vector
import java.util.function.Consumer

class Day10(line : String) {

  private val lines: List<MutableList<Char>> = line.split("\n")
                   .filter { it.isNotBlank() }
                   .map { it.toCharArray().toMutableList()}

  private var currentPosition : Pair<Int,Int>

  private val stack : Stack<Pair<Int,Int>> = Stack()

  init {
    this.currentPosition = this.lines
      .mapIndexed { index, s -> Pair(index, s.indexOf('S'))}
      .find { it.second != -1 } ?: Pair(-1,-1)
  }

  fun part1(): Long {

    val startPosition = currentPosition
    var counter = 0L
    do {
      val moves = availableMoves();
      if(moves.isNotEmpty()) {
        ++ counter
        replaceField(counter)
        currentPosition = moves[0]
      }
      if(moves.size > 1)
        moves.subList(1, moves.size).forEach(stack::push)
      if(moves.isEmpty() && stack.isNotEmpty())
        currentPosition = stack.pop()
    } while (!stack.empty() && currentPosition != startPosition)

    replaceField(counter)
    return counter / 2 + 1
  }

  private fun replaceField(counter : Long) {
    val current = this.lines[currentPosition.first][currentPosition.second]
    this.lines[currentPosition.first][currentPosition.second] = if (current == '|') '#' else '*'
  }

  fun part2() : Long {
    part1()

    var counter = 0L
    var inOut = 0
    for (line in lines) {
      print('\n')
      for(c in line) {
        print(c)
        if(c == '#') inOut = (++inOut % 2)
        if(c == '.' && inOut == 1) counter ++
      }
    }

    return counter
  }

//  | is a vertical pipe connecting north and south.
//  - is a horizontal pipe connecting east and west.
//  L is a 90-degree bend connecting north and east.
//  J is a 90-degree bend connecting north and west.
//  7 is a 90-degree bend connecting south and west.
//  F is a 90-degree bend connecting south and east.
//  . is ground; there is no pipe in this tile.
//  S is the starting position of the animal; there is a pipe on this tile, but your sketch doesn't show what shape the pipe has.

/*    1        0        1        1         1         0         0         0
    1 S 1    1 - 1    0 | 0    0 L 1     1 J 0     1 7 0     0 F 1     0 . 0
      1        0        1        0         0         1         1         0   */
  private fun getMovementVector(coordinate: Pair<Int,Int>) : List<Int>{

    val field =
      if(   coordinate.first >= this.lines.size
        || coordinate.first  <0
        || coordinate.second >= this.lines[coordinate.first].size
        || coordinate.second <0)
        '.'
      else this.lines[coordinate.first][coordinate.second]
    return when(field) {
      'S' -> listOf(1,1,1,1)
      '-' -> listOf(0,1,0,1)
      '|' -> listOf(1,0,1,0)
      'L' -> listOf(1,1,0,0)
      'J' -> listOf(1,0,0,1)
      '7' -> listOf(0,0,1,1)
      'F' -> listOf(0,1,1,0)
      else -> listOf(0,0,0,0)
    }
  }

  private fun availableMoves() : List<Pair<Int,Int>> {
    val currentFieldVector = getMovementVector(this.currentPosition)

    val north = Pair(this.currentPosition.first - 1, this.currentPosition.second)
    val east  = Pair(this.currentPosition.first, this.currentPosition.second + 1)
    val south = Pair(this.currentPosition.first + 1, this.currentPosition.second)
    val west  = Pair(this.currentPosition.first, this.currentPosition.second - 1)

    val moves = mutableListOf<Pair<Int,Int>>()
    if(currentFieldVector[0] == 1 && getMovementVector(north)[2] == 1)
      moves.add(north)
    if(currentFieldVector[1] == 1 && getMovementVector(east)[3] == 1)
      moves.add(east)
    if(currentFieldVector[2] == 1 && getMovementVector(south)[0] == 1)
      moves.add(south)
    if(currentFieldVector[3] == 1 && getMovementVector(west)[1] == 1)
      moves.add(west)

    return moves
  }

}