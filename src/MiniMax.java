/*
 * function minimax(node, depth, maximizingPlayer)
02     if depth = 0 or node is a terminal node
03         return the heuristic value of node

04     if maximizingPlayer
05         bestValue := −∞
06         for each child of node
07             v := minimax(child, depth − 1, FALSE)
08             bestValue := max(bestValue, v)
09         return bestValue

10     else    (* minimizing player *)
11         bestValue := +∞
12         for each child of node
13             v := minimax(child, depth − 1, TRUE)
14             bestValue := min(bestValue, v)
15         return bestValue
 */

public class MiniMax {
	
	GameState bestMove = new GameState();

	public int minimax(GameState node, int depth, boolean maxPlayer)
	{
		int bestValue;
		GameState bestChoice = new GameState();
		if (depth == 0 || node.end())
		{
			//System.out.println(node.toString());
			//System.out.println(node.whoWon());
			return node.whoWon();
		}
		
		if (maxPlayer) //Maximizing PLayer
		{
			bestValue = Integer.MIN_VALUE;
			for(GameState child : node.getChildren(false))
			{
				//System.out.println(node.toString());
				//System.out.println(child.toString());
				int value = minimax(child, depth - 1, false);
				bestValue = Math.max(bestValue, value);
			}
			return bestValue;
		}
		else //Minimizing Player
		{
			bestValue = Integer.MAX_VALUE;
			for(GameState child : node.getChildren(true))
			{
				//System.out.println("Minimize:\n" + child.toString());
				int value = minimax(child, depth - 1, true);
				bestValue = Math.min(bestValue, value);
			}
			return bestValue;
		}
	}
	
}
