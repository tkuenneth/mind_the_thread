import kotlinx.coroutines.*

fun main() = runBlocking {
    launch {
        helloAndLaunch()
    }
    print("Hello, ")
}

suspend fun helloAndLaunch() {
    delay(2000)
    println("World")
    GlobalScope.launch {
        println("GlobalScope.launch()")
    }
}