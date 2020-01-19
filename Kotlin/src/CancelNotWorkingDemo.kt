import kotlinx.coroutines.cancelAndJoin
import kotlinx.coroutines.delay
import kotlinx.coroutines.launch
import kotlinx.coroutines.runBlocking
import kotlin.system.measureTimeMillis

fun main() = runBlocking {
    println(measureTimeMillis {
        val job = launch {
            println("Enter")
            var count = 0
            while (true) {
                println("${++count}")
            }
            println("Exit")
        }
        delay(3000)
        job.cancelAndJoin()
        println("Cancelled")
    })
}
