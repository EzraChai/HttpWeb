fun main() {
    val interestThings = arrayOf("Chloe Gan", "Java", "Computer")
    println(interestThings.size)
    println(interestThings[0])
    println(interestThings.get(0))

    for (interestThing in interestThings) {
        println("InterestThing = $interestThing")
    }

    interestThings.forEach {
        println(it)
    }

    interestThings.forEach { interestThing -> println(interestThing) }

    interestThings.forEachIndexed { index, interestThing ->
        println("$interestThing is at index of $index")
    }
    fun2()
}

fun fun2() {
    println()
    val interestThings = listOf<String>("Chloe Gan", "Java", "Computer")
    interestThings.forEach { interestThing -> println("interest thing = $interestThing") }
    fun3()
}

fun fun3() {
    val map = mapOf<Int, String>(1 to "Chloe", 2 to "Chai")
    map.forEach { key, value -> println(" $key -> $value") }
    fun4()
}

fun sayHello(greeting: String, vararg itemsToGreet: String) {
    itemsToGreet.forEach { itemToGreet -> println("$greeting $itemToGreet") }
}

fun fun4() {
    val interestThings = arrayOf<String>("Chloe Gan", "Chai Juan Zhe", "Tung Jing Kang")
    sayHello("Hello, ", *interestThings)
    println()
    sayHello("Hi, ", "Chloe Gan", "Ezra", "Andy")
    fun5()
}

fun greetPerson(greeting: String = "Hello", name: String = "Kotlin") {
    println("$greeting, $name")
}

fun fun5() {
    greetPerson(greeting = "Hello", name = "Chloe Gan!")
    greetPerson(name = "Chloe Gan!", greeting = "Hi")
    greetPerson(name = "Chloe Gan!")
    greetPerson()
    fun6()
}

fun fun6() {
    val interestPerson = arrayOf("Chloe Gan", "Chai Juan Zhe", "Andy Yee")
    sayHello(greeting="Hi",itemsToGreet= *interestPerson)
}

