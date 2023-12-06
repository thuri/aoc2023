import net.lueckonline.aoc2023.kotlin.Day6
import org.hamcrest.MatcherAssert
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
    MatcherAssert.assertThat(day.part1(input), `is`(2269432L))
  }

  @Test
  fun shouldFindOptionsToWinExample() {
    MatcherAssert.assertThat(day.part1(inputExample), `is`(288L))
  }

  val inputExample = """
    Time:      7  15   30
    Distance:  9  40  200
  """.trimIndent().split("\n").filter { it.isNotBlank() }

  val input ="""
    Time:        49     78     79     80
    Distance:   298   1185   1066   1181
  """.trimIndent().split("\n").filter { it.isNotBlank() }
}