package basic

import kotlinx.coroutines.delay
import kotlinx.coroutines.launch
import kotlinx.coroutines.runBlocking

// 코루틴은 10만개를 한 번에 만들어도 느리지 않다. 경량 쓰레드이다.
fun main() = runBlocking {
    repeat(100000) {
        launch {
            delay(1000L)
            print(".")
        }
    }
}
