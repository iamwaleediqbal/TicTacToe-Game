/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package TicTacToe;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

/**
 *
 * @author momin
 */
public class TicTacAction implements ActionListener{

    private TicTacToeUI ui;
    private int x;
    private int y;

    public TicTacAction(TicTacToeUI ui, int x, int y) {
        this.ui = ui;
        this.x = x;
        this.y = y;
    }
    
    
    @Override
    public void actionPerformed(ActionEvent e) {
        ui.getClick(x,y);
    }
}
