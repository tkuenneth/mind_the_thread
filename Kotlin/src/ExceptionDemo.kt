import kotlinx.coroutines.launch
import kotlinx.coroutines.runBlocking

fun main() = runBlocking<Unit> {
    val job = launch() {
        println("Hello launch")
        throw RuntimeException("Hello crash")
    }
    job.join()
    // not printed!!!
    println("join() finished")
}