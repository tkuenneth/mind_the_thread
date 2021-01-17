package godot

import kotlinx.coroutines.*

fun main() = runBlocking {
    print("Hello, ")
    print(async(Dispatchers.Default, start = CoroutineStart.LAZY) {
        wait()
    }.await())
}

suspend fun wait(): String {
    delay(3000)
    return "world!"
}
