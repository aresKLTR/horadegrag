package pvz.logic.gameobjects;

import pvz.logic.GameWorld;
import pvz.utils.Position;
import pvz.view.Messages;

public class WallNut extends Plant {
	public static final int COST = 50;

	public WallNut(Position position, GameWorld game) {
		super(position, game, 10, COST);
		
	}

	@Override
	public boolean receivePlantAttack(int damage) {
		return false;
	}


	public String getDescription() {return String.format(Messages.WALL_NUT_NAME,COST, 0,this.getHealth());}
	
	public String getIcon() {return String.format(Messages.WALL_NUT_ICON,this.getHealth());}

	@Override
	public void onEnter() {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void onExit() {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void update() {
		// TODO Auto-generated method stub
		
	}

}
