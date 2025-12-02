import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.Test

class Day02Tests {

    val input = "11-22,95-115,998-1012,1188511880-1188511890,222220-222224,1698522-1698528,446443-446449,38593856-38593862,565653-565659,824824821-824824827,2121212118-2121212124"

    @Test
    fun `Part one find invalid IDs in range`() {
        val range = 11L..22L
        val invalidIds = findInvalidIds(range, PART_ONE_INVALIDATOR)
        assertThat(invalidIds).contains(11L, 22L)
    }

    @Test
    fun `Part one find all invalid IDs`() {
        val invalidIds = findAllInvalidIds(input, PART_ONE_INVALIDATOR)
        assertThat(invalidIds).containsOnly(11L, 22L, 99L, 1010L, 1188511885L, 222222L, 446446L, 38593859L)
    }

    @Test
    fun `Part two find invalid IDs in range`() {
        val range = 95L..115L
        val invalidIds = findInvalidIds(range, PART_TWO_INVALIDATOR)
        assertThat(invalidIds).contains(99L, 111L)
    }

    @Test
    fun `Part two find all invalid IDs`() {
        val invalidIds = findAllInvalidIds(input, PART_TWO_INVALIDATOR)
        assertThat(invalidIds).containsOnly(11L, 22L, 99L, 111L, 999L, 1010L, 1188511885L, 222222L, 446446L, 38593859L, 565656L, 824824824L, 2121212121L)
    }
}