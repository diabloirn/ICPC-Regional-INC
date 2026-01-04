data class Contestant(
    val name: String,
    val totalPoints: Int,
    val totalPenalty: Int
)

fun main() {
    val n = readln().toInt()

    val contestants = List(n) {
        val input = readln().split(" ")
        val name = input[0]
        val a = input[1].toInt()
        val b = input[2].toInt()
        val c = input[3].toInt()
        val d = input[4].toInt()

        Contestant(name, a + c, b + d)
    }

    contestants
        .sortedWith(compareBy(
            { -it.totalPoints },
            { it.totalPenalty },
            { it.name }))
        .forEach { println(it.name) }
}