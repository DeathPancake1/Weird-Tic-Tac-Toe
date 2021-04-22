
public class Algorithims {
	//This method checks if the person who pressed a button won with that move
		public static Boolean checkWin(String s) {
			//This is the vertical check works by stopping at every column and checking if there are 3 consecutive Buttons that have the same text
			for (int i=0;i<Layout.columns;i++) {
				for (int j=0;j<Layout.rows-2;j++) {
					if((Layout.Buttons[j][i].getText()+Layout.Buttons[j+1][i].getText()+Layout.Buttons[j+2][i].getText()).equals(s+s+s)){
						return true;
					}
				}
			}
			//This is the horizontal check works by stopping at every row and checking if there are consecutive 3 Buttons that have the same text
			for (int i=0;i<Layout.rows;i++) {
				for (int j=0;j<Layout.columns-2;j++) {
					if((Layout.Buttons[i][j].getText()+Layout.Buttons[i][j+1].getText()+Layout.Buttons[i][j+2].getText()).equals(s+s+s)){
						return true;
					}
				}
			}
			//This is the Layout diagonal check
			for (int i=0;i<Layout.rows-2;i++) {
				for (int j=0;j<Layout.columns-2;j++) {
					if((Layout.Buttons[i][j].getText()+Layout.Buttons[i+1][j+1].getText()+Layout.Buttons[i+2][j+2].getText()).equals(s+s+s)){
						return true;
					}
				}
			}
			//This is the secondary diagonal check
			for (int i=0;i<Layout.rows-2;i++) {
				for (int j=2;j<Layout.columns;j++) {
					if((Layout.Buttons[i][j].getText()+Layout.Buttons[i+1][j-1].getText()+Layout.Buttons[i+2][j-2].getText()).equals(s+s+s)){
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
			for (int i=0;i<Layout.rows;i++) {
				for (int j=0;j<Layout.columns;j++) {
					if(Layout.Buttons[i][j].getText().equals("-")) {
						//If we found that there are still not pressed buttons we make it true
						tie = true;
					}
				}
			}
			//Then we return the opposite if the tie variable
			//So if we found no not pressed buttons it returns true and vice versa
			return !tie;
		}
}
