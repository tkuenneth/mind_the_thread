import kotlinx.coroutines.flow.*
import kotlinx.coroutines.runBlocking
import kotlin.system.measureTimeMillis

fun main() = runBlocking<Unit>{
    println("Took ${measureTimeMillis {
            fibFlow(43).collectIndexed { index, value ->  
                    println("fibFlow($index) = $value")
                 false
            }
            
        }
    }} ms")
}

fun fibFlow(i: Int): Flow<Int> = flow {
    emit(if (i <= 2) {
        1
    } else {
        fib(i - 1) + fib(i - 2)
    })
}
