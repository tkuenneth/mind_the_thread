package godot

import kotlinx.coroutines.GlobalScope
import kotlinx.coroutines.delay
import kotlinx.coroutines.launch

suspend fun main() {
    print("Hello, ")
    val job = GlobalScope.launch { hello() }
    while (job.isActive) {
        print("+")
        delay(1000)
    }
}

suspend fun hello() {
    delay(5000)
    println(" World!")
}
