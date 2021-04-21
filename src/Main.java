import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Insets;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.*;

public class Main {
	
	//Defining variables for rows and columns so they are easy to change in the future
	static final int rows=6;
	static final int columns=7;
	//Making an array of the Buttons we are going to use
	static JButton[][] Buttons= new JButton[rows][columns];
	//X Starts the first Tic-Tac-Toe game
	static String turn="X";
	//Making the label that says who's turn it is and the labels for the win counters
	static JLabel turnLbl = new JLabel(turn+"'s turn");
	static JLabel students = new JLabel("Youssef Mohamed Ahmed ID:7211 // Mariam Hamada Meky ID:7072");
	static int XNumWins=0;
	static int ONumWins=0;
	static JLabel XWins = new JLabel("X Wins: "+XNumWins);
	static JLabel OWins = new JLabel("O Wins: "+ONumWins);
	
	public static void makeLayout() {
		//Initializing the frame(container) that holds the game
		JFrame f= new JFrame();
		//Adjusting the Jframe to terminate the program when the window is closed
		f.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		//Setting the layout to the GridBagLayout for its ease of use
		f.setLayout(new GridBagLayout());
		//Initializing the GridBagConstraints
		GridBagConstraints gbc = new GridBagConstraints();
		gbc.gridx=0;
		gbc.gridy=0;
		//Making the action listener that listens to all the buttons
		ActionListener buttonListener = new ActionListener() {
			@Override
			public void  actionPerformed(ActionEvent ae) {
				//Getting the button that is pressed
				Object o =ae.getSource();
				if(turn=="X") {
					//Setting the text to the player who pressed it
					((AbstractButton) o).setText("X");
					//Changing the turn to the next player
					turn = "O";
					turnLbl.setText(turn+"'s turn");
					//Making the Button Disabled so it can't be pressed 
					((AbstractButton) o).setEnabled(false);
					//If X wins change all the buttons back to enabled and increase X win counter
					if(checkWin("X")) {
						turnLbl.setText("X Wins");
						XNumWins++;
						for (int i=0;i<rows;i++) {
							for (int j=0;j<columns;j++) {
								Buttons[i][j].setText("-");
								Buttons[i][j].setEnabled(true);
								XWins.setText("X Wins: "+XNumWins);
							}
						}
					}
					//If it is a tie tell the user it is a tie and make all the buttons enabled to start a new game
					else if(checkTie()) {
						turnLbl.setText("Tie");
						for (int i=0;i<rows;i++) {
							for (int j=0;j<columns;j++) {
								Buttons[i][j].setText("-");
								Buttons[i][j].setEnabled(true);
							}
						}
					}
				}
				//This is the same code of the condition above but for O not X
				else if(turn=="O") {
					((AbstractButton) o).setText("O");
					turn="X";
					turnLbl.setText(turn+"'s turn");
					((AbstractButton) o).setEnabled(false);
					if(checkWin("O")) {
						turnLbl.setText("O Wins");
						ONumWins++;
						for (int i=0;i<rows;i++) {
							for (int j=0;j<columns;j++) {
								Buttons[i][j].setText("-");
								Buttons[i][j].setEnabled(true);
								OWins.setText("O Wins: "+ONumWins);
							}
						}
					}
					else if(checkTie()) {
						turnLbl.setText("Tie");
						for (int i=0;i<rows;i++) {
							for (int j=0;j<columns;j++) {
								Buttons[i][j].setText("-");
								Buttons[i][j].setEnabled(true);
							}
						}
					}
				}
			}
		};
		//The rest of the method is just adding some visual aids to help the game be more playable and adding the buttons and labels in the correct layouts
		for (int i=0;i<rows;i++) {
			for (int j=0;j<columns;j++) {
				//This loop initializes every Button to "-" and adds the action listener to it
				Buttons[i][j]=new JButton("-");
				Buttons[i][j].addActionListener(buttonListener);
			}
		}
		//This is the GridBagConstrains variable that we made earlier we use it to set the starting position for all our components
		gbc.gridx=0;
		gbc.gridy=0;
		gbc.gridwidth=140;
		f.add(students,gbc);
		gbc.gridwidth=1;
		gbc.gridx=60;
		gbc.gridy=20;
		//Adding the Turns label to the frame
		f.add(turnLbl,gbc);
		gbc.gridx=0;
		gbc.gridy=40;
		//Adding the XWins and YWins labels to the frame
		f.add(XWins,gbc);
		gbc.gridx=120;
		f.add(OWins,gbc);
		gbc.gridheight=1;
		gbc.insets=new Insets(2,2,2,2);
		for (int i=0;i<rows;i++) {
			for (int j=0;j<columns;j++) {
				//Adding each Button to the frame with a layout that is representative of how the game works
				gbc.gridx=(j)*20;
				gbc.gridy=(i+3)*20;
			    gbc.ipady = 20; 
			    gbc.ipadx=20;
				f.add(Buttons[i][j],gbc);
			}
		}
		//Setting the size of the window and making it visible
		f.setSize(600,600);
		f.setVisible(true);
	}

	//This method checks if the person who pressed a button won with that move
	public static Boolean checkWin(String s) {
		//This is the vertical check works by stopping at every column and checking if there are 3 consecutive Buttons that have the same text
		for (int i=0;i<columns;i++) {
			for (int j=0;j<rows-2;j++) {
				if((Buttons[j][i].getText()+Buttons[j+1][i].getText()+Buttons[j+2][i].getText()).equals(s+s+s)){
					return true;
				}
			}
		}
		//This is the horizontal check works by stopping at every row and checking if there are consecutive 3 Buttons that have the same text
		for (int i=0;i<rows;i++) {
			for (int j=0;j<columns-2;j++) {
				if((Buttons[i][j].getText()+Buttons[i][j+1].getText()+Buttons[i][j+2].getText()).equals(s+s+s)){
					return true;
				}
			}
		}
		//This is the main diagonal check
		for (int i=0;i<rows-2;i++) {
			for (int j=0;j<columns-2;j++) {
				if((Buttons[i][j].getText()+Buttons[i+1][j+1].getText()+Buttons[i+2][j+2].getText()).equals(s+s+s)){
					return true;
				}
			}
		}
		//This is the secondary diagonal check
		for (int i=2;i<rows;i++) {
			for (int j=0;j<columns-2;j++) {
				if((Buttons[i][j].getText()+Buttons[i-1][j+1].getText()+Buttons[i-2][j+2].getText()).equals(s+s+s)){
					return true;
				}
			}
		}
		//If none of the conditions above worked returns false
		return false;
	}
	
	//This method checks if the two players tied or not
	public static Boolean checkTie() {
		//The default value of the tie variable is false
		Boolean tie= false;
		for (int i=0;i<rows;i++) {
			for (int j=0;j<columns;j++) {
				if(Buttons[i][j].getText().equals("-")) {
					//If we found that there are still not pressed buttons we make it true
					tie = true;
				}
			}
		}
		//Then we return the opposite if the tie variable
		//So if we found no not pressed buttons it returns true and vice versa
		return !tie;
	}
	public static void main(String[] args) {
		//The main method calls the makeLayout method to make the layout
		makeLayout();
        }
	}
