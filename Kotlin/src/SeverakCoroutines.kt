import kotlinx.coroutines.delay
import kotlinx.coroutines.launch
import kotlinx.coroutines.runBlocking

fun main() {
    runBlocking {
        for (i in 1..10) {
            launch {
                delay(i * 1000L)
                println("$i finished")
            }
        }
    }
    println("all done")
}
