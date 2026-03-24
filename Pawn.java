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
	public boolean checkMoveValidity(int startCol, int startRow, int endCol, int endRow, Board board){
		
		//check move validity for this piece, how does this piece move?
		
		//old, does not account for special capture move
		/*//for white
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
		}*/
		
		//putting the boardData array here to reference
		Piece [][] boardData = new Piece[board.getBoardNumCols()][board.getBoardNumRows()];
		boardData = board.getBoardData();
		
		//for white
		if (this.team == 1){
			if (endRow > startRow){ // if the piece is trying to move backwards (not allowed)
				return false;
			} else { //piece is not trying to move backwards
				if (endRow < startRow - 1) { // if the piece is trying to move too far forward
					return false;
				} else { //the piece is moving exactly one tile forward
					if (endCol != startCol){ //if the piece is trying to move horizontally (only allowed in diagonal capture)
						if( (endCol > startCol + 1) || (endCol < startCol - 1)){ //if it is NOT a valid 1 tile diagonal move
							return false;
						} else { //the piece is making a valid diagonal move
							if (boardData[endCol][endRow] == null){ //if there is no piece in the landing spot at all
								return false; 
							} else { //if there IS a piece in the landing spot
								if (boardData[endCol][endRow].getTeam() != this.team){ //if that piece is on the opposite team
									return true; //make a valid capture move
								} else { //if that piece is NOT on the opposite team, it's a friendly piece
									return false;
								}
							}
						}
					} else { //if the piece is not trying to move horizontally
						return true; //the piece is making a valid 1-tile-forward move
					}
				}
			}
		} else {
		//for black
			if (endRow < startRow){ // if the piece is trying to move backwards (not allowed)
				return false;
			} else { //piece is not trying to move backwards
				if (endRow > startRow + 1) { // if the piece is trying to move too far forward
					return false;
				} else { //the piece is moving exactly one tile forward
					if (endCol != startCol){ //if the piece is trying to move horizontally (only allowed in diagonal capture)
						if( (endCol > startCol + 1) || (endCol < startCol - 1) ){ //if it is NOT a valid 1 tile diagonal move
							return false;
						} else { //the piece is making a valid diagonal move
							if (boardData[endCol][endRow] == null){ //if there is no piece in the landing spot at all
								return false; 
							} else { //if there IS a piece in the landing spot
								if (boardData[endCol][endRow].getTeam() != this.team){ //if that piece is on the opposite team
									return true; //make a valid capture move
								} else { //if that piece is NOT on the opposite team, it's a friendly piece
									return false;
								}
							}
						}
					} else { //if the piece is not trying to move horizontally
						return true; //the piece is making a valid 1-tile-forward move
					}
				}
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
	
	//returns a string that says what type of piece it is
	public String getType(){
		return "pawn";
	}
	
}

