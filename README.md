# Tic-Tac-Toe Game

A customizable two-player Tic-Tac-Toe game written in Java. This game allows players to specify the board size (3x3 or greater) and play against each other in a turn-based format.

## Features
- **Custom Board Size**: Players can define the size of the Tic-Tac-Toe board (minimum 3x3).
- **Turn-Based Gameplay**: Players take turns to place 'X' and 'O' on the board.
- **Win Detection**: The game automatically detects row, column, or diagonal wins.
- **Draw Detection**: If all spots are filled without a winner, the game announces a draw.
- **Replay Option**: After a match, players can choose to play again.

## How to Play
1. Run the Java program.
2. Enter the desired board size (must be 3 or greater).
3. Players take turns entering their move by specifying row and column numbers (1-based index).
4. The game continues until a player wins or the board is full.
5. At the end of the game, choose whether to play again.

## Installation & Execution
1. Ensure you have Java installed (JDK 8 or later).
2. Compile the program using:
   ```sh
   javac TicTacToe.java
   ```
3. Run the compiled program:
   ```sh
   java TicTacToe
   ```

## Example Gameplay
```
Enter the board size (3 or greater): 3

   1 2 3
1  X|O|X
   -----
2  O|X|O
   -----
3  O|X|X

Player X wins!
Do you want to play again? (yes/no): no
```

## Future Enhancements
- Add an AI opponent for single-player mode.
- Implement a graphical user interface (GUI).
- Introduce an undo/redo feature.

## License
This project is open-source and available under the MIT License.

