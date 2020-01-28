import kotlinx.coroutines.GlobalScope
import kotlinx.coroutines.async
import kotlinx.coroutines.delay
import kotlinx.coroutines.runBlocking

fun main() = runBlocking {
    val deferred = GlobalScope.async {
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