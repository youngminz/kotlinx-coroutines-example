package basic

import kotlinx.coroutines.delay
import kotlinx.coroutines.launch
import kotlinx.coroutines.runBlocking

// 현재 runBlocking과 launch 간의 구조적인 관계를 만드는 것이 Structured Coroutine
// Top level 코루틴을 만들지 말고, runBlocking 코루틴의 child로 코루틴을 만들면
// 부모 코루틴이 자식 코루틴을 기다려 주기 때문에 구조적인 형태를 이용해서 코루틴을 관리해라.

fun main() = runBlocking {
    launch {
        delay(1000L)
        println("World!")
    }

    launch {
        delay(1000L)
        println("World!")
    }

    launch {
        delay(1000L)
        println("World!")
    }

    launch {
        delay(1000L)
        println("World!")
    }

    launch {
        delay(1000L)
        println("World!")
    }

    println("Hello,")
}
