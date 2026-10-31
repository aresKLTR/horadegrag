package pvz.logic.gameobjects;

import pvz.logic.GameWorld;
import pvz.utils.Position;

public abstract class GameObject implements GameItem {

	  protected GameWorld game;
	  protected Position position;

	  public GameObject(GameWorld game, Position p) {
	    this.game = game;
	    this.position = p;
	  }
	  public boolean isInPosition(Position other) {
	    return this.position.equals(other);
	  }
//se puede quedar si fuese necesario y justificable
	  public Position getPosition() {
		return position;  
	  }

	  abstract public String getIcon();

	  abstract public String getDescription();

	  abstract public boolean isAlive();

	  abstract public void onEnter();
	  //el onExit serviria para saber si el jugador ha salido del juego, ha muerto o ha ganado...
	  abstract public void onExit();
	  
	  public abstract void update();
	  
	  public boolean isEnemy() {
		    return false;
		}
	
	}