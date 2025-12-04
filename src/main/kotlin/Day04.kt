fun main() {
    fun part1(input: List<String>): Int {
        return countAccessibleRolls(input)
    }

    fun part2(input: List<String>): Int {
        return removeAllRolls(input)
    }
    
    val input = readInput("Day04")
    part1(input).println()
    part2(input).println()
}

fun removeAllRolls(input: List<String>): Int {
    val grid = parseGrid(input)
    return removeRolls(grid)
}

fun removeRolls(grid: MutableList<MutableList<Char>>): Int {
    val accessibleRolls = findAccessibleRolls(grid)

    if (accessibleRolls.isNotEmpty()) {
        for(roll in accessibleRolls) {
            grid[roll.y][roll.x] = 'X'
        }
        return accessibleRolls.size + removeRolls(grid)
    }
    return 0
}


fun countAccessibleRolls(input: List<String>): Int {
    val grid = parseGrid(input)
    return findAccessibleRolls(grid).size
}

fun findAccessibleRolls(grid: List<List<Char>>): List<Coordinate> {
    val wrappingPaper = findWrappingPaper(grid)
    return wrappingPaper.filter { isAccessible(it, grid) }
}

private fun isAccessible(coordinate: Coordinate, grid: List<List<Char>>): Boolean {
    val count = coordinate.neighbours().count {
        it.y in grid.indices && it.x in grid[it.y].indices && grid[it.y][it.x] == '@'
    }
    return count < 4
}

private fun findWrappingPaper(grid: List<List<Char>>): List<Coordinate> {
    val wrappingPaper = mutableListOf<Coordinate>()
    for (y in grid.indices) {
        for (x in grid[y].indices) {
            if (grid[y][x] == '@') {
                wrappingPaper.add(Coordinate(x, y))
            }
        }
    }
    return wrappingPaper.toList()
}

private fun parseGrid(lines: List<String>): MutableList<MutableList<Char>> {

    val grid = mutableListOf<MutableList<Char>>()

    for (line in lines) {
        val row = mutableListOf<Char>()

        for (pos in line.toCharArray()) {
            row.add(pos)
        }
        grid.add(row)
    }

    return grid
}

data class Coordinate(
    val x: Int,
    val y: Int
) {
    fun neighbours(): List<Coordinate> {
        return listOf(
            Coordinate(x-1, y-1),
            Coordinate(x-1, y),
            Coordinate(x-1, y+1),
            Coordinate(x, y-1),
            Coordinate(x, y+1),
            Coordinate(x+1, y-1),
            Coordinate(x+1, y),
            Coordinate(x+1, y+1)
        )
    }
}