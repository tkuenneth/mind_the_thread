package java_aktuell

import kotlinx.coroutines.delay
import kotlinx.coroutines.runBlocking

fun main() = runBlocking {
    println("Waiting 5 seconds")
    delay(5000)
    println("Ready")
}
