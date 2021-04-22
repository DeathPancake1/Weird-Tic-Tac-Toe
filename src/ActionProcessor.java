import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;

public class ActionProcessor implements ActionListener{
	public void actionPerformed(ActionEvent ae) {
		//Getting the button that is pressed
		Object o =ae.getSource();
		if(Layout.turn=="X") {
			//Setting the text to the player who pressed it
			((JButton) o).setText("X");
			//Changing the turn to the next player
			Layout.turn = "O";
			Layout.turnLbl.setText(Layout.turn+"'s turn");
			//Making the Button Disabled so it can't be pressed 
			((JButton) o).setEnabled(false);
			//If X wins change all the buttons back to enabled and increase X win counter
			if(Algorithims.checkWin("X")) {
				Layout.turnLbl.setText("X Wins");
				Layout.XNumWins++;
				for (int i=0;i<Layout.rows;i++) {
					for (int j=0;j<Layout.columns;j++) {
						Layout.Buttons[i][j].setText("-");
						Layout.Buttons[i][j].setEnabled(true);
						Layout.XWins.setText("X Wins: "+Layout.XNumWins);
					}
				}
			}
			//If it is a tie tell the user it is a tie and make all the buttons enabled to start a new game
			else if(Algorithims.checkTie()) {
				Layout.turnLbl.setText("Tie");
				for (int i=0;i<Layout.rows;i++) {
					for (int j=0;j<Layout.columns;j++) {
						Layout.Buttons[i][j].setText("-");
						Layout.Buttons[i][j].setEnabled(true);
					}
				}
			}
		}
		//This is the same code of the condition above but for O not X
		else if(Layout.turn=="O") {
			((JButton) o).setText("O");
			Layout.turn="X";
			Layout.turnLbl.setText(Layout.turn+"'s turn");
			((JButton) o).setEnabled(false);
			if(Algorithims.checkWin("O")) {
				Layout.turnLbl.setText("O Wins");
				Layout.ONumWins++;
				for (int i=0;i<Layout.rows;i++) {
					for (int j=0;j<Layout.columns;j++) {
						Layout.Buttons[i][j].setText("-");
						Layout.Buttons[i][j].setEnabled(true);
						Layout.OWins.setText("O Wins: "+Layout.ONumWins);
					}
				}
			}
			else if(Algorithims.checkTie()) {
				Layout.turnLbl.setText("Tie");
				for (int i=0;i<Layout.rows;i++) {
					for (int j=0;j<Layout.columns;j++) {
						Layout.Buttons[i][j].setText("-");
						Layout.Buttons[i][j].setEnabled(true);
					}
				}
			}
		}
	}
}
