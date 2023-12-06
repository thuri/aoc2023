import net.lueckonline.aoc2023.kotlin.Day6
import org.hamcrest.MatcherAssert.assertThat
import org.hamcrest.Matchers.`is`
import org.junit.jupiter.api.BeforeEach
import org.junit.jupiter.api.Test

class Day6Test {

  lateinit var day : Day6
  @BeforeEach
  fun setUp() {
   day = Day6()
  }

  @Test
  fun shouldFindOptionsToWin() {
    assertThat(day.part1(input), `is`(2269432L))
  }

  @Test
  fun shouldFindOptionsToWinExample() {
    assertThat(day.part1(inputExample), `is`(288L))
  }

  @Test
  fun shouldFindOptionsToWinSingleRace() {
    assertThat(day.part2(input_part2), `is`(35865985L))
  }

  @Test
  fun shouldFindOptionsToWinSingleRaceExample() {
    assertThat(day.part2(input_part2_example), `is`(71503L))
  }

  val inputExample = """
    Time:      7  15   30
    Distance:  9  40  200
  """.trimIndent().split("\n").filter { it.isNotBlank() }

  val input ="""
    Time:        49     78     79     80
    Distance:   298   1185   1066   1181
  """.trimIndent().split("\n").filter { it.isNotBlank() }

  val input_part2_example="""
    Time:      71530
    Distance:  940200
  """.trimIndent().split("\n").filter { it.isNotBlank() }

  val input_part2 ="""
    Time:        49787980
    Distance:   298118510661181
  """.trimIndent().split("\n").filter { it.isNotBlank() }

}