# TicTacToe-Game

In this game, the user has a board of 9x9 with 9 3x3 tictactoe boards and the gameplay is as follows
1. The program asks for the name of player.
2. Player is asked to choose the preferable sign in the game. Computer takes the opposite sign to that.
3. The game starts with the empty ultimate tic-tac-toe board
4. You need to win the game by continually printing the best next move, based on the game rules below. 
You will lose the test case if you write to an invalid board and/or write to a square that already has an X or O. For the purposes of these instructions: 

• board = one of the 9 tic-tac-toe game boards 

• square = one of the 81 individual squares


Game Rules:
Like the original Tic-Tac-Toe, Player 1 is represented by either 'X' or ‘O’ and Player 2 (player 2 is computer, in this case) is represented by the opposite sign 
(if Player 1 is ‘X’, then Player 2 is ‘O’). To start the game, Player 1 places his/her chosen sign on any one of the 81 empty squares, and then players alternate turns. 

However, after the initial move, players must play the board that mirrors the square from the previous player. 

For example: If Player 1 places an X in the upper-right square of a board, then Player 2 must play the upper-right board.
Continuing the example: If Player 2 places an O on the lower-middle square, then Player 1 must next play the lower-middle board. 


Here are the necessary exceptions: 


If the next move is to a board that is full or has already been won, then that player may choose an open square on any board, for that turn.
If a player marks 3 consecutive squares (horizontally, vertically or diagonally) on any given board, he wins that board.
The first player to win 3 consecutive boards (horizontally, vertically or diagonally) wins the game.
