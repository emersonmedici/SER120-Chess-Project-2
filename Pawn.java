//Chess Project 2
//Pawn.java

package ser120.ChessProject2;


class Pawn extends Piece {
	
	
	//variables (add if needed)
	
	//constructors
	public Pawn(Player initPlayer){
		super(initPlayer);
	}
	
	//methods
	public boolean checkMoveValidity(int startCol, int startRow, int endCol, int endRow){
		//check move validity for this piece, how does this piece move?
		return true;
	}
	
	//returns a string to print, represents the piece on the board, helper method for the printer, 
	public String getVisual(){
		if (this.team == 0){
			return "BP ";
		} else {
			return "WP ";
		}
	}
	
}

