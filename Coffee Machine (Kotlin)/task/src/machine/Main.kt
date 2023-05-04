package machine
const val MILK:Int = 50
const val BEANS:Int = 15
const val WATER:Int = 200
fun main() {

    println("Write how many ml of water the coffee machine has:")
    val available_water:Int = readln().toInt()

    println("Write how many ml of milk the coffee machine has:")
    val available_milk:Int = readln().toInt()

    println("Write how many grams of coffee beans the coffee machine has:")
    val available_beans:Int = readln().toInt()

    println("Write how many cups of coffee you will need:")
    val cups:Int = readln().toInt()

    val water_amount = available_water/(WATER)
    val milk_amount = available_milk/(MILK)
    val beans_amount = available_beans/(BEANS)
    val min = minOf(water_amount, milk_amount, beans_amount)

    if(min>=cups){
        print("Yes, I can make that amount of coffee")
        if(min>cups){
            println(" (and even ${min-cups} more than that)")
        }
    }else{
        println("No, I can make only ${min} cup(s) of coffee")
    }



}

