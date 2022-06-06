package cancellation

import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.cancelAndJoin
import kotlinx.coroutines.delay
import kotlinx.coroutines.launch
import kotlinx.coroutines.runBlocking
import kotlinx.coroutines.yield

// 코루틴이 협조적이지 않으면 캔슬이 안 된다.
// delay 같은 suspend fun 이 없다.
// 아래 같은 상황에서는 delay(1L) 혹은 yield() 를 사용하면 협조적인 코드가 된다.
// Job을 Cancel 하면, suspend 되었다가 재개될 때 suspend fun이 exception을 던진다.
// 중간에 종료하기 위해서는 suspend fun 을 호출해야 한다!!!

fun main() = runBlocking {
    val startTime = System.currentTimeMillis()
    val job = launch(Dispatchers.Default) {
        try {
            var nextPrintTime = startTime
            var i = 0
            while (i < 5) { // computation loop, just wastes CPU
                // print a message twice a second
                if (System.currentTimeMillis() >= nextPrintTime) {
                    yield()
                    println("job: I'm sleeping ${i++}")
                    nextPrintTime += 500L
                }
            }
        } catch (e: Exception) {
            kotlin.io.println("Exception $e")
        }
    }
    delay(1300L) // delay a bit
    println("main: I'm tired of waiting!")
    job.cancelAndJoin() // cancels the job and waits for its completion
    println("main: Now I can quit.")
}
