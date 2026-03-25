//Chess Project 2
//GameManager.java

package ser120.ChessProject2;

//import ser120.ChessProject2.ChessPlayer;
//import ser120.ChessProject2.ChessReplayer;
import java.util.Scanner;

public class GameManager {
	//this runs the program, takes user input and then decides which class should handle what comes next
	
	//variables
	public ChessPlayer myChessPlayer;
    public ChessReplayer myChessReplayer;
    boolean running;
  
	//constructors
    public GameManager() {
		this.running = true;
		this.myChessReplayer = new ChessReplayer();
		this.myChessPlayer = new ChessPlayer(myChessReplayer);
	}

	//methods
	public void runGame(){
		//instantiate the scanner
		Scanner myScanner = new Scanner(System.in);
		//string to hold user input
		String userInput = "";
		
		System.out.println("Welcome to the Chess Program!");
		while (running){
			System.out.println("Enter 'r' to reload an previous game, 'n' to start a new game, or anything else to quit: ");
			userInput = myScanner.nextLine();
			if (userInput.equals("r")){
			//reload previous game using the chess replayer
			} else if (userInput.equals("n")){
				myChessPlayer.playChess(myScanner);
			} else {
				running = false;
			}
		
		}
		
		myScanner.close();
	}
    
}





