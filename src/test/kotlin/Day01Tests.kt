import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.Test

class Day01Tests {

    val input = """
            L68
            L30
            R48
            L5
            R60
            L55
            L1
            L99
            R14
            L82
        """.trimIndent().lines()

    @Test
    fun `Count zeroes part 1`() {
        val dial = Dial(startPosition = 50)
        val zeroes = dial.partOneCount(input)
        assertThat(zeroes).isEqualTo(3)
    }

    @Test
    fun `Count zeroes part 2`() {
        val dial = Dial(startPosition = 50)
        val zeroes = dial.partTwoCount(input)
        assertThat(zeroes).isEqualTo(6)
    }

}

