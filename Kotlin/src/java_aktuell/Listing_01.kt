package java_aktuell

import kotlin.concurrent.thread

fun main() {
    thread {
        println("Waiting 5 seconds")
        Thread.sleep(5000)
    }.join()
    println("Ready")
}
