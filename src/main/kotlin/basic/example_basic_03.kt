package basic

import kotlinx.coroutines.GlobalScope
import kotlinx.coroutines.delay
import kotlinx.coroutines.launch
import kotlinx.coroutines.runBlocking

// 좀 더 관용적인 코드
fun main() = runBlocking {
    GlobalScope.launch {
        delay(1000L)
        println("World!")
    }

    println("Hello,")
    delay(2000L)
}
