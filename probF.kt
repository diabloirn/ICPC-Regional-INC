import kotlin.math.pow

fun main() {
    val xStr = readln().trim()
    val (l, r) = readln().split(" ").map { it.toInt() }

    val x = xStr.toDouble()

    if (x < l || x > r) {
        println(-1)
        return
    }

    val parts = xStr.split(".")
    val denominator = if (parts.size == 2) {
        10.0.pow(parts[1].length.toDouble()).toLong()
    } else {
        1L
    }

    val numerator = if (parts.size == 2) {
        (parts[0].toLong() * denominator + parts[1].toLong())
    } else {
        parts[0].toLong()
    }

    for (k in 1..1_000_000) {
        val totalNumerator = numerator * k
        if (totalNumerator % denominator != 0L) continue

        val sum = totalNumerator / denominator

        // Cek apakah sum bisa dibuat dengan k rating antara L dan R
        if (sum < k * l || sum > k * r) continue

        // Bangun array
        val ratings = buildArray(k, sum, l, r)
        println(k)
        println(ratings.joinToString(" "))
        return
    }

    println(-1)
}

fun buildArray(k: Int, sum: Long, l: Int, r: Int): List<Int> {
    val result = MutableList(k) { r }
    var excess = k.toLong() * r - sum

    for (i in 0 until k) {
        if (excess == 0L) break
        val reduce = minOf(excess, (r - l).toLong())
        result[i] -= reduce.toInt()
        excess -= reduce
    }

    return result
}