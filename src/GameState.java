import java.util.HashSet;
public class GameState {
	public GameState p;
	public char[] s = new char[9];
	
	public boolean end()
	{
		if(s[0] != '1' && s[0] == s[1] && s[1] == s[2]) //Top Row
			return true;
		else if(s[0] != '1' && s[0] == s[3] && s[3] == s[6]) //Left Column
			return true;
		else if(s[8] != '9' && s[8] == s[7] && s[7] == s[6]) //Bottom Row
			return true;
		else if(s[8] != '9' && s[8] == s[5] && s[5] == s[2]) //Right Column
			return true;
		else if(s[0] != '1' && s[0] == s[4] && s[4] == s[8]) //Diagonal 1
			return true;
		else if(s[2] != '3' && s[2] == s[4] && s[4] == s[6]) //Diagonal 2
			return true;
		else if(s[1] != '2' && s[1] == s[4] && s[4] == s[7]) //Middle Column
			return true;
		else if(s[3] != '4' && s[3] == s[4] && s[4] == s[5]) //Middle Row
			return true;
		boolean done = true;
		for(int i = 0; i < 9; i++)
		{
			if(s[i] != 'X' && s[i] != 'O')
				done = false;
		}
		return done;
	}
	
	public int whoWon() //Returns 1 if O wins, -1 if X wins, and 0 if tie or game not over.
	{
		if(s[0] == 'X' && s[0] == s[1] && s[1] == s[2]) //Top Row
			return -1;
		else if(s[0] == 'X' && s[0] == s[3] && s[3] == s[6]) //Left Column
			return -1;
		else if(s[8] == 'X' && s[8] == s[7] && s[7] == s[6]) //Bottom Row
			return -1;
		else if(s[8] == 'X' && s[8] == s[5] && s[5] == s[2]) //Right Column
			return -1;
		else if(s[0] == 'X' && s[0] == s[4] && s[4] == s[8]) //Diagonal 1
			return -1;
		else if(s[2] == 'X' && s[2] == s[4] && s[4] == s[6]) //Diagonal 2
			return -1;
		else if(s[1] == 'X' && s[1] == s[4] && s[4] == s[7]) //Middle Column
			return -1;
		else if(s[3] == 'X' && s[3] == s[4] && s[4] == s[5]) //Middle Row
			return -1;
		else if(s[0] == 'O' && s[0] == s[1] && s[1] == s[2]) //Top Row
			return 1;
		else if(s[0] == 'O' && s[0] == s[3] && s[3] == s[6]) //Left Column
			return 1;
		else if(s[8] == 'O' && s[8] == s[7] && s[7] == s[6]) //Bottom Row
			return 1;
		else if(s[8] == 'O' && s[8] == s[5] && s[5] == s[2]) //Right Column
			return 1;
		else if(s[0] == 'O' && s[0] == s[4] && s[4] == s[8]) //Diagonal 1
			return 1;
		else if(s[2] == 'O' && s[2] == s[4] && s[4] == s[6]) //Diagonal 2
			return 1;
		else if(s[1] == 'O' && s[1] == s[4] && s[4] == s[7]) //Middle Column
			return 1;
		else if(s[3] == 'O' && s[3] == s[4] && s[4] == s[5]) //Middle Row
			return 1;
		else
			return 0;
	}
	
	@Override
	public String toString()
	{
		String out;
		out = "  " + s[0] + " | " + s[1] + " | " + s[2] + "\n";
		out += " ---+---+---\n";
		out += "  " + s[3] + " | " + s[4] + " | " + s[5] + "\n";
		out += " ---+---+---\n";
		out += "  " + s[6] + " | " + s[7] + " | " + s[8]+ "\n";
		
		return out;
	}
	
	public HashSet<GameState> getChildren(boolean Xturn)
	{
		HashSet<GameState> children = new HashSet<GameState>();
		if(!Xturn)
		{
			for(int i = 0; i < 9; i++)
			{
				if(s[i] != 'X' && s[i] != 'O')
				{
					GameState newChild = new GameState();
					for(int j = 0; j < 9; j++)
						newChild.s[j] = this.s[j];
					newChild.s[i] = 'O';
					children.add(newChild);
				}
			}
			return children;
		}
		else
		{
			for(int i = 0; i < 9; i++)
			{
				if(s[i] != 'X' && s[i] != 'O')
				{
					GameState newChild = new GameState();
					for(int j = 0; j < 9; j++)
						newChild.s[j] = this.s[j];
					newChild.s[i] = 'X';
					children.add(newChild);
				}
			}
			return children;
		}
	}
}
