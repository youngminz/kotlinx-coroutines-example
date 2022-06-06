package basic

import kotlinx.coroutines.delay
import kotlinx.coroutines.launch
import kotlinx.coroutines.runBlocking

fun main() = runBlocking { // 첫 번째 코루틴
    launch { // 두 번째 코루틴
        repeat(5) { i ->
            println("Coroutine A, $i")
            delay(10L)
        }
    }

    launch {// 세 번째 코루틴
        repeat(5) { i ->
            println("Coroutine B, $i")
            delay(10L)
        }
    }

    println("Coroutine Outer")
}

fun <T>println(msg: T) {
    kotlin.io.println("$msg [${Thread.currentThread().name}]")
}
