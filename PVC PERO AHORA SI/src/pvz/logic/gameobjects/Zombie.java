package pvz.logic.gameobjects;

import pvz.utils.Position;
import pvz.logic.GameWorld;
import pvz.logic.ZombiesManager;
import pvz.view.Messages;

public class Zombie extends GameObject {
	private int damage=1;
	
	private int health;
	
	private int counter;
	
	private GameWorld world;

	private ZombiesManager manager;

	public String getIcon() {return String.format(Messages.ZOMBIE_ICON, this.health);}
	
	public Zombie(Position pos, GameWorld world, ZombiesManager manager) {
		super(world,pos);
		this.world=world;
		this.manager=manager;
		this.health=5;
		this.counter=0;
	}
	
	public boolean isAlive() {return health>0;}

	public boolean isInPosition(Position pos) { //cambiamos con el equals
	    if(pos==null) {return false;}
	     return this.position.equals(pos);
	}

	public boolean isInColumn(int col) {
	    return position.col() == col;
	}
	
	public void receiveAttack(int i) {
		this.health-=i;	
	}

	public void update() {
	    if (isAlive()) {
	        Position nextPos = new Position(
	            position.row(),
	            position.col() - 1
	        );
	        if (world.canAttack(nextPos, damage)) {
	            counter = 1;
	        } else {
	            counter++;
	            if (counter >= 3&&world.isEmpty(nextPos)) {
	                position = nextPos;
	                counter = 1;
	            }
	            else {
	           position= new Position(position.row(),position.col());
	            }
	        }
	    }
	}

	@Override
	public boolean receiveZombieAttack(int damage) {
		return false;
	}

	@Override
	public boolean receivePlantAttack(int damage) {
		if (isAlive()) {
	        health -= damage;
	        return true;
	    }
	    return false;
	}

	public String getDescription() {
		return null;	}

	@Override
	public void onEnter() {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void onExit() {
		manager.onZombieKilled();
	}
}