package net.lueckonline.aoc2023.kotlin

fun part1(input : String): Int {
    val bag = Bag(12,13,14)
    return input.split("\n")
      .filter(String::isNotBlank)
      .map(Game::create)
      .filter { it.isValid(bag) }
      .fold(0) {sum, game -> sum + game.id}
}

class Bag private constructor(private val byColor : Map<Color, Int> = mutableMapOf()) {
  constructor(red : Int, green : Int, blue : Int)
    : this(mapOf(Color.red to red, Color.green to green, Color.blue to blue))

  fun forColor(color : Color) : Int = this.byColor.getOrDefault(color, 0)
}

class CubeSet private constructor(val count: Int , val color: Color) {
  companion object {
    private val regex = Regex("(\\d+) (green|blue|red)[,;\\s+]?")
    fun create(serialized : String): CubeSet {
      val groups = regex.find(serialized)?.groups!!
      return CubeSet(
        groups[1]?.value?.toInt()!!,
        Color.valueOf(groups[2]?.value!!)
      )
    }
  }
}

class Game private constructor(val id: Int, private val pulls : List<CubeSet> = listOf()) {
  fun isValid(bag: Bag): Boolean = this.pulls
    .fold(true) { valid, pull -> valid && bag.forColor(pull.color) >= pull.count }

  companion object {
    private val gameRegex = Regex("Game (\\d+):(.*)")
    fun create(line : String) : Game {
      val groups = gameRegex.find(line)?.groups!!
      return Game(
        groups[1]?.value?.toInt()!!,
        groups[2]?.value?.split(",",";")?.map (CubeSet::create)?.toList() ?: listOf()
      )
    }
  }
}

enum class Color {
    red, green, blue
}