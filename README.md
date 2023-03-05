# simon_hotes_MAD
Repo for study course Mobile App Dev summer term 2023

Learning Diary 1:
Guessing Game: Find the right 4-digit number!
Enter the number and see the result as n : m,
where is the number of digits guessed correctly regardless of their position,
and m is the number of digits guessed correctly at their correct position.
Here are some examples:
Generated number: 8576 (there are no repeating digits in the number)
•	User input: 1234, Output: 0:0
•	User input: 5678, Output: 4:1
•	User input: 5555, Output: 1:1
•	User input: 3586, Output: 3:2


TODO Possible Improvements
  TODO 1: Display already guessed combinations
  TODO 2: Quit game with GAME OVER message after x wrong guesses
  TODO 3: Display guesses left before game over
  TODO 4: Refactoring:
      TODO 4.1: Get rid of for-loops in calculateN and calculateM by replacing it with lambda expressions
      TODO 4.2: Simplify println(s)
  TODO 5: Check input (just Ints, etc.)
