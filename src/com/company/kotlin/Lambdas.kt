package com.company.kotlin

/**
 * @author meng
 * @Data 2024/3/17 10:11
 * @Desc
 */

var dirtyLevel = 20
val waterFilter = { dirty : Int -> dirty / 2}

fun main(){
    println(waterFilter(dirtyLevel))
    val waterFilter: (Int) -> Int = { dirty -> dirty / 3 } //输入Int参数返回Int值的常量

    println(updateDirty(dirtyLevel, waterFilter))
    println(updateDirty(15, ::increaseDirty))
    /**
     * Kotlin倾向于任何以函数为参数的参数都是最后一个参数。
     * 在处理高阶函数时，Kotlin有一种特殊的语法，称为最后一个参数调用语法，它使代码更加简洁。
     * 在这种情况下，您可以为函数参数传递一个lambda，但不需要将lambda放在括号内。
     */
    dirtyLevel = updateDirty(dirtyLevel) { dirtyLevel -> dirtyLevel + 23}
    println(dirtyLevel)
}
fun updateDirty(dirty: Int, operation: (Int) -> Int): Int {
    return operation(dirty)
}
fun update(dirty: Int, operation: (Int) -> String): String {
    return operation(dirty)
}

fun increaseDirty( start: Int ) = start + 1
