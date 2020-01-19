import kotlinx.coroutines.*
import kotlin.system.measureTimeMillis

fun main() = runBlocking {
    println(measureTimeMillis {
        val job = launch {
            println("Enter")
            var count = 0
            while (isActive) {
                println("${++count}")
                yield()
            }
            println("Exit")
        }
        delay(3000)
        job.cancelAndJoin()
        println("Cancelled")
    })
}
