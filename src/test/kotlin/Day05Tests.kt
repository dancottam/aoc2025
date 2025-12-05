import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.Test

class Day05Tests {

    val input = """
        3-5
        10-14
        16-20
        12-18

        1
        5
        8
        11
        17
        32
    """.trimIndent().lines()

    @Test
    fun `Count fresh ingredients`() {
        assertThat(countFreshIngredients(input)).isEqualTo(3)
    }

    @Test
    fun `Count all fresh ingredient IDs`() {
        assertThat(countAllFreshIngredientIDs(input)).isEqualTo(14)
    }
}