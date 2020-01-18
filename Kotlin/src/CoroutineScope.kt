import kotlinx.coroutines.coroutineScope
import kotlinx.coroutines.delay
import kotlinx.coroutines.launch
import kotlinx.coroutines.runBlocking

fun main() = runBlocking<Unit> {
    coroutineScope {
        for (i in 1..10) {
            launch {
                delay(i * 1000L)
                println("$i finished")
            }
        }
        println("Already there")
    }
    println("All done")
}
