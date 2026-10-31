package pvz.logic;

import java.util.Random;
import pvz.logic.gameobjects.Sun;
import pvz.utils.Position;

public class SunsManager {
	
	private Random rand;
	
	private int cyclesCounter;
	
	private GameWorld world;

	public SunsManager(GameWorld world, Random rand) {
		this.world = world;
		this.rand = rand;
		this.cyclesCounter = 0;
	}
	
	private boolean shouldAddSun() {
		this.cyclesCounter++;
		if(this.cyclesCounter>=5) {
			this.cyclesCounter=0;
			return true;
		}
		return false;
	}
	
	private int randomSunRow() {
		return rand.nextInt(Game.NUM_ROWS);
	}
	
	private int randomSunCol() {
		return rand.nextInt(Game.NUM_COLS);
	}
	
	public Sun addSun() {
		if(shouldAddSun()) {
		int row = randomSunRow();
		int col=randomSunCol();
		return spawnSun(row,col);
		}
		return null;
	}
	

	public Sun spawnSun(int row,int col) {
	     return new Sun(world, new Position(row,col), this);
	}
}
