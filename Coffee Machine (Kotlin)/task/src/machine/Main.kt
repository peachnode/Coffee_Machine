package machine
const val MILK:Int = 50
const val BEANS:Int = 15
const val WATER:Int = 200
var available_water = 400
var available_milk = 540
var available_beans = 120
var available_money = 550
var available_cups = 9

fun remaining(){
    println("""
        The coffee machine has:
        ${available_water} ml of water
        ${available_milk} ml of milk
        ${available_beans} g of coffee beans
        ${available_cups} disposable cups
        ${'$'}${available_money} of money
    """.trimIndent())
}
fun makeDrink(water: Int, beans: Int, money: Int, milk: Int){
    if(water > available_water) println("Sorry, not enough water!")
    else if(beans > available_beans) println("Sorry, not enough beans!")
    else if(milk > available_milk) println("Sorry, not enough milk!")
    else if(1 > available_cups) println("Sorry, not enough cups!")
    else{
        println("I have enough resources, making you a coffee!")
        available_cups -= 1
        available_water-=water
        available_beans-=beans
        available_milk-=milk
        available_money+=money
    }

}
fun buy(){
    println("What do you want to buy? 1 - espresso, 2 - latte, 3 - cappuccino, back - to main menu:")
    when(readln()){
        "1" -> makeDrink(250, 16, 4, 0)
        "2" -> makeDrink(350, 20, 7, 75)
        "3" -> makeDrink(200, 12, 6, 100)
        "back" -> return
    }


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
    while(true){
        println("Write action (buy, fill, take, remaining, exit):")
        when(readln()){
            "buy" -> buy()
            "fill" -> fill()
            "take" -> take()
            "remaining" -> remaining()
            "exit" -> break
        }

    }




}

