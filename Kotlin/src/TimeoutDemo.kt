import kotlinx.coroutines.TimeoutCancellationException
import kotlinx.coroutines.runBlocking
import kotlinx.coroutines.withTimeout
import kotlinx.coroutines.yield
import kotlin.system.measureTimeMillis

fun main(): Unit = runBlocking<Unit> {
    println(measureTimeMillis {
        val delay = 2000
        try {
            withTimeout(delay + 1000L) {
                val current = System.currentTimeMillis()
                while ((System.currentTimeMillis() - current) < delay) {
                    yield()
                }
            }
        } catch (e: TimeoutCancellationException) {
            println("I timed out")
        } finally {
            println("finally")
        }
    })
}
