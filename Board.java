//ll

package ser120.ChessProject2;
//import ser120.ChessProject2.Piece;

public class Board {
	//stores and handles the board data
  
	//variables
	private int numRows;
	private int numCols;
	private Piece[][] boardData;

  //constructors
  //we could make rows and cols variables in the future, but for now the columns and rows will always be 8
  //passing through players as a parameter here because the pieces need to be instantiated with them, the players will be made by the ChessPlayer object and passed through as parameters upon the board's creation
  public Board(/*int initRows, int initCols*/ Player player1, Player player2){
    this.numRows = 8;
    this.numCols = 8;
    this.boardData = new Piece[numCols][numRows]; //it's coordinates: columns = x, rows = y
    
    //potentially more efficient way to fill the board, try again later
    //int col = 0;
    //int row = 0;
	//board[col][row] = new Rook();
	//row++
	
	//fill the board to start with
	boardData[0][0] = new Rook(player1);
	boardData[1][0] = new Knight(player1);
	boardData[2][0] = new Bishop(player1);
	boardData[3][0] = new Queen(player1);
	boardData[4][0] = new King(player1);
	boardData[5][0] = new Bishop(player1);
	boardData[6][0] = new Knight(player1);
	boardData[7][0] = new Rook(player1);
	
	boardData[0][1] = new Pawn(player1);
	boardData[1][1] = new Pawn(player1);
	boardData[2][1] = new Pawn(player1);
	boardData[3][1] = new Pawn(player1);
	boardData[4][1] = new Pawn(player1);
	boardData[5][1] = new Pawn(player1);
	boardData[6][1] = new Pawn(player1);
	boardData[7][1] = new Pawn(player1);
	
	
    boardData[0][6] = new Pawn(player2);
	boardData[1][6] = new Pawn(player2);
	boardData[2][6] = new Pawn(player2);
	boardData[3][6] = new Pawn(player2);
	boardData[4][6] = new Pawn(player2);
	boardData[5][6] = new Pawn(player2);
	boardData[6][6] = new Pawn(player2);
	boardData[7][6] = new Pawn(player2);
	
	boardData[0][7] = new Rook(player2);
	boardData[1][7] = new Knight(player2);
	boardData[2][7] = new Bishop(player2);
	boardData[3][7] = new Queen(player2);
	boardData[4][7] = new King(player2);
	boardData[5][7] = new Bishop(player2);
	boardData[6][7] = new Knight(player2);
	boardData[7][7] = new Rook(player2);
  }

  //methods

	//method to change the board data by moving a piece
	//should only be called after checking the validity of the move!
	public void movePiece(int startCol, int startRow, int endCol, int endRow){
		//puts the piece in a new spot
		boardData[endCol][endRow] = boardData[startCol][startRow];
		//removes the piece from the old spot
		boardData[startCol][startRow] = null;
	}
	
	
	//getters
	public Piece[][] getBoardData(){
		return boardData;
	}
	
	public int getBoardNumCols(){
		return this.numCols;
	}
	
	public int getBoardNumRows(){
		return this.numRows;
	}


}

