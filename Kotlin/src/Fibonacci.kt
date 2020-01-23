fun main() {
    val fibs = fibList(10)
    for (i in (1..fibs.size - 1)) {
        println("fib($i) = ${fibs[i]}")
    }
}

fun fibList(n: Int): List<Int> {
    val result: MutableList<Int> = ArrayList()
    for (i in (0..n)) {
        result.add(if (i <= 2) 1 else result[i - 1] + result[i - 2])
    }
    return result
}