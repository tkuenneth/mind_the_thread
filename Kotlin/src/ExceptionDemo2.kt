import kotlinx.coroutines.CoroutineExceptionHandler
import kotlinx.coroutines.GlobalScope
import kotlinx.coroutines.launch
import kotlinx.coroutines.runBlocking

fun main() = runBlocking {
    val handler = CoroutineExceptionHandler { _, exception ->
        println("Caught $exception")
    }
    val job = GlobalScope.launch(handler) {
        println("Hello launch")
        throw RuntimeException("Hello crash")
    }
    job.join()
    println("join() finished")
}
