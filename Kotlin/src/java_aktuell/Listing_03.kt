package java_aktuell

import kotlinx.coroutines.*

fun main() {
    val job: Job = GlobalScope.launch {
        println("Waiting 5 seconds")
        delay(5000)
    }
    runBlocking {
        job.join()
    }
    println("Ready")
}
