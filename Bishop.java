//Chess Project 2
//Bishop.java

package ser120.ChessProject2;


class Bishop extends Piece {
	
	
	//variables (add if needed)
	
	//constructors
	public Bishop(Player initPlayer, String initType){
		super(initPlayer,"bishop");
	}
	
	//methods
	public boolean checkMoveValidity(int startCol, int startRow, int endCol, int endRow){
		//check move validity for this piece, how does this piece move?
		//diagonal movements only
		//System.out.println(endCol + " - " + startCol + " = " + (endCol - startCol) + " and " + endRow + " - " + startRow + " = " + (endRow - startRow));
		if (Math.abs(endCol - startCol) != Math.abs(endRow - startRow)){
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
			return "BB ";
		} else {
			return "WB ";
		}
	}
	
}

