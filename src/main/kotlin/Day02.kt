fun main() {
    fun part1(input: List<String>): Long {
        val invalidIds = findAllInvalidIds(input[0], PART_ONE_INVALIDATOR)
        return invalidIds.sum()
    }

    fun part2(input: List<String>): Long {
        val invalidIds = findAllInvalidIds(input[0], PART_TWO_INVALIDATOR)
        return invalidIds.sum()
    }

    // Read the input from the `src/main/resources/Day01.txt` file.
    val input = readInput("Day02")
    part1(input).println()
    part2(input).println()
}

val PART_ONE_INVALIDATOR: (Long) -> Boolean = {
    val strId = it.toString()
    val len = strId.length

    if (len % 2 == 0) {
        val parts = strId.chunked(len / 2)
        parts[0] == parts[1]
    } else {
        false
    }
}

val PART_TWO_INVALIDATOR: (Long) -> Boolean = {
    val strId = it.toString()
    val len = strId.length

    var invalid = false
    for(i in 1..(len/2)) {
        val remainder = strId.replace(strId.take(i), "")
        if (remainder.isEmpty()) {
            invalid = true
            break
        }
    }
    invalid
}

fun findAllInvalidIds(input: String, isInvalid: (Long) -> Boolean): List<Long> {
    val ranges = input.split(",").map {
        val parts = it.split("-")
        LongRange(parts[0].toLong(), parts[1].toLong())
    }

    val invalidIds = mutableListOf<Long>()
    for (range in ranges) {
        invalidIds.addAll(findInvalidIds(range, isInvalid))
    }
    return invalidIds
}

fun findInvalidIds(range: LongRange, isInvalid: (Long) -> Boolean): List<Long> {
    val invalidIds = mutableListOf<Long>()
    for (id in range) {
        if (isInvalid(id)) {
            invalidIds.add(id)
        }
    }
    return invalidIds
}