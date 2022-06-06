package cancellation

import kotlinx.coroutines.delay
import kotlinx.coroutines.launch
import kotlinx.coroutines.runBlocking

fun main() = runBlocking {
    // 1000번을 반복하며 0.5초 간격으로 출력하는 함수
    // cancel() 없는 경우 1000까지 출력함
    // cancel() 있는 경우
    val job = launch {
        repeat(1000) { i ->
            println("job: I'm sleeping $i ...")
            delay(500L)
        }
    }
    delay(1300L)
    println("main: I'm tired of waiting!")
    job.cancel() // 코루틴 취소
    job.join()
    println("main: Now I can quit.")
}

fun <T> println(msg: T) {
    kotlin.io.println("$msg [${Thread.currentThread().name}]")
}
