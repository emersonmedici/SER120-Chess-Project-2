//Chess Project 2
//Queen.java

package ser120.ChessProject2;


class Queen extends Piece {
	
	//variables (add if needed)
	
	//constructors
	public Queen(Player initPlayer, String initType){
		super(initPlayer, "queen");
	}
	
	//methods
	public boolean checkMoveValidity(int startCol, int startRow, int endCol, int endRow){
		//check move validity for this piece, how does this piece move?
		//queen is combo of rook and bishop
		
		if ((Math.abs(endCol - startCol) != Math.abs(endRow - startRow)) && (endRow != startRow && endCol != startCol)){
			return false;
		} else {
			return true;
		}
	}
	
	public int[][] drawPath(int startCol, int startRow, int endCol, int endRow, Board board){
		int [][] pathArray = new int[board.getBoardNumCols()][board.getBoardNumRows()];
		return pathArray;
	}
	
	public String getVisual(){
		if (this.team == 0){
			return "BQ ";
		} else {
			return "WQ ";
		}
	}
	
	
}

