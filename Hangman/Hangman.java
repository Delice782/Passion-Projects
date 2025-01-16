          
/**
 * Hangman Game Implementation
 * <p>
 * This Java program implements a console-based version of the classic Hangman game.
 * It is designed for a single player to guess a word chosen randomly from a predefined list,
 * one letter at a time, while trying to minimize incorrect guesses.
 * The game continues until the player successfully guesses the word or chooses not to play another round.
 * Incorrect guesses are tracked, and the player is informed of the total number of misses at the end of the game. </p>
 * <p>
 * Key Design Considerations:
 * - Word Selection: Randomly selects a target word from a predefined array or as the command prompt parameters.
 * - Gameplay Loop: Manages the sequence of guessing letters and checking for game end conditions.
 * - Private methods. This design approach is for restricting external access to the internal flow of the game, ensuring that all manipulations of the game logic are controlled and predictable.
 * - Guess Handling and Misses Tracking: Evaluates player's guesses and tracks the number of incorrect attempts.
 * - End-of-Game Scenarios: Determines game outcome and offers option to replay. </p>
 *
 * @author Delice Ishimwe
 * Created on: Feb 21, 2024
 */

import java.util.Random;
import java.util.Scanner;

/**
 * This class represents a simple console-based Hangman game.
 * In this game, the player tries to guess a randomly selected word by guessing one letter at a time.
 * The game tracks the number of incorrect guesses and allows the player to play multiple rounds.
 */
public class Hangman {
    /**
     * An array of possible words for the game.
     */
    private static String[] words;

    /**
     * The word currently being guessed.
     */
    private String targetWord;

    /**
     * The current state of the word being guessed, with unguessed letters represented as asterisks.
     */
    private char[] guessedWord;

    /**
     * The number of incorrect guesses made in the current game.
     */
    private int misses;

    /**
     * Scanner to read user input from the console.
     */
    private Scanner scanner = new Scanner(System.in);

    /**
     * Random number generator for selecting a word from the words array.
     */
    private final Random random = new Random();

    /**
     * Constructor initializes the game with an empty target word, an empty guessed word array, and zero misses.
     */
    public Hangman() {
        this.targetWord = "";     // Keeps track of the target word
        this.guessedWord = new char[0];      // Keeps track of the guessed word
        this.misses = 0;    // Keeps track of the wrong guesses made by the player
    }

    /**
     * Starts a new game by selecting a random word to guess, resetting the guessed word and misses.
     */
    public void startNewGame() {
        this.misses = 0;         // Initialize the number of misses to 0
        this.targetWord = words[random.nextInt(words.length)];    // Initialize the target word
        this.guessedWord = new char[targetWord.length()];   // Initialize the guessed word
        for (int i = 0; i < targetWord.length(); i++) {
            guessedWord[i] = '*';     // Sets the guessed word to be a chain of *
        }
    }

    /**
     * Contains the main gameplay loop, which continues until the player decides to stop playing.
     */
    public void playGame() {
        boolean gameContinues = true;     // Keeps track of whether the game should continue or not
        startNewGame(); // Initializes a new game

        while (gameContinues) {
            displayCurrentState();     // Shows the current status of the game
            char userGuess = getUserGuess();  // Keeps track of the player's guess

            processGuess(userGuess);
            if (isWordGuessed()) {
                displayWinningMessage();    // Shows the current status of the game
                gameContinues = askToPlayAgain();     // Asks the user if they want to play again
            }
        }
    }

    /**
     * Displays the current state of the guessed word and prompts the player to guess a letter.
     */
    private void displayCurrentState() {
        System.out.print("(Guess) Enter a letter in word " + new String(guessedWord) + " > ");
    }

    /**
     * Processes the player's guess, checking if the guessed letter is in the target word.
     *
     * @param guess represent the character guessed by the player.
     * @return true if the guess was correct, false otherwise.
     */
    private void processGuess(char guess) {
        boolean correctGuess = false;     // Keeps track of whether the player's guess is correct or not
        boolean repeatedCorrectGuess = false;   // Keeps track of whether the player's guess is already in the target word

        // Verifies if the player's guess was correct or not and prints the appropriate response
        for (int i = 0; i < targetWord.length(); i++) {
            // Checks if the guess is a correct letter
            if (guess == targetWord.charAt(i) && guessedWord[i] == '*') {
                guessedWord[i] = guess;   // Updates the guessed word
                correctGuess = true;   // Updates this boolean
            }
            // Checks if the guess is a letter already in the target word and can't be repeated
            else if(guess == targetWord.charAt(i) && guessedWord[i] != '*'){
                repeatedCorrectGuess = true;  // Updates this boolean
            }
        }

        // Prints the appropriate response depending on the correctness of the player's guess
        if(repeatedCorrectGuess){
            System.out.println(guess + " is already in the word");   // Informs the user when the guess is wrong
            
        }
        else if(!correctGuess){
            System.out.println(guess + " is not in the word");   // Informs the user when the guess is already in the target word
            misses++;    // Keeps track of the number of wrong guesses
        }
    }

    /**
     * Gets a single character guess from the player.
     *
     * @return the character guessed by the player.
     */
    private char getUserGuess() {
        return scanner.next().charAt(0);
    }

    /**
     * Checks if the target word has been fully guessed.
     *
     * @return true if the word has been fully guessed, false otherwise.
     */
    private boolean isWordGuessed() {
        return targetWord.equals(new String(guessedWord));
    }

    /**
     * Displays a message indicating the player has won and shows the number of incorrect guesses.
     */
    private void displayWinningMessage() {
        System.out.println("The word is " + targetWord + ". You missed " + misses + (misses <= 1 ? " time" : " times"));
    }

    /**
     * Prompts the player to decide if they want to play another round.
     *
     * @return true if the player wants to play again, false otherwise.
     */
    private boolean askToPlayAgain() {
        System.out.println("Do you want to guess another word? Enter y or n> ");
        String playAgain = scanner.next();    // Keeps track of whether the player wants to keep playing or not
        if (playAgain.equalsIgnoreCase("y")) {
            startNewGame(); // Reset the game state for a new game
            return true;
        } else {
            scanner.close(); // Close the scanner resource before exiting
            return false;
        }
    }

    /**
     * The main method serves as the starting point of the program execution.
     * It creates an instance of the Hangman and then starts the game loop by invoking the playGame method on the Hangman instance.
     * @param args passed to the main was not used.
     */
    public static void main(String[] args) {

        if (args.length == 0) {
            // If no arguments are provided, use predefined list of target words
            words = new String[]{"write", "that", "army", "xaxophone", "ambiguity"};
        } else {
            // If arguments are provided, use them as the list of target words
            words = args;
        }

        // Create an instance of Hangman and play the game
        Hangman game1= new Hangman();
        game1.playGame();

    }
}
