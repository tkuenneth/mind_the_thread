import kotlinx.coroutines.delay
// import kotlinx.coroutines.withTimeout

suspend fun main() {
    print("Hello, ")
    hello()
//    print("+")
}

suspend fun hello() {
    delay(1000)
    println("World!")
}