fun main() {
    fun part1(input: List<String>): Long {
        return solveProblems(input).sum()
    }

    fun part2(input: List<String>): Long {
        return 0
    }
    
    val input = readInput("Day06")
    part1(input).println()
    part2(input).println()
}

fun solveProblems(input: List<String>): List<Long> {
    val problems = mutableListOf<MutableList<String>>()

    for (line in input) {
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

fun solveProblem(problem: MutableList<String>): Long {
    return when (problem.last()) {
        "*" -> problem.dropLast(1).map { it.toLong() }.reduce { a, b -> a * b }
        "+" -> problem.dropLast(1).map { it.toLong() }.reduce { a, b -> a + b }
        else -> throw IllegalArgumentException("Unrecognised operation for problem $problem")
    }
}