fun main() {
    fun part1(input: List<String>): Long {
        return day6Part1(input).sum()
    }

    fun part2(input: List<String>): Long {
        return day6Part2(input).sum()
    }
    
    val input = readInput("Day06")
    part1(input).println()
    part2(input).println()
}

fun day6Part1(input: List<String>): List<Long> {
    val problems = mutableListOf<MutableList<String>>()

    for (line in input.filter(String::isNotBlank)) {
        val parts = line.trim().split("\\s+".toRegex())
        if (problems.isEmpty()) {
            repeat(parts.size) {
                problems.add(mutableListOf())
            }
        }
        for ((i, part) in parts.withIndex()) {
            problems[i].add(part)
        }
    }

    return problems.map { solveProblem(it) }
}

fun day6Part2(input: List<String>): List<Long> {

    val problems = mutableListOf<MutableList<String>>()

    val maxPos = input[0].length - 1

    problems.add(mutableListOf())

    for (i in maxPos downTo 0) {
        var value = ""
        for (line in input.filter(String::isNotBlank)) {
            value += line[i]
        }
        value = value.trim()

        if (value.isEmpty()) {
            problems.add(mutableListOf())
        } else {
            if (value.last() in listOf('*', '+')) {
                problems.last().add(value.dropLast(1).trim())
                problems.last().add(value.takeLast(1))
            } else {
                problems.last().add(value)
            }
        }
    }

    return problems.map { solveProblem(it) }
}

fun solveProblem(problem: MutableList<String>): Long {
    return when (problem.last()) {
        "*" -> problem.dropLast(1).map { it.toLong() }.reduce { a, b -> a * b }
        "+" -> problem.dropLast(1).map { it.toLong() }.reduce { a, b -> a + b }
        else -> throw IllegalArgumentException("Unrecognised operation for problem $problem")
    }
}