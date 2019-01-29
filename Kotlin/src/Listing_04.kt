import kotlinx.coroutines.*

fun main() = runBlocking {
    val j1 = async { calcFibonacci(40) }
    println("1")
    val j2 = async { calcFibonacci(45) }
    println("2")
    println("fib(40) = ${j1.await()}")
    println("fib(45) = ${j2.await()}")
    println("Fertig")
}

suspend fun calcFibonacci(n: Int) = withContext(Dispatchers.Default) {
    println("Berechne fib($n)")
    fibonacci(n)
}

fun fibonacci(n: Int): Int {
    return if (n <= 1) {
        n
    } else {
        fibonacci(n - 1) + fibonacci(n - 2)
    }
}