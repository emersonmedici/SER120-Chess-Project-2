//Chess Project 2
//ChessPlayer.java


//import ser120.ChessProject2.Board;

package ser120.ChessProject2;
import java.util.Scanner;
import java.util.Arrays;


public class ChessPlayer {
	//goes through the steps of playing the chess game, takes and translates user input, taking turns, playing rounds, checking win condition
	
	//variables
	public Board board;
	public VisualOutput printer;
	public Player player1;
	public Player player2;
	public boolean stillPlaying;
	
	//constructors
	public ChessPlayer(){
		this.stillPlaying = true;
		this.player1 = new Player(0);
		this.player2 = new Player(1);
		this.printer = new VisualOutput();
		this.board = new Board(player1,player2);
	}
	
	//methods
	
	//runs the game, is a loop that plays rounds over and over as long as the game is still going (no one has won)
	//pass in a scanner from the game manager to take input later
	public void playChess(Scanner myScanner){
		System.out.println("Starting a new chess game...");
		while(stillPlaying){
			playRound(myScanner);
		}
		System.out.println("Closing chess game...");
	}
	
	//each round, player 1 takes a turn, then player 2 takes a turn. if someone wins, the game ends
	public void playRound(Scanner myScanner){
		printer.printBoard(board);
		takeTurn(player1, myScanner);
		if (checkForCheckmate()){
			printer.printBoard(board);
			stillPlaying = false;
		} else {
			printer.printBoard(board);
			takeTurn(player2, myScanner);
			if (checkForCheckmate()){
				stillPlaying = false;
				printer.printBoard(board);
			}
		}
	}
	
	//a piece of playing a round is players taking turns
	public void takeTurn(Player player, Scanner myScanner){
		//determines which team is going rn
		int team = player.getTeam();
		if (team == 0){
			System.out.println("Black's Turn!");
		} else {
			System.out.println("Whites's Turn!");
		}
		
		//some variabels to store user input
		int startCol = 0;
		int startRow = 0;
		int endCol = 0;
		int endRow = 0;
		Piece [][] boardData = new Piece[board.getBoardNumCols()][board.getBoardNumRows()];
		boardData = board.getBoardData();
		
		//loops until a valid move is aquired
		boolean moveIsValid = false;
		while (!moveIsValid){
			
			System.out.print("Which piece would you like to move?");
			startCol = promptUserCol(myScanner);
			startRow = promptUserRow(myScanner);
			
			//checks that there is a piece in the chosen tile
			if (boardData[startCol][startRow] != null){
				//checks that the selected piece belongs to the player whose turn it currently is
				if (boardData[startCol][startRow].getTeam() == player.getTeam()){
					System.out.print("Where would you like to move it?");
					endCol = promptUserCol(myScanner);
					endRow = promptUserRow(myScanner);
				
				//checks that the selected end location is different than the start location
					if (startCol != endCol || startRow != endRow){
				
						if (boardData[startCol][startRow].checkMoveValidity(startCol,startRow,endCol,endRow)){
							//if this piece can make this piece, the move is valid
							moveIsValid = true;
						} else {
							//if this piece cannot make that move, the loop must repeat
							//this code is tehcnically unecessary, but it verifies that the loop must repeat
							moveIsValid = false;
							System.out.print("That was not a valid move. (this piece cannot move that way)");
						}
						
					} else {
						moveIsValid = false;
						System.out.print("That was not a valid move. (you cannot stay put)");
					}
					
				} else {
					//if this piece doesn't belong to the player, the loop must repeat
					//this code is tehcnically unecessary, but it verifies that the loop must repeat
					moveIsValid = false;
					System.out.print("That was not a valid move.(this is not your piece)");
				}
				
			} else {
				//if there is no piece there to begin with, the loop must repeat
				//this code is tehcnically unecessary, but it verifies that the loop must repeat
				moveIsValid = false;
				System.out.print("That was not a valid move.(there is no piece there)");
			}
			
		}
		//exit while loop, means a valid move has been described\
		//move the piece
		int[][] pathArr = new int[board.getBoardNumCols()][board.getBoardNumRows()];
		pathArr = boardData[startCol][startRow].drawPath(startCol,startRow,endCol,endRow,board);
		System.out.println(Arrays.deepToString(pathArr).replace("], ", "]\n nextcol: "));
		board.movePiece(startCol,startRow,endCol,endRow);
		//here, other things might happen when the piece moves, such as capturing, but I don't know what that is yet
	}
	
	//these two methods (promptUserCol and promptUserRow) should be combined into one at some point, they are similar enough that it is doable with w=some parameters and/or conditional statements
	public int promptUserCol(Scanner myScanner){
		//integer to return
		int chosenCol = 0;
		//a string to hold user input
		String userInput = "";
		// a boolean to make a loop
		boolean isRealCoord = false;
		
		
		System.out.println("Enter a column: ");
		//loops until a real coordinate that exists on the board is given
		while (!isRealCoord){
			userInput = myScanner.nextLine();
			chosenCol = convertCol(userInput); 
			if (chosenCol == -1){
			//if it was not a valid entry, convertCol should return null
			//loop must repeat
				System.out.println("That is not a coordinate on the board, please enter something else.");
				isRealCoord = false;
			} else {
			//if chosenCol does get given a value by convertCol, the loop can end
				isRealCoord = true;
			}
		}
		return chosenCol;
		
	}
	
	public int promptUserRow(Scanner myScanner){
		//integer to return
		int chosenRow = 0;
		//a string to hold user input
		String userInput = "";
		// a boolean to make a loop
		boolean isRealCoord = false;
		
		
		System.out.println("Enter a row: ");
		//loops until a real coordinate that exists on the board is given
		while (!isRealCoord){
			userInput = myScanner.nextLine();
			chosenRow = convertRow(userInput); 
			if (chosenRow == -1){
			//if it was not a valid entry, convertCol should return null
			//loop must repeat
				System.out.println("That is not a coordinate on the board, please enter something else.");
				isRealCoord = false;
			} else {
			//if chosenCol does get given a value by convertCol, the loop can end
				isRealCoord = true;
			}
		}
		return chosenRow;
		
	}
	
	
	public boolean checkForCheckmate(){
		//checks for win condition, returns true if somebody won
		return false;
	}
	
	
	//simple method to convert user input into usable coordinates, should make more reliable and flexible in the future but this works for now
	public int convertCol(String string){
		switch (string) {
		case "a":
			return 0;
		case "b":
			return 1;
		case "c":
			return 2;
		case "d":
			return 3;
		case "e":
			return 4;
		case "f":
			return 5;
		case "g":
			return 6;
		case "h":
			return 7;
		default:
			return -1;
		}
	}
	
	//simple method to convert user input into usable coordinates, should make more reliable and flexible in the future but this works for now
	public int convertRow(String string){
		switch (string) {
		case "8":
			return 0;
		case "7":
			return 1;
		case "6":
			return 2;
		case "5":
			return 3;
		case "4":
			return 4;
		case "3":
			return 5;
		case "2":
			return 6;
		case "1":
			return 7;
		default:
			return -1;
		}
  }
	
	
}
