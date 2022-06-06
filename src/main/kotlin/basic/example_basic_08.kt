package basic

import kotlinx.coroutines.GlobalScope
import kotlinx.coroutines.delay
import kotlinx.coroutines.launch
import kotlinx.coroutines.runBlocking

// GlobalScope 는 마치 데몬 쓰레드 같다.
// 코루틴이 살아 있다고 해서 프로세스를 살려주는 건 아니다
// 또 프로세스가 끝나면 코루틴도 끝난다

fun main() = runBlocking {
    GlobalScope.launch {
        repeat(1000) {i ->
            println("I'm sleeping $i ...")
            delay(500L)
        }
    }
    delay(1300L)
}
