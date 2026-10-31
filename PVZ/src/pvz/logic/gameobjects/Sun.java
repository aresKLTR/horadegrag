package pvz.logic.gameobjects;

import pvz.logic.GameWorld;
import pvz.logic.SunsManager;
import pvz.utils.Position;
import pvz.view.Messages;

public class Sun extends GameObject {
private int cyclesLeft;
private GameWorld world;

	public Sun(GameWorld game, Position p,SunsManager sunsManager) {
		super(game, p);
		this.cyclesLeft=11;
	}


	@Override
	public boolean receiveZombieAttack(int damage) {
		return false;
	}

	@Override
	public boolean receivePlantAttack(int damage) {
		return false;
	}

	@Override
	public String getIcon() {
		return String.format(Messages.SUN_SYMBOL, cyclesLeft);
	}

	@Override
	public String getDescription() {
		return String.format(Messages.SUN_DESCRIPTION);
	}

	@Override
	public boolean isAlive() {
		// TODO Auto-generated method stub
		return false;
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
	public void update() {
		if(cyclesLeft>0) {
	    cyclesLeft--;
		}
		else {
			//no lo he completado del todo, pero habria que añadir 10 monedas si las coge el jugador mientras todavia hayan ciclos
			this.world.addCoins(10);
		}
	}

}
