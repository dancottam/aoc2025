import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.Test

class Day03Tests {

    @Test
    fun `Part one max joltage for bank`() {
        assertThat(partOneMaxJoltage("987654321111111")).isEqualTo(98)
        assertThat(partOneMaxJoltage("811111111111119")).isEqualTo(89)
        assertThat(partOneMaxJoltage("234234234234278")).isEqualTo(78)
        assertThat(partOneMaxJoltage("818181911112111")).isEqualTo(92)
    }

    @Test
    fun `Part two max joltage for bank`() {
        assertThat(partTwoMaxJoltage("987654321111111")).isEqualTo(987654321111)
        assertThat(partTwoMaxJoltage("811111111111119")).isEqualTo(811111111119)
        assertThat(partTwoMaxJoltage("234234234234278")).isEqualTo(434234234278)
        assertThat(partTwoMaxJoltage("818181911112111")).isEqualTo(888911112111)
    }

    private fun partTwoMaxJoltage(bank: String): Long {
        TODO("Not yet implemented")
    }

}