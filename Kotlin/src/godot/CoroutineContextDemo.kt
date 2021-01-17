package godot

import kotlinx.coroutines.CoroutineName
import kotlinx.coroutines.launch
import kotlinx.coroutines.runBlocking

fun main() {
    runBlocking {
        launch(CoroutineName("Hello")) {
            println(coroutineContext.toString())
            launch(CoroutineName("world")) {
                println(coroutineContext.toString())
            }
        }
    }
}