package basic

import kotlin.concurrent.thread
import kotlinx.coroutines.GlobalScope
import kotlinx.coroutines.delay
import kotlinx.coroutines.launch


fun main() {
    // 코루틴은 코루틴 스코프에서 실행된다.
    // GlobalScope는 프로그램이 끝날 때까지 실행되는 전역 스코프이다.
    // launch는 코투린 빌더이다.
    GlobalScope.launch { // launch a new coroutine in background and continue
        delay(1000L) // non-blocking delay for 1 second
        println("World!") // print after delay
    }

    // 위와 동일한 쓰레드 버전
    thread {
        Thread.sleep(1000L)
        println("World!")
    }

    println("Hello,") // main thread continues while coroutine is delayed
    Thread.sleep(2000L) // block main thread for 2 seconds to keep JVM alive
}
