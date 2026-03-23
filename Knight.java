//Chess Project 2
//Knight.java

package ser120.ChessProject2;


class Knight extends Piece {
	
	
	//variables (add if needed)
	
	//constructors
	public Knight(Player initPlayer){
		super(initPlayer);
	}
	
	//methods
	public boolean checkMoveValidity(int startCol, int startRow, int endCol, int endRow){
		//check move validity for this piece, how does this piece move?
		//L
		if( Math.abs(endRow - startRow) != 2 || Math.abs(endCol - startCol) !=1 ){
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
			return "BKN";
		} else {
			return "WKN";
		}
	}
	
}
