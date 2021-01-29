package java_aktuell

import kotlinx.coroutines.*

suspend fun main() {
    val job = GlobalScope.launch {
        println("Waiting 5 seconds")
        delay(5000)
    }
    job.join()
    println("Ready")
}
