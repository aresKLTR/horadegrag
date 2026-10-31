package pvz.logic.gameobjects;

import pvz.logic.GameWorld;
import pvz.utils.Position;
import pvz.view.Messages;

public class Sunflower extends Plant{
	
	private int counter;
	
	public static final int COST = 20;
	
	public String getDescription() {return String.format(Messages.SUNFLOWER_DESCRIPTION,COST, 0,this.getHealth());}
	
	public String getIcon() {return String.format(Messages.SUNFLOWER_ICON,this.getHealth());}

	public Sunflower(Position position, GameWorld game) {
		super(position,game,1,COST);
		this.counter=0;
	}
	
	@Override
		public void update() {
			if(isAlive()) {
	            counter++;
				if(counter==4) { 
	              game.addCoins(10);
	              counter=1;
				}
			}
		}

		@Override
		public void onEnter() {
			// TODO Auto-generated method stub
			
		}

		@Override
		public void onExit() {
			// TODO Auto-generated method stub
			
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