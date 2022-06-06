package basic

import kotlinx.coroutines.GlobalScope
import kotlinx.coroutines.delay
import kotlinx.coroutines.launch
import kotlinx.coroutines.runBlocking

fun main() {
    GlobalScope.launch { // launch a new coroutine in background and continue
        delay(1000L)
        println("World!")
    }

    // delay와 sleep을 맞춰 보기 위한 예제
    // suspend fun은 coroutine scope 혹은 다른 suspend fun 안에서만 실행 가능
    // 따라서 blocking 하는 코루틴을 만들어줘야 한다
    // 그 빌더가 runBlocking
    // launch 처럼 빌더임
    // launch는 자신을 호출하는 쓰레드를 블러킹 하지 않음
    // runBlocking 은 블러킹함
    println("Hello, ") // main thread continues here immediately
    runBlocking {// but this expression blocks the main thread
        delay(2000L) // ... while we delay for 2 seconds to keep JVM alive
    }
}
