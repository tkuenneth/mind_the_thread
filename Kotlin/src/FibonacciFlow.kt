import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.collectIndexed
import kotlinx.coroutines.flow.flow
import kotlinx.coroutines.runBlocking

fun main() = runBlocking {
    fibFlow(10).collectIndexed { index, value ->
        println("fib(${index + 1}) = ${value}")
    }
}

fun fibFlow(n: Int): Flow<Int> = flow {
    var minus2: Int
    var minus1 = 1
    var current = 1
    for (i in 1..n) {
        if (i > 2) {
            minus2 = minus1
            minus1 = current
            current = minus1 + minus2
        }
        emit(current)
    }
}
