fun main() {
    fun part1(input: List<String>): Int {
        return countFreshIngredients(input)
    }

    fun part2(input: List<String>): Long {
        return countAllFreshIngredientIDs(input)
    }
    
    val input = readInput("Day05")
    part1(input).println()
    part2(input).println()
}

fun countFreshIngredients(input: List<String>):Int {
    val splitAt = input.indexOf("")

    val ranges = input.take(splitAt).map { range -> range.split("-").let { LongRange(it.first().toLong(), it.last().toLong()) } }

    val ingredients = input.drop(splitAt + 1)

    return ingredients.count { ingredient ->
        ranges.any { it.contains(ingredient.toLong()) }
    }
}

fun countAllFreshIngredientIDs(input: List<String>): Long {
    val splitAt = input.indexOf("")

    val ranges = input.take(splitAt)
        .map { range -> range.split("-")
        .let { LongRange(it.first().toLong(), it.last().toLong()) } }
        .sortedBy { it.first }

    val merged = mutableListOf<LongRange>()
    for (range in ranges) {
        if (merged.isEmpty() || merged.last().last < range.first) {
            merged.add(range)
        } else {
            val prev = merged.removeLast()
            merged.add(LongRange(prev.first, maxOf(prev.last, range.last)))
        }
    }

    return merged.sumOf { (it.last - it.first) + 1 }
}