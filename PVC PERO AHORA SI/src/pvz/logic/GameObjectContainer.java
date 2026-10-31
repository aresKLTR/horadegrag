package pvz.logic;

import java.util.ArrayList;
import java.util.List;
import pvz.logic.gameobjects.GameObject;
import pvz.utils.Position;

public class GameObjectContainer {
	  private List<GameObject> gameObjects;

	  public GameObjectContainer() {
	    gameObjects = new ArrayList<>();
	  }
	  
		public String iconInPosition(Position position) {
		    String icon = "";
		    for (GameObject obj: this.gameObjects) {
		        if (obj.isInPosition(position)) {
		            icon = obj.getIcon();
		        }
		    }
		    return icon;
		}
		
		public void add(GameObject gameobject) {
		   gameObjects.add(gameobject);
		}
		
		public boolean isEmpty(Position position) { 
			    for (GameObject obj : this.gameObjects) {
			        if (obj.isInPosition(position)) {
			            return false;
			        }
			    }
			    return true;
		}
		
		
		public void receiveZombieDamage(Position position, int damage) {
			for (GameObject obj : this.gameObjects) {
		        if (obj.isInPosition(position)) {
		            obj.receiveZombieAttack(damage);
		        }
		    }
		}
		
		public void receivePlantDamage(Position position, int damage) {
			for (GameObject obj : this.gameObjects) {
		        if (obj.isInPosition(position)) {
		            obj.receivePlantAttack(damage);
		        }
		    }
		}
		
		
		
		public void update() {
			 List<GameObject> array = new ArrayList<>(this.gameObjects);
		    for (GameObject obj: array) {
		        obj.update();
		    }
		}
		
		public int removeDead() {
		    int removed = 0;
		    for (int i = gameObjects.size() - 1; i >= 0; i--) {
		        if (!gameObjects.get(i).isAlive()) {
		            gameObjects.get(i).onExit();   
		            gameObjects.remove(i);
		            removed++;
		        }
		    }
		    return removed;
		}
}