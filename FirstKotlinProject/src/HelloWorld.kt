fun main(args:Array<String>) {
    println("Hello Kotlin")
    main2()
}

fun main2() {
    println("Hello World")
    main3()
}

val name3 : String = "Ezra"
var greeting : String = "Hi, "

//var and val
fun main3() {
    val name : String = "Chloe Gan"
    var name2 : String = "Chloe Gan"
    name2 = "Chloe"
    println(name)
    println(name2)
    println(name3)

    greeting = "Hello, "
    println(greeting + name)
    main4()
}

//If null add ? behind parameter
val name4 : String? = null
fun main4(){
    if (name4 != null) {
        println(name4)
    }else {
        println("Chai")
    }
    main5()
}

fun main5(){
    var greeting2 : String? = null
    when (greeting2){
        null -> println("Hello")
        else -> println(greeting2)
    }
    main6()
}

var greeting3 : String? = null
fun main6(){
    greeting3 = "Hello-Hello"
    val greetingToPrint = if (greeting3 != null) greeting3 else "Hi"
    println(greetingToPrint)
    val greetingToPrint2 = when (greeting3 ){
        null -> "HEY"
        else -> greeting3
    }
    println(greetingToPrint2)
    main7()
}


fun getGreeting2():String{
    return "Hello Kotlin"
}

fun main7(){
    println(getGreeting2())
    main8()
}

fun Hello() {
    println("Hello Chloe")
}

fun main8(){
    println(Hello())
    println(main9())
    main10()
}

fun main9() =  "Hello, Chloe Gan"

//fun sayHello(itemtoGreet : String){
//    val message :String  = "Hello, $itemtoGreet"
//    println(message)
//}


fun sayHello(greeting3 : String ,itemtoGreet : String) = println("$greeting3, $itemtoGreet")

fun  main10(){
    sayHello("Hey,","Chloe Gan")
    sayHello("Hello","World")
}













