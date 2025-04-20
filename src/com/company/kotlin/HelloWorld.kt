package com.company.kotlin

import sun.security.provider.Sun
import java.util.*

/**
 * @author meng
 * @Data 2025/4/15 20:44
 * @Desc
 */

fun main() {
    val msg: String = "Hello World"
    println(msg)
    val i = 10
    i.and(11)
    //基本数据类型-----------------------------------------
    //kotlin中一切都是对象
    //在 kotlin 中，int、long、float 等类型仍然存在，但是是作为对象存在的
    //数字、字符和布尔值可以在运行时表示为原生类型值，但对开发者来说，它们看起来就像普通的类
    //对于数字没有隐式拓宽转换，而在 Java 中 int 可以隐式转换为 long
    //所有未超出 Int 最⼤值的整型值初始化的变量都会自动推断为 Int 类型，如果初始值超过了其最⼤值，则会推断为 Long 类型， 如需显式指定 Long 类型值可在该值后追加 L 后缀
    //字符不能视为数字
    //不支持八进制

    val intIndex: Int = 100
    //等价于，编译器会自动进行类型推导
//    val intIndex = 100

    //数字类型不会自动转型，必须要进行明确的类型转换
    val doubleIndex: Double = intIndex.toDouble()
    //以下代码会提示错误，需要进行明确的类型转换
    //val doubleIndex: Double = intIndex

    val intValue: Int = 1
    val longValue: Long = 1
    //以下代码会提示错误，因为两者的数据类型不一致，需要转换为同一类型后才能进行比较
    //println(intValue == longValue)

    //Char 不能直接作为数字来处理，需要主动转换
    val ch: Char = 'c'
    val charValue: Int = ch.toInt()
    //以下代码会提示错误
    //val charValue: Int = ch

    //二进制
    val value1 = 0b00101
    //十六进制
    val value2 = 0x123
    //基本数据类型, 如果值为100，则intValue_2 === intValue_3为ture，涉及到java对包装类对象对复用，小于125常量池
    val intValue_1: Int = 200
    //包装类
    val intValue_2: Int? = intValue_1
    val intValue_3: Int? = intValue_1
    //== 比较的是数值相等性，因此结果是 true
    println(intValue_2 == intValue_3)
    //=== 比较的是引用是否相等，因此结果是 false
    println(intValue_2 === intValue_3)

//    mainString()
//    mainArray()
//    mainAny()

    val names = arrayOf("111", "222", "33333")

//    computeStr(* names)
//    mainIf()
//    funWhen()
//    mainFor()
//    funLabel()
//    check(1)
//    Point(1, 1)
//    Point(100)
//    Point(200L)

//    mainUser()
//    mainEnum()
//    mainSuper()
//    lambdaMain()
//    main8()
//    main9()

//    main10()

    main14()
}

fun mainString() {
    //kotlin 与 Java 一样用 String 类型来表示字符串，字符串是不可变的，可以使用索引运算符访问[] 来访问包含的单个字符，
    //也可以用 for 循环来迭代字符串，此外也可以用 + 来连接字符串
    //字符串 --------------------------------------------------
    val str = "leavesC"
    println(str[1])
    for (c in str) {
        println(c)
    }
    val str1 = str + " hello"
    println(str1)
    //kotlin 支持在字符串字面值中引用局部变量，只需要在变量名前加上字符 $ 即可，
    //此外还可以包含用花括号括起来的表达式，此时会自动求值并把结果合并到字符串中
    val intValue = 100
    //可以直接包含变量
    println("intValue value is $intValue") //intValue value is 100
    //也可以包含表达式
    println("(intValue + 100) value is ${intValue + 100}")   //(intValue + 100) value is 200

}

fun mainArray() {
    //包含给定元素的字符串数组
    val array1 = arrayOf("leavesC", "叶", "https://github.com/leavesC")

    array1[0] = "leavesC"
    println(array1[1])
    println(array1.size)

    //初始元素均为 null ，大小为 10 的字符数组
    val array2 = arrayOfNulls<String>(10)

    //创建从 “a” 到 “z” 的字符串数组
    //声明 Array< Int > 将是一个包含装箱类型（java.lang.Integer）的数组
    val array3 = Array(26) { i -> ('a' + i).toString() }
    println(array3.size)
    //为了表示基本数据类型的数组，kotlin 为每一种基本数据类型都提供了若干相应的类并做了特殊的优化
    //IntArray、ByteArray、BooleanArray
    //指定数组大小，包含的元素将是对应基本数据类型的默认值(int 的默认值是 0)
    val intArray = IntArray(5)
    //指定数组大小以及用于初始化每个元素的 lambda
    val doubleArray = DoubleArray(5) { Random().nextDouble() }
    //接收变长参数的值来创建存储这些值的数组
    val charArray = charArrayOf('H', 'e', 'l', 'l', 'o')

}

fun mainAny() {
    //Any 类型是 kotlin 所有非空类型的超类型，包括像 Int 这样的基本数据类型
    //如果把基本数据类型的值赋给 Any 类型的变量，则会自动装箱
    val any: Any = 100
    println(any.javaClass) //class java.lang.Integer
    val any1: Any? = null
    // Unit
    //kotlin 中的 Unit 类型类似于 Java 中的 void，可以用于函数没有返回值时的情况
//    fun check(): Unit {
//    }

    //如果返回值为 Unit，则可以省略该声明
//    fun check() {
//    }
}

fun mainFun() {
    compute(age = 10)
    compute(age = 20, name = "111", value = 22)
    compute(age = 111)
    compute(value = 2)
}

/**
 * 默认参数可省略
 */
fun compute(name: String = "abc", age: Int = 11, value: Int = 20) {

}

/**
 * 可变参数
 */
fun computeStr(vararg name: String) {
    println("computeStr-----------------------------------")
    name.forEach { println(it) }
}

fun mainIf() {
    println("mainIf-----------------------------------")
    //if 的分支可以是代码块，最后的表达式作为该块的返回值
    val maxValue = if (20 > 10) {
        println("maxValue is 20")
        20
    } else {
        println("maxValue is 10")
        10
    }
    println(maxValue) //20

    //完全可以用来替代 Java 中的三元运算符，因此 kotlin 并没有三元运算符
    val list = listOf(1, 4, 10, 4, 10, 30)
    val value = if (list.size > 0) list.size else null
    println(value)  //6

}

fun funWhen() {

    val value = 2
    when (value) {
        in 4..9 -> println("in 4..9") //区间判断
        3 -> println("value is 3")    //相等性判断
        2, 6 -> println("value is 2 or 6")    //多值相等性判断
        is Int -> println("is Int")   //类型判断
        else -> println("else")       //如果以上条件都不满足，则执行 else
    }

    when {
        1 > 5 -> println("1 > 5")
        3 > 1 -> println("3 > 1")
    }
}

/**
 * for 和 while表达式
 */
fun mainFor() {

    val list = listOf(1, 4, 10, 34, 10)
    for (value in list) {
        println(value)
    }

    val items = listOf("H", "e", "l", "l", "o")
    //通过索引来遍历List
    for (index in items.indices) {
        println("${index}对应的值是：${items[index]}")
    }
    //也可以在每次循环中获取当前索引和相应的值
    val list1 = listOf(1, 4, 10, 34, 10)
    for ((index, value) in list1.withIndex()) {
        println("index : $index , value :$value")
    }
    //也可以自定义循环区间
    for (index in 2..10) {
        println(index)
    }

    println("do while ---------------------------")
    val list2 = listOf(1, 4, 15, 2, 4, 10, 0, 9)
    var index = 0
    do {
        println(list2[index])
        index++
    } while (index < list2.size)
}

fun funLabel() {
    //在 kotlin 中任何表达式都可以用标签（label）来标记，
    //标签的格式为标识符后跟 @ 符号，例如：abc@ 、fooBar@ 都是有效的标签
    val list = listOf(1, 4, 6, 8, 12, 23, 40)
    loop@ for (it in list) {
        if (it == 8) {
            continue
        }
        if (it == 23) {
            break@loop
        }
        println("value is $it")
    }
    println("function end----------------------")

    listOf(1, 2, 3, 4, 5).forEach(fun(value: Int) {
        if (value == 3) {
            //局部返回到匿名函数的调用者，即 forEach 循环
            return
        }
        println("value is $value")
    })
    println("function end")
}

fun mainRanges() {
    //Ranges 表达式使用一个 .. 操作符来声明一个闭区间，它被用于定义实现一个 RangTo 方法
    var index = 5

    if (index >= 0 && index <= 10) {

    }

    if (index in 0..10) {

    }

    if (index in 0.rangeTo(10)) {

    }
    //Ranges 默认会自增长，所以像以下的代码就不会被执行
    for (index in 10..0) {
        println(index)
    }
    //可以改用 downTo 函数来将之改为递减
    for (index in 10 downTo 0) {
//        println(index)
    }

    //可以在 ranges 中使用 step 来定义每次循环递增或递增的长度：
    for (index in 1..8 step 2) {
        println(index)
    }
    for (index in 8 downTo 1 step 2) {
        println(index)
    }
    //以上声明的都是闭区间，如果想声明的是开区间，可以使用 until 函数：
    for (index in 0 until 4) {
        println(index)
    }
    //扩展函数 reversed() 可用于返回将区间反转后的序列
    val rangeTo = 1.rangeTo(8)
    for (i in rangeTo) {
        println(i) //1  2  3
    }
    for (i in rangeTo.reversed()) {
        println(i) //3  2  1
    }
}

open class View {
    open fun click() {

    }

    fun longClick() {

    }
}

open class Button : View() {
    override fun click() {

    }
}

class CompatButton : Button() {
    override fun click() {
        super.click()
    }
}

// 一个定义为 internal 的包成员，对其所在的整个 module 可见，但对于其它 module 而言就是不可见的了。
// 例如，假设我们想要发布一个开源库，库中包含某个类，我们希望这个类对于库本身是全局可见的，
// 但对于外部使用者来说它不能被引用到，此时就可以选择将其声明为 internal 的来实现这个目的
//
open class People {
    //protected子类可见
    protected val age = 12
    private val old = 90

    // internal只在其module可见
    internal val name = "J"
    internal fun add() {

    }
}

//在 kotlin 中，类型系统将一个引用分为可以容纳 null （可空引用）或者不能容纳 null（非空引用）两种类型。
// 例如，String 类型的常规变量不能指向 null
var name: String? = null
var age: Int? = null
var f: Float? = 10f

//安全调用运算符：?.
//安全调用运算符：?. 允许把一次 null 检查和一次方法调用合并为一个操作，
//如果变量值非空，则方法或属性会被调用，否则直接返回 null
fun check(name: String?) {
    if (name != null) {
        println(name.uppercase(Locale.getDefault()))
    } else {
        println(null)
    }
}

fun check2(name: String?) {
    println(name?.uppercase(Locale.getDefault()))
}

//Elvis 运算符：?: 用于替代 ?. 直接返回默认值 null 的情况，Elvis 运算符接收两个运算数，
// 如果第一个运算数不为 null ，运算结果就是其运算结果值，如果第一个运算数为 null ，运算结果就是第二个运算数
fun check3(name: String?) {
    if (name != null) {
        println(name)
    } else {
        println("default")
    }
}

fun check4(name: String?) {
    println(name ?: "default")

}

fun check(any: Any?) {
    val result = any as? String
    println(result ?: println("is not String"))
}

fun main6() {
    //is 与 !is 操作符用于在运行时检查对象是否符合给定类型：
    val strValue = "leavesC"
    parserType(strValue) //value is String , length : 7
    val intValue = 100
    parserType(intValue) //value is Int , toLong : 100
    val doubleValue = 100.22
    parserType(doubleValue) //value !is Long
    val longValue = 200L
    parserType(longValue) //unknown
}

fun parserType(value: Any) {
    when (value) {
        is String -> println("value is String , length : ${value.length}")
        is Int -> println("value is Int , toLong : ${value.toLong()}")
        !is Long -> println("value !is Long")
        else -> println("unknown")
    }

    //在上面的例子中，当判断 value 为 String 类型通过时，
    //就可以直接将 value 当做 String 类型变量并调用其内部属性，这个过程就叫做智能转换

    if (value !is String) return
    //如果 value 非 String 类型时直接被 return 了，所以此处可以直接访问其 length 属性
    println(value.length)

    // || 右侧的 value 被自动隐式转换为字符串，所以可以直接访问其 length 属性
    if (value !is String || value.length > 0) {

    }

    // && 右侧的 value 被自动隐式转换为字符串，所以可以直接访问其 length 属性
    if (value is String && value.length > 0) {

    }

}

class Point(val x: Int, val y: Int) {
    private val localX = x + 1
    private val localY = y + 1
    var isEquals: Boolean = false
        get() {
            return x == y
        }
        private set
    //以下代码会报错,私有化set方法，外部不可以设置其值
    //point.isEquals1 = true

    init {
        println("initializer blocks , x value is: $x , y value is: $y")
        println("initializer blocks , localX value is: $localX , localY value is: $localY")
    }

    //类也可以声明包含前缀 constructor 的次构造函数。如果类有一个主构造函数
    //每个次构造函数都需要直接委托给主构造函数或者委托给另一个次构造函数以此进行间接委托，用 this 关键字来进行指定即可
    constructor(base: Int) : this(base + 1, base + 1) {
        println("constructor(base: Int)")
    }

    //初始化块中的代码实际上会成为主构造函数的一部分，委托给主构造函数会作为次构造函数的第一条语句，
    // 因此所有初始化块中的代码都会在次构造函数体之前执行。即使该类没有主构造函数，这种委托仍会隐式发生，并且仍会执行初始化块。
    // 如果一个非抽象类没有声明任何（主或次）构造函数，会默认生成一个不带参数的公有主构造函数
    constructor(base: Long) : this(base.toInt()) {
        println("constructor(base: Long)")
    }
}

/**
 * 自定义访问器
 * 访问器的默认实现逻辑很简单：创建一个存储值的字段，
 * 以及返回属性值的 getter 和更新属性值的 setter。
 * 如果需要的话，也可以自定义访问器
 */
class User() {
    val name: String = "22"
    var age: Int = 25

    val school: String
        get() {
            return "niu"
        }
    var grade: String = "111"
        get() = field
        set(value) {
            field = value + "111+222"
        }
}

fun mainUser() {
    val user = User()
    user.age = 1
    user.grade = "h"
    println(user.grade)
}

class Example {
    //主要用于不能在构造函数中初始化的属性，依赖注入，
    //findviewbyid无法在类构造方法中初始化属性
    lateinit var point: Point

//    var point2: Point

    constructor() {
        point = Point(10, 2)
    }
}

/**
 * 为了确保生成的代码的一致性以及有意义的行为，数据类必须满足以下要求：
 * 主构造函数需要包含一个参数
 * 主构造函数的所有参数需要标记为 val 或 var
 * 数据类不能是抽象、开放、密封或者内部的
 */
data class Point2(val x: Int, val y: Int)

/**
 * Sealed 类（密封类）用于对类可能创建的子类进行限制
 * 用 Sealed 修饰的类的直接子类只允许被定义在 Sealed
 * 类所在的文件中（密封类的间接继承者可以定义在其他文件中）
 */
sealed class View2 {

    open fun click() {

    }

}

class Button4 : View2() {

}

class TextView : View2() {
}

/**
 * 枚举可以声明一些参数
 * 枚举也可以实现接口
 */
enum class Day(val index: Int) : OnChangedListener {
//    SUNDAY(0), MONDAY(1), TUESDAY(2), WEDNESDAY(3), THURSDAY(4), FRIDAY(5),

    SATURDAY(6) {
        override fun onChange() {
            println("onChange")
        }
    }
}

fun mainEnum() {
    println(Day.SATURDAY.onChange())
}

interface OnChangedListener {
    fun onChange()
}

//-------------------------------------------------
class Outer {

    private val bar = 1

    //在 kotlin 中在类里面再定义的类默认是：嵌套类，此时嵌套类不会包含对外部类的隐式引用
    //反编译查看java发现它是静态的
    class Nested {
        fun foo1() = 2
        //错误,
        //fun foo2() = bar
    }

    //内部类。内部类会隐式持有对外部类的引用
    inner class Nested2 {
        fun foo() = 2
        fun foo2() = bar
    }
}

fun mainOuter() {
    val demo = Outer.Nested().foo1()
    val d = Outer().Nested2().foo2()
}

//-------------------------------------------------
interface OnClickListener {

    fun onClick()

}

class View4 {

    fun setClickListener(clickListener: OnClickListener) {

    }

}

fun main4() {
    val view = View4()
    //可以使用对象表达式来创建匿名内部类实例
    view.setClickListener(object : OnClickListener {
        override fun onClick() {

        }
    })
}

//-------------------------------------------------
interface Clickable {
    //接口中可以包含抽象属性声明接口不定义该抽象属性是应该存储到一个支持字段还是通过 getter 来获取，
    // 接口本身并不包含任何状态，因此只有实现这个接口的类在需要的情况下会存储这个值
    val statusValue: Int
}

//SAM  只有一个抽象方法的接口称为函数式接口或 SAM（单一抽象方法）接口，
//在 Kotlin 1.4 之后，就支持直接以 Lambda 的方式来声明 SelfRunnable 的实现类，从而使得在方法调用上可以更加简洁
// 但这也要求 interface 同时使用 fun 关键字修饰
fun interface SelfRunnable {
    fun run()
}

fun setRunnable(selfRunnable: SelfRunnable) {
    selfRunnable.run()
}

fun runnAble() {
    setRunnable {
        println("可以直接用大括号来执行单一接口方法")
    }
}

//-------------------------------------------------
open class Base() {
    open fun fun1() {

    }

    fun fun2() {

    }
}

class SubClass() : Base() {
    override fun fun1() {
        super.fun1()
    }
}

open class BaseClass {
    open fun fun1() {
        println("BaseClass fun1")
    }
}

class SubClass2 : BaseClass() {

    override fun fun1() {
        println("SubClass fun1")
    }

    inner class InnerClass {
        //但如果想要在一个内部类中访问外部类的超类，则需要通过由外部类名限定的 super 关键字来实现
        fun fun2() {
            super@SubClass2.fun1()
        }

    }

}

fun mainSuper() {
    val subClass2 = SubClass2()
    val innerClass = subClass2.InnerClass()
    //BaseClass fun1
    innerClass.fun2()
}

//-------------------------------------------------
open class BaseClass2 {
    open fun fun1() {
        println("BaseClass fun1")
    }
}

interface BaseInterface {
    //接口成员默认就是 open 的
    fun fun1() {
        println("BaseInterface fun1")
    }
}

//为了表示采用从哪个超类型继承的实现，使用由尖括号中超类型名限定的 super 来指定，如 super< BaseClass >
class SubClass3() : BaseClass2(), BaseInterface {
    override fun fun1() {
        //调用 SubClass 的 fun1() 函数
        super<BaseClass2>.fun1()
        //调用 BaseInterface 的 fun1() 函数
        super<BaseInterface>.fun1()
    }
}

//--------------------------------------------------
class Namer {
    //伴生对象
    companion object {

        val defaultName = "mike"

    }

}

//扩展函数
fun Namer.Companion.getName(): String {
    return defaultName
}

fun main7() {
    Namer.getName()
}

var String.customLen: Int
    get() = 10
    set(value) = println(value)

fun lambdaMain() {
    { va1: Int, va2: Int -> println(va1 + va2) }(10, 20)
}

data class Person(val name: String, val age: Int)

fun main8() {
    val people = listOf(Person("leavesC", 24), Person("Ye", 22))
//    println(people.maxBy { it.age }) //Person(name=leavesC, age=24)
}

fun test() {
    println("test1111")
}

fun main9() {
    val t = ::test
    t.invoke()
    //也可以用构造方法引用存储或者延期执行创建类实例的动作
    val createPerson = ::Person
    val person = createPerson("leavesC", 24)
    println(person)
}

fun mainRun() {
    var nickName = "leaves"
    nickName = nickName.run {
        ifEmpty {
            ""
        }
    }
    println(nickName)
}

fun mainMap() {
    ///中缀调用,使用 “to” 来声明 map 的 key 与 value 之间的对应关系，这种形式的函数调用被称为中缀调用
    val maps = mapOf(1 to "leavesC", 2 to "ye", 3 to "https://juejin.cn/user/923245496518439")
    maps.forEach { key, value -> println("key is : $key , value is : $value") }
    val map2 = mapOf("1" to "11", "22" to "333")

}

class Example2 {

    val lazyValue1: String by lazy {
        println("lazyValue1 computed!")
        "Hello"
    }

    val lazyValue2: String by lazy(LazyThreadSafetyMode.SYNCHRONIZED) {
        println("lazyValue2 computed!")
        computeLazyValue()
    }

    private fun computeLazyValue() = "leavesC"

}

fun main10() {
    val example = Example2()
    println("---------------------------------------------------")
    println(example.lazyValue1 + "--------------") //lazyValue1 computed!     Hello
    println(example.lazyValue1 + "--------------=-----------") //Hello
    println(example.lazyValue2 + "---------------=-") //lazyValue2 computed! leavesC
}

//可以在一个 map 映射里存储属性的值，然后把属性的存取操作委托给 map 进行管理
fun main11() {
    val student = Student(
        mapOf(
            "name" to "leavesCZY",
            "age" to 24
        )
    )
    println(student.name)
    println(student.age)
}

class Student(val map: Map<String, Any?>) {
    val name: String by map
    val age: Int by map
}

fun main12() {

    //普通函数类型 () -> Unit: 就像一个独立的指令 print("Hello")。
    //带接收者的函数类型 String.() -> Unit: 就像一个可以在 String 对象上执行的指令 println(this.length)，
    //但写在 lambda 里就是 { println(length) }。
    //当你调用 "abc".myFunc() 时，这个 lambda 就会在 "abc" 这个 String 对象上执行，里面的 length 就会访问 "abc" 的 length。
    fun <T> T.apply(block: T.() -> Unit): T {
        // `this` 是 T 类型的接收者对象（调用 apply 的那个对象）
        block() // 调用传入的 lambda (block)，并将当前的 `this` (T对象) 作为接收者
        return this // 返回接收者对象，实现链式调用
    }
    //run到返回值是lambda函数的返回值，apply是T本身可以实现链式调用
    "av".run {
        println(toUpperCase())
    }
    "Ac".run({
        println(toLowerCase())
    })
}

class Person3 {
    var name: String = ""
    var age: Int = 0
    fun speak() {
        println("My name is $name")
    }
}

fun main13() {
    val person = Person3().apply {
        // 在这个 lambda 内部，`this` 是 Person 对象
        name = "Alice" // 等同于 this.name = "Alice"
        age = 30     // 等同于 this.age = 30
        speak()      // 等同于 this.speak()
    }
    println(person.name) // 输出: Alice
    //with 通常用于对一个对象执行一系列操作而不必重复写对象名
    val numbers = mutableListOf("one", "two", "three")
    with(numbers) {
        println("'with' is called with argument $this") // this 就是 numbers
        println("It contains $size elements") // size 是 numbers 的属性
    }
}

data class Html(val elements: MutableList<String> = mutableListOf()) {
    init {
        println("Html init()")
    }

    fun element(name: String) {
        elements.add(name)
    }
}

// 定义一个函数，接收一个 Html.() -> Unit 类型的 lambda
fun html(block: Html.() -> Unit): Html {
    val html = Html() // 创建接收者对象

    html.block() // 在 html 对象上执行 lambda
    return html
}

fun main14() {
    val page = html { // html 函数接收一个 Html.() -> Unit 类型的 lambda
        // 在这个 lambda 内部，this 是 Html 对象
        element("head") // 直接调用 Html 的成员方法
        element("body") // 直接调用 Html 的成员方法
        println("main14")
    }
//    println(page.elements) // 输出: [head, body]
}