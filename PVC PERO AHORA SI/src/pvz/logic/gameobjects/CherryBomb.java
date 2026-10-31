package pvz.logic.gameobjects;

import pvz.logic.GameWorld;
import pvz.utils.Position;
import pvz.view.Messages;

public class CherryBomb extends Plant {
	private final static int COST=50;
	public CherryBomb(Position position, GameWorld game) {
		super(position, game,2,COST);
	}

	@Override
	public boolean receivePlantAttack(int damage) {
		return false;
	}

    public String getDescription() {return String.format(Messages.CHERRY_BOMB_NAME,COST, 0,this.getHealth());}
	
	public String getIcon() {return String.format(Messages.CHERRY_BOMB_ICON,this.getHealth());}

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

	}

}
