package pvz.logic;

import pvz.utils.Position;

public interface GameStatus {
	int getCycles();

	String positionToString(Position position);

	public int getCoins();
	
	public int getRemainingZombies();
	
    boolean playerwins();
	   
    boolean zombiesWin();
    
    boolean playerQuits();
}
