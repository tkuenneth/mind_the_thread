import kotlin.system.measureTimeMillis

fun main() {
    println("Took ${measureTimeMillis {
        for (i in 40..43) {
            println("fib($i) = ${fib(i)}")
        }
    }} ms")
}

fun fib(i: Int): Int {
    return if (i <= 2) {
        1
    } else {
        fib(i - 1) + fib(i - 2)
    }
}