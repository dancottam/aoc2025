fun main() {
    fun part1(input: List<String>): Long {
        return countSplitBeams(input)
    }

    fun part2(input: List<String>): Long {
        return countPossibleRoutes(input)
    }
    
    val input = readInput("Day07")
    part1(input).println()
    part2(input).println()
}

fun countSplitBeams(input: List<String>): Long {
    val diagram = input.filter { it.isNotBlank() }.map { it.toCharArray() }
    val traced = mutableListOf<CharArray>()

    var count = 0L

    for ((r, row) in diagram.withIndex()) {
        if (r > 0) {
            val prevRow = traced[r - 1]
            val newRow = charArrayOf(*row)

            for (c in row.indices) {
                val char = row[c]
                if (prevRow[c] == 'S' || prevRow[c] == '|') {
                    if (char == '^') {
                        if (c > 0) newRow[c-1] = '|'
                        if (c+1 < row.size) newRow[c+1] = '|'
                        count++
                    } else {
                        newRow[c] = '|'
                    }
                }
            }
            traced.add(newRow)
        } else {
            traced.add(row)
        }
    }
    return count
}

fun countPossibleRoutes(input: List<String>): Long {
    val diagram = input.filter { it.isNotEmpty() }
    val start = Pair(0, diagram.first().indexOf('S'))

    val cache = mutableMapOf<Pair<Int, Int>, Long>()

    fun depthFirstSearch(point: Pair<Int, Int>): Long {
        val (row, col) = point

        if (row !in diagram.indices || col !in diagram[row].indices) return 0L

        if (row == diagram.lastIndex) return 1L

        cache[point]?.let { return it }

        val nextSteps = if (diagram[row][col] == '^') {
            listOf(Pair(row, col - 1), Pair(row, col + 1))
        } else {
            listOf(Pair(row + 1, col))
        }

        // Sum all possible routes from next steps
        val totalRoutes = nextSteps.sumOf { depthFirstSearch(it) }

        cache[point] = totalRoutes
        return totalRoutes
    }

    return depthFirstSearch(start)
}
