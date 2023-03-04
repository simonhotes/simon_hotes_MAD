

fun main( ) {
    var rightGuess: Boolean = false
    val numberToGuess = generateRandomNumberToGuess().toList()
    println(numberToGuess)
    var nextGuess = readNextGuess()
    println(nextGuess)

    if(nextGuess == numberToGuess) {
        println()
        println("Congrats")
        println()
        rightGuess = true
    }

    while(!rightGuess) {
        var n = calculateN(numberToGuess, nextGuess)
        var m = calculateM(numberToGuess, nextGuess)
        println()
        println("$n : $m")
        println()
        if(nextGuess == numberToGuess) {
            println()
            println("Congrats")
            println()
            rightGuess = true
        }
        nextGuess = readNextGuess()
    }
}

fun calculateN(numberToGuess: List<Int>, nextGuess: List<Int>) : Int {
    var n = 0
    val alreadyCounted = mutableListOf<Int>()
    alreadyCounted.clear()
    for (i in 0 until numberToGuess.size) {
        for (j in 0 until nextGuess.size) {
            if (numberToGuess[i].equals(nextGuess[j]) && !alreadyCounted.contains(numberToGuess[i])) {
                n = n + 1
                alreadyCounted.add(numberToGuess[i])
            }
        }
    }
    return n
}

fun calculateM(numberToGuess: List<Int>, nextGuess: List<Int>) : Int {
    var m = 0

    for (i in 0 until numberToGuess.size) {
        if(numberToGuess[i].equals(nextGuess[i]))
            m = m+1
    }
    return m
}

fun generateRandomNumberToGuess() : MutableList<Int> {
    val numberToGuess = mutableListOf<Int>()

    while (numberToGuess.size < 4) {
        val randNr = (0..9).random()
        if(!numberToGuess.contains(randNr)) {
            numberToGuess.add(randNr)
        }
    }
    return numberToGuess
}

fun readNextGuess(): List<Int> {
    // Read number standard interface
    println()
    println("Enter 4-digit number separates by spaces and hit enter: ")
    var input = readlnOrNull()
    while (input?.length != 7) { // TODO -> improvement: check if input just contains int
        println("Bro pleeeease, enter a  4-digit number: ")
        input = readlnOrNull()
    }
    println()

    var inputList = input.split(' ')
    return inputList.map { it.toInt() }
}