# Hangman Game

## Project Description

This project is a console-based Hangman game written in Java Programming Language. It challenges the player to guess a word, one letter at a time, with each letter of the word initially hidden and represented as an asterisk. The player's goal is to uncover the hidden word by guessing one letter at a time. The game keeps track of the number of incorrect guesses (misses) and offers the player the choice to continue with a new word upon successfully guessing the current word or exhausting their attempts.

The game can operate in two modes:
1. Using a default list of words hard-coded into the program.
2. Accepting a custom list of words provided by the user as command-line parameters.

## Features

- Interactive command-line interface for guessing letters.
- Words to guess are represented by asterisks until uncovered by correct guesses.
- Counter for the number of misses (incorrect guesses).
- Option to continue playing with a new word after the current game ends.
- Customizable word list through command-line parameters.

## How to Compile and Run

Ensure you have Java installed on your system. You can compile and run the game using the Java compiler (`javac`) and Java runtime (`java`). Follow these steps:

1. Compile the program:
    ```
    javac Hangman.java
    ```

2. Run the game using the default word list:
    ```
    java Hangman
    ```

3. Optionally, run the game with a custom list of words by providing them as command-line arguments:
    ```
    java Hangman elephant cow horse carriage mouse executioner caravan octopus
    ```

## Usage

- Upon starting the game, you will be prompted to guess a letter.
- Enter a single letter and press enter to make a guess.
- The game will reveal the positions of the guessed letter if it exists in the word, or increment the miss counter if it does not.
- The game continues until the word is fully uncovered or the player runs out of attempts.
- After each game, you will be asked if you want to play again with a new word.

