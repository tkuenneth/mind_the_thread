import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.channels.ReceiveChannel
import kotlinx.coroutines.channels.consumeEach
import kotlinx.coroutines.channels.produce
import kotlinx.coroutines.runBlocking

fun main() = runBlocking<Unit> {
    myProducer().consumeEach { println(it) }
}

fun CoroutineScope.myProducer(): ReceiveChannel<Int> = produce {
    repeat(5) {
        send((Math.random() * 10).toInt())
    }
}