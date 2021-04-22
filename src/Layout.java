import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Insets;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;

public class Layout {
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
		static ActionProcessor buttonListener = new ActionProcessor();
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
	}
