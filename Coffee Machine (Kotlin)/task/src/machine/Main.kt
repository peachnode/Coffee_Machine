package machine
const val MILK:Int = 50
const val BEANS:Int = 15
const val WATER:Int = 200
var machine: CoffeeMachine = CoffeeMachine()
var available_water = 400
var available_milk = 540
var available_beans = 120
var available_money = 550
var available_cups = 9


class CoffeeMachine{
    enum class State{
        ACTION, COFFEE, FILL_WATER, FILL_BEANS, FILL_MILK, FILL_CUPS
    }

    var currentState: State = State.ACTION
    var machine_on: Boolean = true
    private fun fill(userInput: String){
        when(currentState) {
            State.ACTION -> {
                println("Write how many ml of water you want to add:")
               currentState = State.FILL_WATER
            }
            State.FILL_WATER -> {
                available_water += userInput.toInt()
                println("Write how many ml of milk you want to add:")
                currentState = State.FILL_MILK
            }
            State.FILL_MILK -> {
                available_milk += userInput.toInt()
                println("Write how many grams of coffee beans you want to add:")
                currentState = State.FILL_BEANS
            }
            State.FILL_BEANS -> {
                available_beans += userInput.toInt()
                println("Write how many grams of coffee beans you want to add:")
                currentState = State.FILL_CUPS
            }
            State.FILL_BEANS -> {
                available_beans += userInput.toInt()
                println("Write how many grams of coffee beans you want to add:")
                currentState = State.FILL_CUPS
            }
            State.FILL_CUPS -> {
                available_cups += userInput.toInt()
                currentState = State.ACTION
                println("Write action (buy, fill, take, remaining, exit):")
            }
        }
    }



    fun working(userInput: String){
        if (currentState == State.ACTION){
            when (userInput){
                "buy" -> {println("What do you want to buy? 1 - espresso, 2 - latte, 3 - cappuccino, back - to main menu:")
                        currentState = State.COFFEE}
                "fill" -> fill(userInput)
                "take" -> take()
                "remaining" -> remaining()
                "exit" -> machine_on = false
            }
        }else if(currentState == State.COFFEE){
            when(userInput){
                "1" -> makeDrink(250, 16, 4, 0)
                "2" -> makeDrink(350, 20, 7, 75)
                "3" -> makeDrink(200, 12, 6, 100)
                "back" -> currentState = State.ACTION
            }
            currentState = State.ACTION
        }else{
            fill(userInput)
        }


    }

}

fun remaining(){
    println("""
        The coffee machine has:
        ${available_water} ml of water
        ${available_milk} ml of milk
        ${available_beans} g of coffee beans
        ${available_cups} disposable cups
        ${'$'}${available_money} of money
    """.trimIndent())
    println("Write action (buy, fill, take, remaining, exit):")
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
    println("Write action (buy, fill, take, remaining, exit):")

}




fun take(){
    println("I gave you $('$')${available_money}")
    available_money = 0
}

fun main() {
    println("Write action (buy, fill, take, remaining, exit):")
    while(machine.machine_on){
        machine.working(readln())
    }




}

