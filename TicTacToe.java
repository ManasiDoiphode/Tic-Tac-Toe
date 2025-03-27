import java.util.Scanner;

/**
 * A customizable two-player Tic-Tac-Toe game with 1-based indexing.
 */
public class TicTacToe {
    private static final char EMPTY = ' ';
    private static char[][] board;
    private static char currentPlayer = 'X';
    private static int boardSize;

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        boolean playAgain;
        
        do {
            System.out.print("Enter the board size (3 or greater): ");
            boardSize = scanner.nextInt();
            while (boardSize < 3) {
                System.out.print("Invalid size. Enter a number 3 or greater: ");
                boardSize = scanner.nextInt();
            }
            
            initializeBoard();
            boolean gameWon = false;
            int moves = 0;
            
            while (!gameWon && moves < boardSize * boardSize) {
                printBoard();
                playerMove(scanner);
                gameWon = checkWin();
                if (!gameWon) {
                    currentPlayer = (currentPlayer == 'X') ? 'O' : 'X';
                }
                moves++;
            }
            
            printBoard();
            if (gameWon) {
                System.out.println("Player " + currentPlayer + " wins!");
            } else {
                System.out.println("It's a draw!");
            }
            
            System.out.print("Do you want to play again? (yes/no): ");
            playAgain = scanner.next().equalsIgnoreCase("yes");
        } while (playAgain);
        
        scanner.close();
    }

    /**
     * Initializes the Tic-Tac-Toe board with empty spaces.
     */
    private static void initializeBoard() {
        board = new char[boardSize][boardSize];
        for (int i = 0; i < boardSize; i++) {
            for (int j = 0; j < boardSize; j++) {
                board[i][j] = EMPTY;
            }
        }
        currentPlayer = 'X';
    }

    /**
     * Prints the current state of the game board.
     */
    private static void printBoard() {
        System.out.println("\n   " + getColumnNumbers());
        for (int i = 0; i < boardSize; i++) {
            System.out.print((i + 1) + "  ");
            for (int j = 0; j < boardSize; j++) {
                System.out.print(board[i][j]);
                if (j < boardSize - 1) System.out.print("|");
            }
            System.out.println();
            if (i < boardSize - 1) System.out.println("   " + "-".repeat(boardSize * 2 - 1));
        }
    }

    /**
     * Gets column numbers as a formatted string for display.
     * @return Formatted column numbers.
     */
    private static String getColumnNumbers() {
        StringBuilder numbers = new StringBuilder();
        for (int i = 1; i <= boardSize; i++) {
            numbers.append(i).append(" ");
        }
        return numbers.toString().trim();
    }

    /**
     * Prompts the current player to enter a move and updates the board.
     * @param scanner Scanner object for user input.
     */
    private static void playerMove(Scanner scanner) {
        int row, col;
        while (true) {
            System.out.print("Player " + currentPlayer + " - Enter your move (row and column): ");
            if (scanner.hasNextInt()) {
                row = scanner.nextInt() - 1;
                if (scanner.hasNextInt()) {
                    col = scanner.nextInt() - 1;
                    if (isValidMove(row, col)) {
                        board[row][col] = currentPlayer;
                        break;
                    } else {
                        System.out.println("Invalid move. Try again.");
                    }
                } else {
                    scanner.next(); // Clear invalid input
                }
            } else {
                scanner.next(); // Clear invalid input
            }
        }
    }

    /**
     * Checks if the selected move is valid.
     * @param row Row index.
     * @param col Column index.
     * @return true if valid, false otherwise.
     */
    private static boolean isValidMove(int row, int col) {
        return row >= 0 && row < boardSize && col >= 0 && col < boardSize && board[row][col] == EMPTY;
    }

    /**
     * Checks if the current player has won the game.
     * @return true if the player wins, false otherwise.
     */
    private static boolean checkWin() {
        for (int i = 0; i < boardSize; i++) {
            if (checkRow(i) || checkColumn(i)) return true;
        }
        return checkDiagonals();
    }

    /**
     * Checks if any row is a winning row.
     * @param row Row index.
     * @return true if all elements are the same, false otherwise.
     */
    private static boolean checkRow(int row) {
        for (int j = 1; j < boardSize; j++) {
            if (board[row][j] != board[row][0]) return false;
        }
        return board[row][0] != EMPTY;
    }

    /**
     * Checks if any column is a winning column.
     * @param col Column index.
     * @return true if all elements are the same, false otherwise.
     */
    private static boolean checkColumn(int col) {
        for (int i = 1; i < boardSize; i++) {
            if (board[i][col] != board[0][col]) return false;
        }
        return board[0][col] != EMPTY;
    }

    /**
     * Checks both diagonals for a winning condition.
     * @return true if any diagonal is a winning diagonal, false otherwise.
     */
    private static boolean checkDiagonals() {
        boolean mainDiagonal = true, antiDiagonal = true;
        for (int i = 1; i < boardSize; i++) {
            if (board[i][i] != board[0][0]) mainDiagonal = false;
            if (board[i][boardSize - i - 1] != board[0][boardSize - 1]) antiDiagonal = false;
        }
        return (mainDiagonal && board[0][0] != EMPTY) || (antiDiagonal && board[0][boardSize - 1] != EMPTY);
    }
}
