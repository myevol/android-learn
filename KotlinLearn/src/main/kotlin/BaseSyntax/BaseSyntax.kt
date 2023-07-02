package BaseSyntax

fun main() {
    runIfELse("Red")
    runWhenElse("Green")
    runWhenInElse(4)
    runG()
    runNull()
}

fun runNull() {
    val f: String? = "不是 null"
//    println(f)
//    f = null
//    println(f)
//    f = "嘿嘿 null"
//    println(f)
    val l = if (f != null) {
        f.length
    } else {
        0
    }
    val l2 = f?.length ?: 0
    println(f?.length)
    println(f!!.length)
    println(l)
    println(l2)
}

fun runWhenInElse(x: Number) {
    when (x) {
        2, 3, 5, 7 -> println("x is a prime number between 1 and 10.")
        in 1..10 -> println("x is a number between 1 and 10, but not a prime number.")
        else -> println("x isn't a prime number between 1 and 10.")
    }
}

// when
fun runWhenElse(trafficLightColor: String) {
    when (trafficLightColor) {
        "Red" -> println("Stop")
        "Green" -> println("Go")
        "Yellow" -> println("Wait")
        else -> println("Invalid traffic-light color")
    }
}

// if - else-if - else
fun runIfELse(trafficLightColor: String) {
    if (trafficLightColor == "Red") {
        println("Stop")
    } else if (trafficLightColor == "Yellow") {
        println("Wait")
    } else {
        println("Go")
    }
}

fun runG() {
    println(1 == 1);
}