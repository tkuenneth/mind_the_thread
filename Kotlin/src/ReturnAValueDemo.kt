import kotlinx.coroutines.delay
import kotlinx.coroutines.runBlocking
import kotlin.system.measureTimeMillis

fun main() = runBlocking<Unit> {
    println("Took ${measureTimeMillis {
        println("result: ${myFun1() + myFun2()}")
    }} ms")
}

suspend fun myFun1(): Int {
    delay(1000)
    return 1
}

suspend fun myFun2(): Int {
    delay(2000)
    return 2
}
