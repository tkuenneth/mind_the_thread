import kotlinx.coroutines.channels.Channel
import kotlinx.coroutines.launch
import kotlinx.coroutines.runBlocking

fun main() = runBlocking<Unit> {
    val channel = Channel<Int>()
    launch {
        repeat(5) {
            channel.send((Math.random() * 10).toInt())
        }
        channel.close()
    }
    for (i in channel) {
        println(i)
    }
}