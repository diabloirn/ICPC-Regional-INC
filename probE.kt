fun main() {
    val (n, q) = readln().split(' ').map { it.toInt() }
    var s = 1
    while (s < n) s = s shl 1
    val tree = Array(2 * s) { IntArray(16) }

    for (i in tree.indices) {
        for (j in 0 until 16) {
            tree[i][j] = j
        }
    }

    fun combine(f: IntArray, g: IntArray, res: IntArray) {
        for (i in 0 until 16) {
            res[i] = g[f[i]]
        }
    }

    fun updateNode(node: IntArray, op: String, k: Int) {
        for (x in 0 until 16) {
            node[x] = when (op) {
                "+" -> (x + k) % 16
                else -> x xor k
            }
        }
    }

    for (i in 0 until n) {
        val (op, kStr) = readLine()!!.split(' ')
        updateNode(tree[s + i], op, kStr.toInt())
    }

    for (i in s - 1 downTo 1) {
        combine(tree[2 * i], tree[2 * i + 1], tree[i])
    }

    val output = StringBuilder()
    repeat(q) {
        val (iStr, op, kStr) = readLine()!!.split(' ')
        val idx = s + iStr.toInt() - 1
        updateNode(tree[idx], op, kStr.toInt())

        var pos = idx
        while (pos > 1) {
            pos = pos shr 1
            combine(tree[2 * pos], tree[2 * pos + 1], tree[pos])
        }
        output.appendLine(tree[1][0])
    }
    print(output)
}