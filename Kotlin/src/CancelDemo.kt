import kotlinx.coroutines.cancelAndJoin
import kotlinx.coroutines.delay
import kotlinx.coroutines.launch
import kotlinx.coroutines.runBlocking
import kotlin.system.measureTimeMillis

fun main() = runBlocking {
    println(measureTimeMillis {
        val job = launch {
            println("Enter")
            delay(10000)
            println("Exit")
        }
        delay(3000)
        job.cancelAndJoin()
        println("Cancelled")
    })
}
