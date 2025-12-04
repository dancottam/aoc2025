import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.Test

class Day04Tests {

    val input = """
        ..@@.@@@@.
        @@@.@.@.@@
        @@@@@.@.@@
        @.@@@@..@.
        @@.@@@@.@@
        .@@@@@@@.@
        .@.@.@.@@@
        @.@@@.@@@@
        .@@@@@@@@.
        @.@.@@@.@.
    """.trimIndent().lines()

    @Test
    fun `Count accessible rolls`() {
        assertThat(countAccessibleRolls(input)).isEqualTo(13)
    }

    @Test
    fun `Remove rolls`() {
        assertThat(removeAllRolls(input)).isEqualTo(43)
    }
}
