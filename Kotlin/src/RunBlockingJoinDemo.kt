import kotlinx.coroutines.GlobalScope
import kotlinx.coroutines.delay
import kotlinx.coroutines.launch
import kotlinx.coroutines.runBlocking

fun main() {
    print("Hello, ")
    val job = GlobalScope.launch {
        delay(1000L)
        println("World!")
    }
    runBlocking {
        job.join()
    }
}
