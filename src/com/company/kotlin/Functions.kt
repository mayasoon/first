package com.company.kotlin

import java.util.*    // required import
/**
 * @author meng
 * @Data 2024/3/16 22:36
 * @Desc
 */
class Functions {

}
fun main() {
    // Will assign kotlin.Unit
    val isUnit = println("This is an expression")
    println(isUnit)
    val temperature = 10
    val isHot = if (temperature > 50) true else false
    println(isHot)

    val message = "The water temperature is ${ if (temperature > 50) "too warm" else "OK" }."
    println(message)



    feedTheFish()
//    swim() // 默认参数
//    swim("slow") // 靠位置参数
//    swim(speed = "turtle-like") //名字传递参数

//    println( decorations.filter {it[0] == 'p'})
    // lazy, will wait until asked to evaluate
    val filtered = decorations.asSequence().filter { it[0] == 'p' }
    println("filtered: $filtered")
    // force evaluation of the lazy list
    val newList = filtered.toList()
    println("new list: $newList")
    println("lazy: $lazyMap")
    println("-----")
    println("first: ${lazyMap.first()}")
    println("-----")
    println("all: ${lazyMap.toList()}")

    println("-----lazyMap2")
    println("filtered: ${lazyMap2.toList()}")
}

fun randomDay() : String {
    val week = arrayOf ("Monday", "Tuesday", "Wednesday", "Thursday",
        "Friday", "Saturday", "Sunday")
    return week[Random().nextInt(week.size)]
}
//fun feedTheFish() {
//    val day = randomDay()
//    val food = "pellets"
//    println ("Today is $day and the fish eat $food")
//}

fun fishFood (day : String) : String {
    val food: String = when (day) {
        "Monday" -> "flakes"
        "Tuesday" -> "pellets"
        "Wednesday" -> "redworms"
        "Thursday" -> "granules"
        "Friday" -> "mosquitoes"
        "Saturday" -> "lettuce"
        "Sunday" -> "plankton"
        else -> "nothing"
    }
    return food
}

fun feedTheFish() {
    val day = randomDay()
    val food = fishFood(day)

    println ("Today is $day and the fish eat $food")
    println("Change water: ${shouldChangeWater(day)}")
}
fun swim(speed: String = "fast") {
    println("swimming $speed")
}

fun shouldChangeWater (day: String, temperature: Int = 22, dirty: Int = 20): Boolean {
    return when {
        isTooHot(temperature) -> true
        isDirty(dirty) -> true
        isSunday(day) ->  true
        else -> false
    }
}
//fun shouldChangeWater (day: String, temperature: Int = 22, dirty: Int = getDirtySensorReading()): Boolean {
//    ... 默认值不一定是一个值，也可以是一个fun 函数
fun isTooHot(temperature: Int) = temperature > 30

fun isDirty(dirty: Int) = dirty > 30

fun isSunday(day: String) = day == "Sunday"

val decorations = listOf ("rock", "pagoda", "plastic plant", "alligator", "flowerpot", "fuck", "function")

val lazyMap = decorations.asSequence().map { //延迟家在，访问时才加载
    println("access: $it")
    it
}
val lazyMap2 = decorations.asSequence().filter {it[0] == 'f'}.map {
    println("access: $it")
    it.uppercase()
}

