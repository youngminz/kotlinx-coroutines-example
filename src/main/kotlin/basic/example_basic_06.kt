package basic

import kotlinx.coroutines.delay
import kotlinx.coroutines.launch
import kotlinx.coroutines.runBlocking

// World 출력 부분을 suspend fun 으로 추출하기

fun main() = runBlocking {
    // suspend fun 을 호출하면 일시 중단 마크가 뜬다.
    launch { doWorld() }
    println("Hello,")
}

suspend fun doWorld() {
    delay(1000L)
    println("World!")
}
