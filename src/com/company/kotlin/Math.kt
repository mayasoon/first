package com.company.kotlin

import kotlin.concurrent.thread
import kotlin.coroutines.*
/**
 * @author meng
 * @Data 2022/11/26 17:21
 * @Desc
 */

fun main() {
    val numbers = mutableListOf("1",2,"3")
    numbers.add("five")
    var i : Int = 0
    var first : Int = 0

    val t = Thread{
        println(Thread.currentThread().name)
    }
    t.start()

    thread (name = "123"){
        print("456")
    }

}


