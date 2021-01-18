import kotlinx.coroutines.async
import kotlinx.coroutines.delay
import kotlinx.coroutines.runBlocking

fun main() = runBlocking<Unit> {
    async { waiter(2000) }
    println("Result: ${async {
        waiter(3000)
    }.await()}")
}

suspend fun waiter(timeToWait: Long): Long {
    println("Waiting for $timeToWait ms")
    delay(timeToWait)
    return timeToWait
}
