/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package TicTacToe;

/**
 *
 * @author momin
 */
public class TicTacToe {
 
    private int[][] board = new int[9][9];
    
    private TicTacToeUI ui;
    
    private String sign;

    public String getSign() {
        return sign;
    }

    public void setSign(String sign) {
        
        this.sign = sign;
    }
    public String getoppositeSign(){
        if(this.sign == "X")
            return "O";
        return "X";
    }
    
    private int player = 1;
    private int lastBoard = -1;
    
    private int[] winners = new int[9];
    public int[] Score = new int[2];
    
    private String playerName;
    
    public String Turn = playerName;
    
    public String getPlayerName() {
        return playerName;
    }
    
    public TicTacToe(){
        Score[0] = 0;
        Score[1] = 0;
        for(int i = 0; i < 9; i++){
            winners[i] = 0;
        }
        for(int i = 0; i < 9; i++)
            for(int j = 0; j < 9; j++)
            board[i][j] = 0;
    }
    public void setName(String name){
        if("".equals(name)){
            name = "You";
        }
        playerName = name;
    }
    
    public void Start(){
        ui = new TicTacToeUI();
        ui.init(this);
    }
    
    public void setLastBoard(int boardNo){
        if(winners[boardNo] != 0){
            lastBoard = -1;
            return;
        }            
        for(int i = 0; i < 9; i++){
            if(board[boardNo][i] == 0){
                lastBoard = boardNo;
                return;
            }
        }
        lastBoard = -1;
    
    
    }
    
    public Boolean makeMove(int x, int y){
        int boardNo = x;
        
            
        if(board[x][y] != 0)
            return false;
        if(winners[boardNo] != 0)
            return false;
        if(lastBoard != -1 && boardNo != lastBoard)
            return false;
        
        board[x][y] = player;
        player *= -1;
        setLastBoard(y);
        
        winners[boardNo] = checkWinner(boardNo);
        if(winners[boardNo] != 0){
            if(winners[boardNo] == -1){
                Score[0] = Score[0] + 10;
            }
            else{
                Score[1] += 10;
            }
            if(winners[boardNo] == -1)
                System.out.println("Board No: " + boardNo + "\tWinner: Computer" );
            else if(winners[boardNo] == 1)
                System.out.println("Board No: " + boardNo + "\tWinner: " + playerName);

            if(lastBoard == boardNo && checkWinner(lastBoard) != 0){
                lastBoard = -1;
            }
        
            if(checkFinalWinner() != 0){
                String msg = playerName + "  Won !!!";
                if(checkFinalWinner() == -1)
                    msg = playerName + " Lost ***";
                ui.updateBoard(getCellContents(x,y), x,y);
                ui.showWinner(msg);
                ui.EXIT();
            }
        }
        ui.updateBoard(getCellContents(x,y), x,y);
        return true;
    }
    
    public int checkWinner(int boardNo){
        
        if(board[boardNo][0] != 0 && board[boardNo][0] == board[boardNo][1] && board[boardNo][0] == board[boardNo][2])
            return board[boardNo][0];
        if(board[boardNo][3] != 0 && board[boardNo][3] == board[boardNo][4] && board[boardNo][3] == board[boardNo][5])
            return board[boardNo][3];
        if(board[boardNo][6] != 0 && board[boardNo][6] == board[boardNo][7] && board[boardNo][6] == board[boardNo][8])
            return board[boardNo][6];
        
        if(board[boardNo][0] != 0 && board[boardNo][0] == board[boardNo][3] && board[boardNo][0] == board[boardNo][6])
            return board[boardNo][0];
        if(board[boardNo][1] != 0 && board[boardNo][1] == board[boardNo][4] && board[boardNo][1] == board[boardNo][7])
            return board[boardNo][1];
        if(board[boardNo][2] != 0 && board[boardNo][2] == board[boardNo][5] && board[boardNo][2] == board[boardNo][8])
            return board[boardNo][2];
        
        if(board[boardNo][0] != 0 && board[boardNo][0] == board[boardNo][4] && board[boardNo][0] == board[boardNo][8])
            return board[boardNo][0];
        if(board[boardNo][2] != 0 && board[boardNo][2] == board[boardNo][4] && board[boardNo][2] == board[boardNo][6])
            return board[boardNo][2];
        return 0;
    }
    
    public int checkFinalWinner(){
       
        if(winners[0] != 0 && winners[0] == winners[1] && winners[0] == winners[2])
            return winners[0];
        if(winners[3] != 0 && winners[3] == winners[4] && winners[3] == winners[5])
            return winners[3];
        if(winners[6] != 0 && winners[6] == winners[7] && winners[6] == winners[8])
            return winners[6];
        
        if(winners[0] != 0 && winners[0] == winners[3] && winners[0] == winners[6])
            return winners[0];
        if(winners[1] != 0 && winners[1] == winners[4] && winners[1] == winners[7])
            return winners[1];
        if(winners[2] != 0 && winners[2] == winners[5] && winners[2] == winners[8])
            return winners[2];
        
        if(winners[0] != 0 && winners[0] == winners[4] && winners[0] == winners[8])
            return winners[0];
        if(winners[2] != 0 && winners[2] == winners[4] && winners[2] == winners[6])
            return winners[2];
        return 0;
    
    }
    
    public String getCellContents(int x, int y){
        if(board[x][y] == 1){ 
            Turn = "Computer";
            return sign;
        }
        else if (board[x][y] == -1){
            Turn = playerName ;
            
            if(sign == "X")
                return "O";
            else
                return "X";
        }
        return "";
    }
    
    
}
