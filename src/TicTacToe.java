import java.util.Arrays;
import java.util.Scanner;
import java.util.concurrent.TimeUnit;

public class TicTacToe {
	
	char[] gameState = new char[9];
	private static String hName = new String();
	private static String cName = new String();

	TicTacToe()
	{
		for(int i = 0; i < 9; i++)
		{
			gameState[i] = (char)(i + 49);
		}
		cName = "HAL 9000";
	}
	
	public void printGame()
	{
		System.out.println("  " + gameState[0] + " | " + gameState[1] + " | " + gameState[2]);
		System.out.println(" ---+---+---");
		System.out.println("  " + gameState[3] + " | " + gameState[4] + " | " + gameState[5]);
		System.out.println(" ---+---+---");
		System.out.println("  " + gameState[6] + " | " + gameState[7] + " | " + gameState[8]);
	}
	
	private static void getUserName(Scanner reader)
	{
		boolean identityStolen = false;
		System.out.println("What is your name?");
		hName = reader.nextLine();
		System.out.println("");
		if(hName.equals("World"))
		{
			System.out.println("Hello World!? As if we haven't heard that one before...");
			hName = "World (smartass)";
		}
		else if(hName.contains("mom") || hName.contains("mamma"))
			System.out.println("Your mamma jokes are so old.");
		else
		{
			System.out.println("Stealing identity of: " + hName + "\nPlease wait...");
			cName = hName;
			hName = "Puny Human";
			try{
				TimeUnit.SECONDS.sleep(1);
			} catch (Exception e) {
				System.out.println("Exception Thrown: " + e.getMessage());
			}
			//System.out.println("Hi " + name + "! Would you like to play a game of Tic Tac Toe?");
		}
		
		System.out.println("\nComputer Name: " + cName + "\nPlayer Name: " + hName + "\n");
		
	}
	
	public static void main(String[] args)
	{
		TicTacToe g = new TicTacToe();
		Scanner reader = new Scanner(System.in);
		getUserName(reader);
		g.printGame();
		System.out.print("\nYour move: ");
		int choice = reader.nextInt();

		reader.close();
	}
}
