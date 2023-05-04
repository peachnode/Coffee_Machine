package machine
const val MILK:Int = 50
const val BEANS:Int = 15
const val WATER:Int = 200
var available_water = 400
var available_milk = 540
var available_beans = 120
var available_money = 550
var available_cups = 9

fun printStat(){
    println("""
        The coffee machine has:
        ${available_water} ml of water
        ${available_milk} ml of milk
        ${available_beans} g of coffee beans
        ${available_cups} disposable cups
        ${'$'}${available_money} of money
    """.trimIndent())
}
fun buy(){
    println("What do you want to buy? 1 - espresso, 2 - latte, 3 - cappuccino:")
    when(readln().toInt()){
        1 ->  {available_water-=250
            available_beans-=16
            available_money+=4}
        2 -> {available_water-=350
            available_beans-=20
            available_milk-=75
            available_money+=7}
        3 -> {available_water-=200
            available_beans-=12
            available_milk-=100
            available_money+=6}
    }
    available_cups -= 1

}
fun fill(){
    println("Write how many ml of water you want to add:")
    available_water += readln().toInt()
    println("Write how many ml of milk you want to add:")
    available_milk += readln().toInt()
    println("Write how many grams of coffee beans you want to add:")
    available_beans += readln().toInt()
    println("Write how many disposable cups you want to add:")
    available_cups += readln().toInt()
}
fun take(){
    println("I gave you $('$')${available_money}")
    available_money = 0
}

fun main() {

    printStat()
    println("Write action (buy, fill, take):")
    when(readln()){
        "buy" -> buy()
        "fill" -> fill()
        "take" -> take()
    }


    printStat()


}

