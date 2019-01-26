import kotlinx.coroutines.*

fun main() = runBlocking {
    val j1 = fibonacciCoroutine(40)
    println("1")
    val j2 = fibonacciCoroutine(45)
    println("2")
    j1.join()
    j2.join()
    println("Fertig")
}

fun fibonacciCoroutine(n: Int): Job {
    return GlobalScope.launch {
        println("Berechne fib($n)")
        println("fib($n) = ${fibonacci(n)}")
    }
}

fun fibonacci(n: Int): Int {
    if (n <= 1) {
        return n
    } else {
        return fibonacci(n - 1) +
                fibonacci(n - 2)
    }
}