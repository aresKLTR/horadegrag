package pvz.logic;
import pvz.logic.gameobjects.Plant;
import pvz.utils.Position;

public interface GameModel {
	
	  void reset();
	  
	  void update();
	  
	  void quit();
	  
	  boolean addPlant(Plant plant);
	  
	  public boolean checkGameObject(String string);
	  
	  public boolean enoughCoins(Plant plant);
	  
	  public boolean canPlace(Position pos);
	  
	}