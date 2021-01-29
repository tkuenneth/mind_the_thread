package java_aktuell

import kotlinx.coroutines.*
import kotlin.system.measureTimeMillis

fun main() = runBlocking {
    println(measureTimeMillis {
        val t = launch(Dispatchers.IO) {
            var a = 0L
            while (true)
                a += 1
        }
        delay(3000)
        t.cancelAndJoin()
        println("Cancelled")
    })
}
