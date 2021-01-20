import kotlinx.coroutines.*
import kotlin.system.measureTimeMillis

fun main() = runBlocking<Unit> {
    println("Took ${
        measureTimeMillis {
            val looper = launch {
                while (isActive) {
                    println("+")
                    delay(500)
                }
            }
            println("result: ${
                async { myFun1() }.await()
                        + async { myFun2() }.await()
            } ")
            looper.cancelAndJoin()
        }
    } ms")
}
