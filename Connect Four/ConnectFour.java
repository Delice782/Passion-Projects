                                                                                   
/** 
 * Connect Four Game Implementation
 * <p>
 * This program simulates the classic two-player Connect Four game where players
 * take turns dropping colored discs into a 2D grid. The game
 * continues until one of the players forms a horizontal, vertical, or diagonal
 * line of four of their own discs or until the board is completely filled without
 * any player winning, resulting in a draw. </p>
 * <p>
 * The game board is a 2D grid consisting of six rows and seven columns. The red
 * disc is represented by 'R', the yellow disc by 'Y'</p>
 * <p>
 * In each turn, the program:
 * - Prompts the current player (alternating between red and yellow) to choose a
 *   column to drop their disc into.
 * - Validates the player's input and ensures the chosen column has space.
 * - Adds the disc to the lowest empty space in the chosen column.
 * - Redraws the game board in the console showing the current state.
 * - Checks the status of the game for a win, draw, or continuation. </p>
 * <p>
 * If a player successfully lines up four discs of their color in a row, column,
 * or diagonal, the program announces them as the winner. If all spaces are filled
 * and no player has achieved this, the program declares a draw. The program can
 * then be restarted to play a new game if the players decide to continue. </p>
 *
 * @author Delice Ishimwe
 * Created on: Feb 21, 2024
 */

import java.util.Scanner;

/**
 * This class represents a simple console-based ConnectFour game.
 * In this game, the two player tries to place the color discs on the game board until one of the players forms a horizontal, vertical, or diagonal
 * line of four of their own discs or until the board is completely filled without any player winning, resulting in a draw.
 * The game tracks the status of the game for a win, draw, or continuation.
 */
public class ConnectFour {

    /**
     * An array of rows and columns of the game board.
     */
    private final String[][] board = new String[6][7];

    /**
     * Scanner to read user input from the console.
     */
    private final Scanner scanner = new Scanner(System.in);

    /**
     * Red is the first player.
     * Boolean variable for turn control, true if it's Red's turn.
     */
    private boolean isRedTurn = true;

    /**
     * String to indicate the correct response in case there is an issue with the user's input
     */
    private String errorResponse = "";

    /**
     * Boolean variable to keep the game running
     */
    private boolean gameNotOver = true;

    /**
     * Constructor initializes the game.
     */
    public ConnectFour() {
        initializeBoard();
    }

    /**
     * Initializes the board with empty spaces and 
     * Each cell of the game board is set to contain a space character.
     */
    private void initializeBoard() {
        for (int i = 0; i < board.length; i++) {
            for (int j = 0; j < board[i].length; j++) {
                board[i][j] = " ";
            }
        }
    }

    /**
     * Contains the main gameplay loop, which continues until one of the players wins.
     */
    public void playGame() {
        while (gameNotOver) {
            displayBoard();
            processTurn();
            if (checkWin()) {
                gameNotOver = false;
                displayBoard(); // Display the final state of the board
                if (isRedTurn) {
                    System.out.println("The red player won");
                } else {
                    System.out.println("The yellow player won");
                }
                break; // Exit the game loop if there's a win
            }
            if (isBoardFull()) {
                gameNotOver = false;
                displayBoard(); // Display the final state of the board
                System.out.println("The game is a draw!");
                break; // Exit the game loop if the board is full
            }
            switchTurn();
        }
        scanner.close(); // Close the scanner when the game is over
    }

    /**
     * Start each row with a vertical bar.
     * End each cell with a vertical bar.
     * Print a bottom border for the board for better visual separation.
     */

    private void displayBoard() {
        for (String[] row : board) {
            System.out.print("|");
            for (String cell : row) {
                System.out.print(cell + "|");
            }
            System.out.println();
        }
        System.out.println("-----------------------------");
    }

    /**
     * An array of possible words for the game.
     * Check if the chosen column is within the valid range
     */
    private void processTurn() {
        boolean validPlay = false;   // Checks if user input is valid.
        do {
            if (isRedTurn) {
                // Ask the red player to play if it is their turn
                System.out.print("Drop a red disk at column (0-6): ");
            } else {
                // Ask the yellow player to play if it is their turn
                System.out.print("Drop a yellow disk at column (0-6): ");
            }

            // Check if the player's input is a valid integer and proceed accordingly
            if(scanner.hasNextInt()){
                int column = scanner.nextInt();
                // Check that the player provided an integer as their input
                validPlay = placeDisc(column);    // Check if it is valid column value
                if (!validPlay) {
                    System.out.println(errorResponse);
                }
            }
            else{
                // Clear the invalid input.
                scanner.next();
                System.out.println("Invalid column. Please select a column between 0 and 6.");
            }
        } while (!validPlay);
    }

    /**
     * Attempt to place the disk in the chosen column.
     *
     * @return false if the column is full.
     */
    private boolean placeDisc(int column) {
        if (column < 0 || column >= 7) {
            // Inform the player to give a valid input
            errorResponse = "Invalid column. Please select a column between 0 and 6.";
            return false;
        }
        // Update the board
        for (int row = board.length - 1; row >= 0; row--) {
            if (board[row][column].equals(" ")) {
                if(isRedTurn){
                    // Update the noted board cell with "R" if it is red player's turn
                    board[row][column] = "R";
                }
                else{
                    // Update the noted board cell with "Y" if it is yellow player's turn
                    board[row][column] = "Y";
                }
                return true;
            }
        }
        // Inform the player that the column they chose is already full and they should choose a different column
        errorResponse = "This column is full. Try a different column.";
        return false;
    }

    /**
     * Switch turns for the next player.
     */
    private void switchTurn() {
        isRedTurn = !isRedTurn;   // Update the player's turn
    }

    /**
     * Check for win after the disk has been placed.
     * @return true if there is a win.
     */
    private boolean checkWin() {
        String currentPlayerDisc = isRedTurn ? "R" : "Y";
        // Horizontal, Vertical, Diagonal checks
        for (int row = 0; row < board.length; row++) {
            for (int col = 0; col < board[row].length; col++) {
                // Checks horizontal win
                if (col + 3 < board[row].length && currentPlayerDisc.equals(board[row][col]) && currentPlayerDisc.equals(board[row][col + 1]) && currentPlayerDisc.equals(board[row][col + 2]) && currentPlayerDisc.equals(board[row][col + 3])) {
                    return true;
                }
                // Checks vertical win
                if (row + 3 < board.length && currentPlayerDisc.equals(board[row][col]) && currentPlayerDisc.equals(board[row + 1][col]) && currentPlayerDisc.equals(board[row + 2][col]) && currentPlayerDisc.equals(board[row + 3][col])) {
                    return true;
                }
                // Checks diagonal right win
                if (row + 3 < board.length && col + 3 < board[row].length && currentPlayerDisc.equals(board[row][col]) && currentPlayerDisc.equals(board[row + 1][col + 1]) && currentPlayerDisc.equals(board[row + 2][col + 2]) && currentPlayerDisc.equals(board[row + 3][col + 3])) {
                    return true;
                }
                // Checks diagonal left win
                if (row - 3 >= 0 && col + 3 < board[row].length && currentPlayerDisc.equals(board[row][col]) && currentPlayerDisc.equals(board[row - 1][col + 1]) && currentPlayerDisc.equals(board[row - 2][col + 2]) && currentPlayerDisc.equals(board[row - 3][col + 3])) {
                    return true;
                }
            }
        }
        return false;
    }

    /**
     * Check if the board is full, row at a time.
     * @return false if any empty cell is found
     * @return true if no empty spaces are found.
     */
    private boolean isBoardFull() {
        for (int i = 0; i < board.length; i++) { // Iterate over each row
            for (int j = 0; j < board[i].length; j++) { // Iterate over each column in the row
                if (" ".equals(board[i][j])) { // Check if the cell is empty
                    return false;
                }
            }
        }
        return true; // Return true if no empty cells are found, indicating the board is full.
    }

    /**
     * The main method serves as the starting point of the program execution.
     * It creates an instance of the ConnectFour and then starts the game loop by invoking the playGame method on the ConnectFour instance.
     * @param args passed to the main was not used.
     */
    public static void main(String[] args) {
        ConnectFour game = new ConnectFour();
        game.playGame();
    }
}
