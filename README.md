
# Tic Tac Toe

A basic tic tac toe game implemented with java swing.

## GamePlay:

In this game, the user has a board of 9x9 with 9 3x3 tictactoe boards and the gameplay is as follows

  1. `The program asks for the name of player.`

  2. `The Player is asked to choose the preferable sign('X' or 'O') in the game.` 
  
  3. `Computer takes the opposite sign to that.`

  4. `The game starts with the empty ultimate tic-tac-toe board.`

  5. `You need to win the game by continually printing the best next move, based on the game rules below. You will lose the test case if you write to an invalid board and/or write to a square that already has an X or O.`

  ##  Game Parts:

  1. `board: one of the 9 tic-tac-toe game boards`
  2. `square: one of the 81 individual squares`

  These Parts are needed to be understood as they are needed to understand game rules.

  ## Game Rules:

  1. `Like the original Tic-Tac-Toe, Player 1 is represented by either 'X' or ‘O’ and Player 2 (player 2 is computer, in this case) is represented by the opposite sign (if Player 1 is ‘X’, then Player 2 is ‘O’). To start the game, Player 1 places his/her chosen sign on any one of the 81 empty squares, and then players alternate turns.`
  2. `However, after the initial move, players must play the board that mirrors the square from the previous player.`
  3. `For example: If Player 1 places an X in the upper-right square of a board, then Player 2 must play the upper-right board. Continuing the example: If Player 2 places an O on the lower-middle square, then Player 1 must next play the lower-middle board.`

  ### Exceptions:
  `If the next move is to a board that is full or has already been won, then that player may choose an open square on any board, for that turn. If a player marks 3 consecutive squares (horizontally, vertically or diagonally) on any given board, he wins that board. The first player to win 3 consecutive boards (horizontally, vertically or diagonally) wins the game.`
 
 ## Demo Screenshot:
 ![](https://github.com/iamwaleediqbal/TicTacToe-Game/blob/master/tictactoe.PNG)


## Run Locally

Clone the project

```bash
  git clone https://github.com/iamwaleediqbal/TicTacToe-Game.git
```

Go to the project directory

```bash
  cd TicTacToe-Game
```

run with java


  
## Authors

- [@iamwaleediqbal](https://www.github.com/iamwaleediqbal)

  
