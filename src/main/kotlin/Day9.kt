package net.lueckonline.aoc2023.kotlin

class Day9 (input : String){

  val input : List<String>
  init {
    this.input = input.split("\n").filter(String::isNotBlank).toList()
  }

  fun part1() : Long {
    return this.input.map(History::parse).sumOf { it.nextValue() }
  }

  fun part2() : Long {
    return 0L;
  }
}

class History (private val values: List<Long>){

  fun nextValue() : Long {

    val diffList = this.values.foldIndexed(mutableListOf<Long>()) { index, sublist, value ->
      if(index != 0)
        sublist.add(value - values[index - 1])
      sublist
    }

    return if(diffList.all { it == 0L })
      this.values.last() + 0L
    else
      this.values.last() + History(diffList).nextValue()
  }

  companion object {
    private val regex = Regex("-?\\d+")
    fun parse(line : String) = History(regex.findAll(line).map { it.value.toLong()}.toList())
  }
}