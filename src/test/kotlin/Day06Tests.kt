import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.Test

class Day06Tests {

    val input = """
        123 328  51 64 
         45 64  387 23 
          6 98  215 314
        *   +   *   +  
    """.trimIndent().lines()

    @Test
    fun `Solve problems part 1`() {
        val solutions = day6Part1(input)
        assertThat(solutions[0]).isEqualTo(33210)
        assertThat(solutions[1]).isEqualTo(490)
        assertThat(solutions[2]).isEqualTo(4243455)
        assertThat(solutions[3]).isEqualTo(401)
    }

    @Test
    fun `Solve problems part 2`() {
        val solutions = day6Part2(input)
        assertThat(solutions[0]).isEqualTo(1058)
        assertThat(solutions[1]).isEqualTo(3253600)
        assertThat(solutions[2]).isEqualTo(625)
        assertThat(solutions[3]).isEqualTo(8544)
    }
}