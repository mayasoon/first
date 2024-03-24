package com.company.kotlin

/**
 * @author meng
 * @Data 2022/12/13 17:39
 * @Desc
 */

fun main(){
    val school = arrayOf("shark", "salmon", "minnow")
    for (element in school) {
        print(element + "\n")
    }
    for ((index, element) in school.withIndex()) {
        println("Item at $index is $element\n")
    }
    for (i in 1..5) print("${i}\n")

    for (i in 5 downTo 1) print("${i}\n")

    for (i in 3..6 step 2) print("${i}\n")

    for (i in 'd'..'g') print ("${i}\n")

    var bubbles = 0
    while (bubbles < 50) {
        bubbles++
    }
    println("$bubbles bubbles in the water\n")

    do {
        bubbles--
    } while (bubbles > 50)
    println("$bubbles bubbles in the water\n")

    repeat(2) {
        println("A fish is swimming\n")
    }
}