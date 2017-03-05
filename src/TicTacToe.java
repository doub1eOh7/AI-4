import java.util.Arrays;

import java.util.Scanner;
import java.util.concurrent.TimeUnit;

public class TicTacToe {
	
	GameState gameState = new GameState();
	private static String hName = new String();
	private static String cName = new String();

	TicTacToe()
	{
		for(int i = 0; i < 9; i++)
		{
			gameState.s[i] = (char)(i + 49);
		}
		cName = "HAL 9000";
	}
	
	public void printGame()
	{
		System.out.println("  " + gameState.s[0] + " | " + gameState.s[1] + " | " + gameState.s[2]);
		System.out.println(" ---+---+---");
		System.out.println("  " + gameState.s[3] + " | " + gameState.s[4] + " | " + gameState.s[5]);
		System.out.println(" ---+---+---");
		System.out.println("  " + gameState.s[6] + " | " + gameState.s[7] + " | " + gameState.s[8]);
	}
	
	private static void getUserName(Scanner reader)
	{
		System.out.println("What is your name?");
		hName = reader.nextLine();
		System.out.println("");
		/*
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
		*/
		System.out.println("\nComputer Name: " + cName + "\nPlayer Name: " + hName + "\n");
		
	}
	
	private GameState computerMove()
	{
		GameState nextMove = new GameState();
		int bestValue = Integer.MIN_VALUE;
		for(GameState s : gameState.getChildren(false))
		{
			//System.out.println(s.toString());
			MiniMax mm = new MiniMax();
			int value = mm.minimax(s, 1000, false);
			//System.out.println("Value: " + value);
			if(value > bestValue)
			{
				bestValue = value;
				nextMove = s;
			}
		}
		return nextMove;
	}
	
	public static void main(String[] args)
	{
		TicTacToe g = new TicTacToe();
		Scanner reader = new Scanner(System.in);
		getUserName(reader);
		boolean notOver = true;
		while(notOver)
		{
			g.printGame();
			System.out.print("\nYour move: ");
			int choice = reader.nextInt();
			if(choice > 0 && choice < 10 && g.gameState.s[choice - 1] != 'O' && g.gameState.s[choice - 1] != 'X')
				g.gameState.s[choice - 1] = 'X';
			else
			{
				boolean invalid = true;
				while(invalid)
				{
					System.out.println("Invalid Move");
					g.printGame();
					System.out.print("Your move: ");
					choice = reader.nextInt();
					if(choice > 0 && choice < 10 && g.gameState.s[choice - 1] != 'O' && g.gameState.s[choice - 1] != 'X')
					{
						g.gameState.s[choice - 1] = 'X';
						invalid = false;
					}
				}
			}
			if(g.gameState.end())
				notOver = false;
			if(notOver)
				g.gameState = g.computerMove();
			if(g.gameState.end())
				notOver = false;
			
		}
		g.printGame();
		//System.out.println(g.gameState.whoWon());
		if(g.gameState.whoWon() == 1)
			System.out.println(hName + " lost!");
		else
			System.out.println("TIE");

		reader.close();
	}
}
