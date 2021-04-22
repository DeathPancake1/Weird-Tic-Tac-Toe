# Weird-Tic-Tac-Toe
 
## Problem Statement:

   I was required to write a program that develops the famous Tic-Tac-Toe game.

## Implementation:

   The program has 5 subprograms in it. We will be going through them in the order they are represented in the Structure diagram above.
1. Main Method:

   This is the main method of the program that is called to start the program. In our use case it is very simple and just calls the Make Layout method.
   
2. Make Layout:

   This is the method that defines the layout of our GUI using JavaSwing and defines the behavior of each component of the GUI.  
   The method’s algorithm in pseudocode:  
   o Defining the frame.  
   o Making the program terminate when frame is closed and set the layout to the GridBagLoyout.  
   o Initializing grid constraints and adding a label to determine the turns and the winner and labels for the number of wins for X and O.  
   o Defining the Button Listener subprogram (Which we will get into in the next point).  
   o Adding the array of Buttons to the frame with the proper constraints and using the variables rows and columns so it is easy to resize the game as we want in the   future.  
   o Adding the Button Listener to every Button with a for loop so it performs the behavior no matter which Button is pressed.  
   o Setting the size of the window and making it visible.  
   
3. Button Listener:

   This is the operation that occurs each time a user has pressed a Button.  
   Here is its behavior in pseudocode:  
   o Getting the object that performed the action.  
   o Checking who’s turn is it.  
   o If it is “X”’s turn it sets the text of the Button to “X” and makes the Button disabled so it cannot be pressed for the rest of the round.  
   o It calls the Check Win method with the parameter “X” If it returns a true value, it sets the turns label to “X wins”, increments the number of wins for “X” and rests every Button in the board to be enabled again and changes its text to the default ‘- ‘.  
   o If the Check Win method doesn’t return true it calls the Check Tie method, if it returns a true value, it changes the turns label to say “Tie”, makes every Button on the board enabled to reset the match and changes their labels to the default “-“.  
o The same operations from step 3 to step 5 are repeated for “O” if the program detects that the turn variable equals “O”.  

4. Check Win:

   This method takes a String as a parameter (“X” or “O”) and returns whether that String won or not by dividing it to 4 parts, check for vertical win, horizontal win, main diagonal win and secondary diagonal win.  
   o The vertical check works by looping through all the Buttons column by column. If in a column there are 3 consecutive Buttons with the same label it returns true. Otherwise, it moves to the horizontal check.  
   o The horizontal check works by looping through all the Buttons row by row. If in a row there are 3 consecutive Buttons with the same label it returns true. Otherwise, it moves to the main diagonal check.  
   o The main diagonal check works by looping through the Buttons row by row. If the 2 Buttons on the next 2 rows and 2 columns has the same text it returns true. Otherwise, it moves to the secondary diagonal check.  
   o The secondary diagonal check works by looping through all the Buttons row by row. If the 2 Buttons on the next 2 rows and previous 2 columns have the same text, then it returns true.  
   o If all these checks failed the method returns false.  
   
5. Check Tie:

   This method checks if the match ended in a tie by checking if none of the Buttons in the board have the default value “- “.  
   o It starts by initializing a variable called tie with the value false.  
   o The method then loops through the Buttons and checks if there is a Buttons with the default text “-“, then it makes the tie value to true.  
   o It returns the opposite of the tie variable, so if the loop found nothing then the game is tied and it returns true, if it found a Button with “-“ as text then this Button hasn’t been clicked yet so the game is tied.  
   
## Important variables: 
   1. Rows and Columns:  
   This is an obvious step to make these as variables so the board size can be changed by just changing a number.
   2. JButtons array:  
   We had to make this array so we can access and modify the buttons in multiple methods.
   3. Turn variable:  
   The purpose of this variable is to make the “X” start the game as in the rules and easily change it after every move.
   4. Labels:  
   The labels in this program are essential so the user can know who’s turn it is and who won and the score of the recent games. The turn Label checks the turn variable and changes its value when it changes, and the win labels check the numWin variables and changes their value when they change.
