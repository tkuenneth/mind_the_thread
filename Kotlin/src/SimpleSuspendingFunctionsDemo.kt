import kotlinx.coroutines.delay

suspend fun main() {
    print("Hello, ")
    hello()
}

suspend fun hello() {
    delay(1000)
    println("World!")
}