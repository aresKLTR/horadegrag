package pvz.logic.gameobjects;

import pvz.logic.GameWorld;
import pvz.utils.Position;

public abstract class Plant extends GameObject {
	
	protected int health;
	
	protected int cost;

	public Plant(Position position, GameWorld game, int health, int cost) {
		super(game, position);
		this.health = health;
		this.cost = cost;
	}
	
	public boolean isAlive() {
		return health>0;
	}
	
	@Override
    public boolean receiveZombieAttack(int damage) {
        if (isAlive()) {
            this.health -= damage;
            return true;
        }
		return false;
    }
	
	public int getCost() {
        return this.cost; // Este getter sí es necesario porque lo usará la factoría
    }
	
	public int getHealth() {
        return this.health; // Este getter sí es necesario porque lo usará la factoría
    }
}
