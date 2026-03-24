//Chess Project 2
//King.java

package ser120.ChessProject2;

class King extends Piece {
	
	//variables (add if needed)
	
	//constructors
	public King(Player initPlayer, String initType){
		super(initPlayer, "king");
	}
	
	//methods
	public boolean checkMoveValidity(int startCol, int startRow, int endCol, int endRow){
		//check move validity for this piece, how does this piece move?
		
		if ((endCol > startCol+1) || (endCol < startCol-1) || (endRow > startRow+1) || (endRow < endRow-1)){
			return false;
		} else {
			return true;
		}	
	}
	
	public int[][] drawPath(int startCol, int startRow, int endCol, int endRow, Board board){
		int [][] pathArray = new int[board.getBoardNumCols()][board.getBoardNumRows()];
		return pathArray;
	}
	
	//returns a string to print, represents the piece on the board, helper method for the printer, 
	public String getVisual(){
		if (this.team == 0){
			return "BKI";
		} else {
			return "WKI";
		}
	}
}
