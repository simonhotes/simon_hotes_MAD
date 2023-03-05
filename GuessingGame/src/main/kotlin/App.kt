/*
* TODO Possible Improvements
*   TODO 1: Display already guessed combinations
*   TODO 2: Quit game with GAME OVER message after x wrong guesses
*   TODO 3: Display guesses left before game over
*   TODO 4: Refactoring:
*       TODO 4.1: Get rid of for-loops in calculateN and calculateM by replacing it with lambda expressions
*       TODO 4.2: Simplify println(s)
*   TODO 5: Check input (just Ints, etc.)
* */

fun main( ) {
    var endGame = false
    val numberToGuess = generateRandomNumberToGuess().toList()
    printHowToPlay()
    var nextGuess = readNextGuess()


    if(nextGuess == numberToGuess) {
        println()
        println("Congrats")
        println()
        endGame = true
    }

    while(!endGame) {
        var n = calculateN(numberToGuess, nextGuess)
        var m = calculateM(numberToGuess, nextGuess)
        println()
        println("$n : $m")
        println("---------------------------------------------------------")
        println()
        if(nextGuess == numberToGuess) {
            println()
            println("Congratulation, you correctly guessed $numberToGuess")
            println()
            endGame = true
        }

        if(!endGame) {
            nextGuess = readNextGuess()
        }
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
    println("Enter 4-digit number and hit enter: ")
    var input = readlnOrNull()
    while (input?.length != 4) {
        println("Bro pleeeease, enter a  4-digit number: ")
        input = readlnOrNull()
    }

    var inputList = input.chunked(1)
    return inputList.map { it.toInt() }
}

fun printHowToPlay() {
    println("Guessing Game: Find the right 4-digit number!\n" +
            "Enter the number and see the result as n : m,\n" +
            "where is the number of digits guessed correctly regardless of their position,\n" +
            "and m is the number of digits guessed correctly at their correct position.\n" +
            "Here are some examples:\n" +
            "Generated number: 8576 (there are no repeating digits in the number)\n" +
            "•\tUser input: 1234, Output: 0:0\n" +
            "•\tUser input: 5678, Output: 4:1\n" +
            "•\tUser input: 5555, Output: 1:1\n" +
            "•\tUser input: 3586, Output: 3:2\n")
}