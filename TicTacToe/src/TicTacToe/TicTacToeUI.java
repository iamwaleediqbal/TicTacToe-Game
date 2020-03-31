/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package TicTacToe;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.GridLayout;
import java.awt.Point;
import java.awt.event.ActionEvent;
import javax.swing.*;
import java.util.Random;

/**
 *
 * @author momin
 */
public class TicTacToeUI {
    
    private final static int SIZE = 80;
    private TicTacToe game;
    
    private JButton[][] buttons;
    private JPanel content;
    private JFrame frame;
    private Popup p;
    private int pp = 0;
    
    private JLabel[] Show;
    
    public void setGame(TicTacToe game){
        this.game = game;
    }
    
    public String getTurn(){
        return game.Turn;
    }
    
    public String getPlayer(){
        return game.getPlayerName();
    }
    public String GetSign(){
        
        JCheckBox JCX = new JCheckBox("X");
        JCheckBox c1 = new JCheckBox("O");
      
        JPanel panel = new JPanel(); 
        panel.add(new JLabel("By Default, it is X"));
        panel.add(c1); 
        panel.add(JCX); 
        
        Object[] O = {"Please Select Sign, By Default, it is X",JCX,c1};
        JOptionPane.showMessageDialog(panel, O,"Sign",JOptionPane.YES_OPTION);
        
        if(JCX.isSelected())
            return JCX.getText();
        else if(c1.isSelected())
            return c1.getText();
        
        return "X"; //By Default
    }
   
    
    public void init(TicTacToe game){
        this.game = game;
        
        
        game.setName(JOptionPane.showInputDialog("Enter Player Name"));
        
        game.setSign(GetSign());

        frame = new JFrame ("Ultimate TicTacToe");
        frame.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        frame.setSize(new Dimension(1000,1000));
        
        content = new JPanel ();
        GridLayout layout = new GridLayout(4,3);

        layout.setHgap(5);
        layout.setVgap(5);

        content.setLayout(layout);
        Show = new JLabel[3];

        Show[0] = new JLabel(game.getPlayerName() +" ("+ game.getSign() + ") : " + game.Score[1]);
        Show[1] = new JLabel("Computer (" + game.getoppositeSign()+") : " + game.Score[0]);
        Show[2] = new JLabel("Current Turn: " + game.getPlayerName() );
        content.add(Show[0]);
        content.add(Show[1]);
        content.add(Show[2]);

        buttons = new JButton[9][9];

        for(int i = 0; i < 9; i++){
            JPanel gridPanel = new JPanel();
            gridPanel.setLayout(new GridLayout(3,3));
            for(int j = 0; j < 9; j++){
                buttons[i][j] = new JButton ();
                buttons[i][j].setPreferredSize (new Dimension (SIZE, SIZE)); 
                buttons[i][j].addActionListener(new TicTacAction(this, i,j));
                buttons[i][j].setBackground(Color.black);
                gridPanel.add(buttons[i][j]);
            }
            content.add (gridPanel);
        } 

        frame.add (content, BorderLayout.CENTER);
        frame.pack ();
        frame.setVisible (true);
    
    }
    
    private void CreatePopup(){
        
        PopupFactory pf = new PopupFactory();
        JPanel J = new JPanel();            

        JLabel l = new JLabel("Warning: Wrong Move");
        J.setBackground(Color.yellow);
        J.add(l);

        p = pf.getPopup(frame, J, 330,  30 );
        p.show();
        frame.show();
    }
    public void getClick(int x, int y){
        if(pp == 1){
            p.hide();
            pp = 0;
        }
        if(game.makeMove(x,y)){
           
            if(game.Turn.equals( game.getPlayerName()))
                updateBoard(game.getCellContents(x,y), x,y);
            else
                PlayComputer();
        }
        else{
            CreatePopup();
            pp = 1;
        }
      
    }
    public void PlayComputer(){
        Point Po = GeneratePoints();
        updateBoard(game.getCellContents(Po.x, Po.y),Po.x, Po.y);
          
    }
    Point GeneratePoints(){
        int x_ = 0;int y_ = 0;
        Random rand = new Random();
        x_ = rand.nextInt(9);
        for(y_ = 0;y_<9;y_++){
            if(game.makeMove(x_, y_))
                return new Point(x_,y_);
            if(game.makeMove(y_, x_))
                return new Point(y_,x_);
        }
        
        for(x_ = 0;x_<9;x_++){
            for(y_ = 0;y_<9;y_++){
                if(game.makeMove(x_, y_))
                    return new Point(x_,y_);
            }
        }
        return null;
    } 
         
    public void showWinner(String name){
        JOptionPane.showMessageDialog(frame, name);
    }
    
    public void updateBoard(String text, int x,int y){
        buttons[x][y].setText(text);
        buttons[x][y].setForeground(Color.white);
        Show[0].setText(game.getPlayerName() + " ("+game.getSign()+"): " + game.Score[1]);
        Show[1].setText("Computer (" + game.getoppositeSign()+"): " + game.Score[0]);
        Show[2].setText("Current Turn: " + game.Turn + " ||  Last Move: (" + x +","+y + ")");
        for(int k = 0;k<9;k++){
            if(game.checkWinner(k) != 0){
                for(int i = 0;i<9;i++){
                
                    buttons[k][i].setBackground(Color.GREEN);
                }
            }
        }
    }
    
    public void EXIT(){
        frame.setVisible(false);
    }
    
    
}
