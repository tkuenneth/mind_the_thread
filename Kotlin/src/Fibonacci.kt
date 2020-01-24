fun main() {
    val fibs = fibList(10)
    for (i in (1..fibs.size)) {
        println("fib($i) = ${fibs[i - 1]}")
    }
}

fun fibList(n: Int): List<Int> {
    val result: MutableList<Int> = ArrayList()
    for (i in (1..n)) {
        result.add(if (i <= 2) 1 else result[i - 2] + result[i - 3])
    }
    return result
}
