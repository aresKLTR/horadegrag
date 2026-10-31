package pvz.logic.gameobjects;


import pvz.logic.GameWorld;
import pvz.utils.Position;
import pvz.view.Messages;

public class Peashooter extends Plant{
    
    private int damage=1;
    
    public static final int COST = 50;
       
    public String getDescription() {return String.format(Messages.PEASHOOTER_DESCRIPTION, COST, damage, this.getHealth());}
      
    public String getIcon() {	return String.format(Messages.PEASHOOTER_ICON,this.getHealth());}

	public Peashooter(Position position, GameWorld game) {
		super(position,game,3,COST);
	}

	 public void update() {
	    if (isAlive()) {
	        game.attackNearestZombie(position, damage);
	    }
	}

	@Override
	public void onEnter() {
		
	}

	@Override
	public void onExit() {
		
	}

	@Override
	public boolean receivePlantAttack(int damage) {
		return false;
	}
	
	@Override
	public boolean receiveZombieAttack(int damage) {
		if (isAlive()) {
	        health -= damage;
	        return true;
	    }
	    return false;
	}
}