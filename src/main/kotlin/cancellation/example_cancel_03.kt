package cancellation

import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.cancelAndJoin
import kotlinx.coroutines.delay
import kotlinx.coroutines.isActive
import kotlinx.coroutines.launch
import kotlinx.coroutines.runBlocking

// 컴퓨팅 루프 내에서 좀 더 유연하게 사용할 수 있는 방식이다.
// 이런 방식은 Exception을 던지지 않는다.
// isActive는 확장 프로퍼티이다.

fun main() = runBlocking {
    val startTime = System.currentTimeMillis()
    val job = launch(Dispatchers.Default) {
        try {
            var nextPrintTime = startTime
            var i = 0
            kotlin.io.println("isActive $isActive")
            while (isActive) { // cancellable computation loop
                // print a message twice a second
                if (System.currentTimeMillis() >= nextPrintTime) {
                    println("job: I'm sleeping ${i++}")
                    nextPrintTime += 500L
                }
            }
            kotlin.io.println("isActive $isActive")

        } catch (e: Exception) {
            kotlin.io.println("Exception $e") // 여기에 도달하지 않는다.
        }

    }

    delay(1300L) // delay a bit
    println("main: I'm tired of waiting!")
    job.cancelAndJoin() // cancels the job and waits for its completion
    println("main: Now I can quit.")
}
