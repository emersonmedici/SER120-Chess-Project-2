//Chess Project 2
//Queen.java

package ser120.ChessProject2;


class Queen extends Piece {
	
	//variables (add if needed)
	
	//constructors
	public Queen(Player initPlayer){
		super(initPlayer);
	}
	
	//methods
	public boolean checkMoveValidity(int startCol, int startRow, int endCol, int endRow){
		//check move validity for this piece, how does this piece move?
		return true;
	}
	
	public String getVisual(){
		if (this.team == 0){
			return "BQ ";
		} else {
			return "WQ ";
		}
	}
	
	
}

