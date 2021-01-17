package godot

import kotlinx.coroutines.GlobalScope
import kotlinx.coroutines.delay
import kotlinx.coroutines.launch

fun main() {
    GlobalScope.launch {
        println("started")
        delay(3000)
        println("finished")
    }
    println("waiting")
    Thread.sleep(4000)
}
