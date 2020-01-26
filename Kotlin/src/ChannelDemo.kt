import kotlinx.coroutines.cancelAndJoin
import kotlinx.coroutines.channels.Channel
import kotlinx.coroutines.isActive
import kotlinx.coroutines.launch
import kotlinx.coroutines.runBlocking

fun main() = runBlocking<Unit> {
    val channel = Channel<Int>()
    val job = launch {
        while (isActive) {
            channel.send((Math.random() * 10).toInt())
        }
    }
    repeat(5) {
        println(channel.receive())
    }
    job.cancelAndJoin()
    channel.close()
}