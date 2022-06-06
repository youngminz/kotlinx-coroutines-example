package basic

import kotlinx.coroutines.GlobalScope
import kotlinx.coroutines.delay
import kotlinx.coroutines.launch
import kotlinx.coroutines.runBlocking

fun main() = runBlocking {
    // launch가 반환하는 것은 Job 객체이다. Job 객체에 join을 걸면 끝날 때까지 기다린다.
    val job = GlobalScope.launch {
        delay(3000L)
        println("World!")
    }

    println("Hello,")
    job.join()
}
