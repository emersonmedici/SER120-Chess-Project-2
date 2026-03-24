//Chess Project 2
//Pawn.java

package ser120.ChessProject2;


class Pawn extends Piece {
	
	
	//variables (add if needed)
	
	//constructors
	public Pawn(Player initPlayer, String initType){
		super(initPlayer, "pawn");
	}
	
	//methods
	public boolean checkMoveValidity(int startCol, int startRow, int endCol, int endRow){
		//check move validity for this piece, how does this piece move?
		//for white
		if (this.player.getTeam() == 1){
			if (endCol != startCol || endRow > startRow || endRow < startRow - 1){
				return false;
			} else {
				return true;
			}
		} else {
		//for black
		if (endCol != startCol || endRow < startRow || endRow > startRow + 1){
				return false;
			} else {
				return true;
			}
		}
	}
	
	public int[][] drawPath(int startCol, int startRow, int endCol, int endRow, Board board){
		int [][] pathArray = new int[board.getBoardNumCols()][board.getBoardNumRows()];
		return pathArray;
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

