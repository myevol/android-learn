package BaseSyntax

fun main() {
    test1()
    test2()
    test3()
    test4()
}

fun test1() {
    val a = ::trick1
    val b = trick
    a()
    b()
    trick1()
    treat()
}

fun test2() {
    val treatFunction = trickOrTreat1(false)
    val trickFunction = trickOrTreat1(true)
    treatFunction()
    trickFunction()
}

fun test3() {
    val coins: (Int) -> String = { quantity ->
        "$quantity quarters"
    }

    val cupcake: (Int) -> String = {
        "Have a cupcake"
    }

    val a = trickOrTreat(true, cupcake)
    val b = trickOrTreat(false, cupcake)
    a()
    b()
    println()
    val c = trickOrTreat(true, coins)
    val d = trickOrTreat(false, coins)
    c()
    d()
    println()
    val e = trickOrTreat(true, null)
    val f = trickOrTreat(false, null)
    e()
    f()
    println()
//    省略形参
    val g = trickOrTreat(false, { "Have a cupcake" })
//    Int 类型形参默认名称 it
    val h = trickOrTreat(false, { "$it quarters" })
    g()
    h()
}

fun test4() {
//    val treatFunction = trickOrTreat(false) { "$it quarters" }
//    treatFunction()
    repeat(4) { println(it) }
}

fun trick1() {
    println("No treats!")
}

fun trickOrTreat1(isTrick: Boolean): () -> Unit {
    if (isTrick) {
        return trick
    } else {
        return treat
    }
}

val trick = {
    println("No treats!")
}

val treat: () -> Unit = {
    println("Have a treat!")
}

fun trickOrTreat(isTrick: Boolean, extraTreat: ((Int) -> String)?): () -> Unit {
    if (isTrick) {
        return trick
    } else {
        if (extraTreat != null) {
            println(extraTreat(5))
        }
        return treat
    }
}