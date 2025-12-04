import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.Test

class Day03Tests {

    @Test
    fun `Part one max joltage for bank`() {
        assertThat(maxJoltage("987654321111111", 2)).isEqualTo(98)
        assertThat(maxJoltage("811111111111119", 2)).isEqualTo(89)
        assertThat(maxJoltage("234234234234278", 2)).isEqualTo(78)
        assertThat(maxJoltage("818181911112111", 2)).isEqualTo(92)
    }

    @Test
    fun `Part two max joltage for bank`() {
        assertThat(maxJoltage("987654321111111", 12)).isEqualTo(987654321111)
        assertThat(maxJoltage("811111111111119", 12)).isEqualTo(811111111119)
        assertThat(maxJoltage("234234234234278", 12)).isEqualTo(434234234278)
        assertThat(maxJoltage("818181911112111", 12)).isEqualTo(888911112111)
    }

}