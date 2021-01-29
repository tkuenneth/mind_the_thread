package java_aktuell

import kotlin.concurrent.thread
import kotlin.system.measureTimeMillis

fun main() {
    println(measureTimeMillis {
        val t = thread {
            var a = 0L
            while (true) a += 1
        }
        Thread.sleep(3000)
        t.interrupt()
        println("Interrupted")
    })
}
