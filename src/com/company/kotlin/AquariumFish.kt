package com.company.kotlin

/**
 * @author meng
 * @Data 2024/3/17 22:21
 * @Desc
 */
interface FishColor {
    val color: String
}

//单例模式实现接口的代理类
object GoldColor : FishColor {
    override val color = "gold"
}
class Shark: FishColor, FishAction{
    override val color: String
        get() = "red"

    override fun eat() {
        println("hunt and eat fish")
    }
}

// 直接指定接口的代理类为GoldColor
class Plecostomus: FishColor by GoldColor, FishAction{
    override fun eat() {
        println("eat algae")
    }
}

//加入构造方法指定不同的代理类
class CaoYu(fishColor: FishColor = GoldColor): FishAction, FishColor by fishColor{
    override fun eat() {
        println("eat Cao")
    }
}

interface FishAction  {
    fun eat()
}
class PrintingFishAction(val food: String) : FishAction {
    override fun eat() {
        println(food)
    }
}
fun makeFinish(){
    val shark = Shark()
    val pleco = Plecostomus()

    println("Shark: ${shark.color}")
    shark.eat()
    println("Plecostomus: ${pleco.color}")
    pleco.eat()

}
fun main() {
    makeFinish()
}