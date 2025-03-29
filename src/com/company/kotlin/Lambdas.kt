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

    //(Int) -> Int 为匿名函数类型，参数为int类型，返回值为int类型
    // 输入Int参数返回Int值的常量 = 等号等同于return
    val waterFilter: (Int) -> Int = { dirty -> dirty / 3 }


    println(updateDirty(dirtyLevel, waterFilter))
    println(updateDirty(15, ::increaseDirty))
    /**
     * Kotlin倾向于任何以函数为参数的参数都是最后一个参数。
     * 在处理高阶函数时，Kotlin有一种特殊的语法，称为最后一个参数调用语法，它使代码更加简洁。
     * 在这种情况下，您可以为函数参数传递一个lambda，但不需要将lambda放在括号内。
     */
    dirtyLevel = updateDirty(dirtyLevel) { dirtyLevel -> dirtyLevel + 23}
    println(dirtyLevel)

    highOrder {
        println("1111")
    }
}
fun updateDirty(dirty: Int, operation: (Int) -> Int): Int {
    return operation(dirty)
}
fun update(dirty: Int, operation: (Int) -> String): String {
    return operation(dirty)
}

fun increaseDirty( start: Int ) = start + 1
//一个函数可以将另一个函数当作参数。将其他函数用作参数的函数称为“高阶函数”。
// 此模式对组件之间的通信（其方式与在 Java 中使用回调接口相同）很有用。
fun stringMapper(str: String, mapper: (String) -> Int): Int {
    // Invoke function
    return mapper(str)
}
fun highOrder(name: String? = null,block: () -> Unit) :Unit{
    println(name)
    block.invoke()
    println("HighOderFunction")
}