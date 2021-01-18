import kotlinx.coroutines.*

fun main() = runBlocking {
    val deferred: Deferred<Unit> = GlobalScope.async {
        println("Started")
        delay(1000)
        throw IllegalArgumentException("I want to crash")
    }
    try {
        deferred.await()
    } catch (e: Exception) {
        println(e.message)
    } finally {
        println("I am finally here")
    }
    println("Finished")
}
