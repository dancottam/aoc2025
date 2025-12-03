fun main() {
    fun part1(input: List<String>): Long {
        return input.sumOf { partOneMaxJoltage(it) }
    }

    fun part2(input: List<String>): Long {
        return 0
    }

    // Read the input from the `src/main/resources/Day01.txt` file.
    val input = readInput("Day03")
    part1(input).println()
    part2(input).println()
}

fun partOneMaxJoltage(bank: String): Long {
    var firstDigit = largestDigit(bank)
    var firstDigitPos = bank.indexOf(firstDigit)
    if (firstDigitPos == bank.length - 1) {
        firstDigit = largestDigit(bank.replace(firstDigit, ""))
        firstDigitPos = bank.indexOf(firstDigit)
    }
    val secondDigit = largestDigit(bank.substring(firstDigitPos + 1))
    return (firstDigit + secondDigit).toLong()
}

private fun largestDigit(value: String): String {
    return value.toCharArray().map { it.toString().toLong() }.maxOf { it }.toString()
}