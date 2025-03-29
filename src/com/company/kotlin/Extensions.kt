package com.company.kotlin

/**
 * @author meng
 * @Data 2024/3/18 22:26
 * @Desc partition 快速区分数组里的符合条件的和不符合条件的
 */

fun main() {
    val numbers = listOf(1, 2, 3, 4, 5, 6, 7, 8, 9, 10)
    val (evenNumbers, oddNumbers) = numbers.partition { it % 2 == 0 }

//    println("Even numbers: $evenNumbers")
//    println("Odd numbers: $oddNumbers")
    // Will assign kotlin.Unit
    val isUnit = println("This is an expression")
    println(isUnit)
}