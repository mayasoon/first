package com.company.kotlin

import java.sql.DriverManager
import java.sql.DriverManager.println

/**
 * @author meng
 * @Data 2022/11/20 19:12
 * @Desc
 */
class FirstKotlin {
    var s :Int = 90;
    lateinit var test:Wheel;
    fun test(){
        test = Wheel();
        test.test();
    }
}

fun main() {
    val firstKotlin = FirstKotlin();
    firstKotlin.test();
    val equipment = "fish net" to "catching fish"
    println("${equipment.first} used for ${equipment.second}")

    val ni:String? = null;
    if (ni!=null) {
        print(ni.toUpperCase())
    }
    /**
     * 匿名函数
     * 该函数将 String 当作输入，并将输入 String 的长度作为 Int 类型的输出返回
     */
    val stringLengthFunc: (String) -> Int = {
        input -> input.length;
    }

    val js:Int = stringLengthFunc("Android");
    println(js)
    /**
     * 高阶函数
     * 一个函数可以将另一个函数当作参数。将其他函数用作参数的函数称为“高阶函数”。
     * 此模式对组件之间的通信（其方式与在 Java 中使用回调接口相同）很有用。
     *
     */
    fun stringMapper(str: String, mapper: (String) -> Int): Int {
        // Invoke function
        return mapper(str)
    }
    stringMapper("Android", { input ->
        input.length
    })
    //如果匿名函数是在某个函数上定义的最后一个参数，则您可以在用于调用该函数的圆括号之外传递它，如以下示例所示

    println(stringMapper("Hello Android!") { input ->
        input.length
    })

    for (x in 1..5){
        println(x)
    }
//    val a: Int = 100//有缓存池 -128  128
//    val boxedA: Int? = a
//    val anotherBoxedA: Int? = a
//
//    val b: Int = 10000
//    val boxedB: Int? = b
//    val anotherBoxedB: Int? = b
//
//    println(boxedA === anotherBoxedA) // true
//    println(boxedB === anotherBoxedB) // false

    // 假想的代码，实际上并不能编译：
//    val a: Int? = 1 // 一个装箱的 Int (java.lang.Integer)
//    val b: Long? = a // 隐式转换产生一个装箱的 Long (java.lang.Long)
//    print(b == a) // 惊！这将输出“false”鉴于 Long 的 equals() 会检测另一个是否也为 Long

    val s = "abc"+1
    println(s+"2222")

    val price = """${'$'}9.99
                """

    val s2 = "abc"
    kotlin.io.println("$s2.length is ${s2.length}")
    print(price)
    foo()
    foo2()
    print(3%17)
}
fun foo() {
    listOf(1, 2, 3, 4, 5).forEach lit@{
        if (it == 3) return@lit // 局部返回到该 lambda 表达式的调用者，即 forEach 循环
        print(it)
    }
    print("\ndone with explicit label\n")
}
fun foo2() {
    listOf(1, 2, 3, 4, 5).forEach {
        if (it == 3) return@forEach // 局部返回到该 lambda 表达式的调用者，即 forEach 循环
        print(it)
    }
    print(" done with implicit label")
}
class Car(val wheels:List<Wheel>){
//    private val doorLock:DoorLock
    var gallonsOffFueInTank: Int = 15
        private set


}
class Wheel{
    fun test(){
        print("Wheel test \n")
    }
}
