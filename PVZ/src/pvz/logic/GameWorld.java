package pvz.logic;

import pvz.utils.Position;
public interface GameWorld {

	  public static final int NUM_ROWS = 4;
	  
	  public static final int NUM_COLS = 8;

	  boolean isEmpty(Position position);
	  
	  boolean isInsideBoard(Position position);
	  
	  boolean attackZombie(Position pos, int damage);
	  
      boolean attackNearestZombie(Position shooterPos, int damage); 
      
	  void attackPlant(Position pos, int damage); 
	  
	  void addCoins(int amount);

	  boolean canAttack(Position nextPos, int damage);
	  
	}