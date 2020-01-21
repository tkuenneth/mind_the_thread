import kotlinx.coroutines.CancellationException
import kotlinx.coroutines.delay
import kotlinx.coroutines.launch
import kotlinx.coroutines.runBlocking

fun main() = runBlocking {
    val job = launch {
        val delay = 2000
        val current = System.currentTimeMillis()
        while ((System.currentTimeMillis() - current) < delay) {
        }
        throw CancellationException("I would like to cancel myself")
    }
    delay(1000)
    job.join()
    println(job.isActive)
    println(job.isCancelled)
    println(job.isCompleted)
}
