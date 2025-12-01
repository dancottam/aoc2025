fun main() {
    fun part1(input: List<String>): Int {
        val dial = Dial(startPosition = 50)
        return dial.partOneCount(input)
    }

    fun part2(input: List<String>): Int {
        val dial = Dial(startPosition = 50)
        return dial.partTwoCount(input)
    }

    // Read the input from the `src/main/resources/Day01.txt` file.
    val input = readInput("Day01")
    part1(input).println()
    part2(input).println()
}

class Dial(startPosition: Int) {

    val min = 0
    val max = 99

    val stepsInFullRotation = (max - min) + 1

    var position = startPosition

    private var partOneCount = 0
    private var partTwoCount = 0

    fun partOneCount(rotations: List<String>): Int {
        rotate(rotations)
        return partOneCount
    }

    fun partTwoCount(rotations: List<String>): Int {
        rotate(rotations)
        return partTwoCount
    }

    private fun rotate(rotations: List<String>) {
        for (rotation in rotations) {
            rotate(rotation)
        }
    }

    private fun rotate(rotation: String) {
        val direction = rotation[0]
        val distance = rotation.substring(1).toInt()

        repeat(distance) {
            position = (
                    if (direction == 'L')
                        (position - 1 + stepsInFullRotation) % stepsInFullRotation
                    else
                        (position + 1 + stepsInFullRotation) % stepsInFullRotation
                    )

            if (position == 0) {
                partTwoCount++
            }
        }

        if (position == 0) {
            partOneCount++
        }
    }
}