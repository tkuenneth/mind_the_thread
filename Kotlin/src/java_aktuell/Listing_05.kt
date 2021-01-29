package java_aktuell

import kotlinx.coroutines.*

fun main(): Unit = runBlocking {
    val deferred = async { returnHello() }
    launch {
        println(deferred.await())
    }
    while (deferred.isActive) {
        println("*")
        delay(1000)
    }
}

suspend fun returnHello(): String {
    delay(3000)
    return "Hello, world!"
}
