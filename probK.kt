fun main() {
    val s = readln()
    val freq = IntArray(26)
    for (c in s) {
        freq[c - 'a']++
    }

    var g = 0
    for (count in freq) {
        if (count % 2 == 1) {
            g++
        }
    }
    val k = if (g == 0) 1 else g

    val evenList = mutableListOf<Char>()
    val oddList = mutableListOf<Char>()
    for (i in 0 until 26) {
        val c = 'a' + i
        val count = freq[i]
        if (count % 2 == 0) {
            repeat(count / 2) {
                evenList.add(c)
            }
        } else {
            repeat(count / 2) {
                evenList.add(c)
            }
            oddList.add(c)
        }
    }

    if (k == 1) {
        val left = evenList.sorted().joinToString("")
        val center = if (oddList.isNotEmpty()) oddList[0].toString() else ""
        println(1)
        println(left + center + left.reversed())
    } else {
        val left = evenList.sorted().joinToString("")
        val center = oddList[0].toString()
        val palindrome = left + center + left.reversed()
        println(k)
        println(palindrome)
        for (i in 1 until oddList.size) {
            println(oddList[i].toString())
        }
    }
}