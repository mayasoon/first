package com.company.kotlin

import sun.security.util.Length

/**
 * @author meng
 * @Data 2024/3/17 17:31
 * @Desc
 */
class ObjectOriented {


}
/*
只有open关键字的类可以被继承，包括里面的变量，方法等，不然只能访问不能重写
 */
open class Aquarium (var length: Int = 10,open var height: Int = 20,var width: Int = 1) {

    open var shape = "rectangle"

    open val water: Double
        get() = volume * 0.9
    constructor(numberOfFish: Int) : this() {
        // 2,000 cm^3 per fish + extra room so water doesn't spill
        val tank = numberOfFish * 2000 * 1.1
        height = (tank / (length * width)).toInt()
    }
    val volume: Int get() = width * height * length / 1000  // 1000 cm^3 = 1 l

    init {
        println("aquarium initializing")
    }
}
class TowerTank (override var height: Int, var diameter: Int): Aquarium(height = height, width = diameter, length = diameter) {
}

fun main() {
    val aquarium4 = Aquarium(width = 25, height = 35, length = 110)
//    val aquarium6 = Aquarium(numberOfFish = 29)
//    println("Volume: ${aquarium6.width * aquarium6.length * aquarium6.height / 1000} l")
}
fun buildAquarium() {
    val aquarium1 = Aquarium()
    aquarium1.length
    // default height and length
    val aquarium2 = Aquarium(width = 25)
    // default width
    val aquarium3 = Aquarium(height = 35, length = 110)
    // everything custom
    val aquarium4 = Aquarium(width = 25, height = 35, length = 110)
}