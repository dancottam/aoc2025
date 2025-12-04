fun main() {
    fun part1(input: List<String>): Long {
        return input.sumOf { maxJoltage(bank = it, numBatteries = 2) }
    }

    fun part2(input: List<String>): Long {
        return input.sumOf { maxJoltage(bank = it, numBatteries = 12) }
    }

    val input = readInput("Day03")
    part1(input).println()
    part2(input).println()
}

fun maxJoltage(bank: String, numBatteries: Int): Long {

    var startIndex = 0
    var endIndex = bank.length - numBatteries

    var maxJoltage = ""
    repeat(numBatteries) {
        endIndex++
        val digit = bank.substring(startIndex, endIndex).toCharArray().maxOf { it.toString().toInt() }
        startIndex = bank.indexOf(digit.toString(), startIndex) + 1
        maxJoltage += digit
    }
    return maxJoltage.toLong()
}