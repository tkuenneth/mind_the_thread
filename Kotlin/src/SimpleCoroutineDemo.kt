import kotlinx.coroutines.GlobalScope
import kotlinx.coroutines.delay
import kotlinx.coroutines.launch

fun main() {
    print("Hello, ")
    GlobalScope.launch {
        delay(1000L)
        println("World!")
    }
    Thread.sleep(2000L)
}
