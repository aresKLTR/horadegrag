package pvz.logic;

import java.util.Random;

import pvz.control.Level;
import pvz.logic.gameobjects.Zombie;
import pvz.utils.Position;

public class ZombiesManager {

	private GameWorld world;

	private Level level;

	private Random rand;

	private int remainingZombies; 
	
	private int zombiesAlive=0;

	public ZombiesManager(GameWorld world, Level level, Random rand) {
		this.world = world;
		this.level = level;
		this.rand = rand;
		this.remainingZombies=level.getNumberOfZombies();
	}

	private boolean shouldAddZombie() {
		return rand.nextDouble() < level.getZombieFrequency();
	}
	
	private int randomZombieRow() {
		return rand.nextInt(Game.NUM_ROWS);
	}
	
	public Zombie addZombie() {
		int row = randomZombieRow();
		return spawnZombie(row);
	}
	
	public Zombie addZombie(int row) {
	    boolean canAdd = getRemainingZombies() > 0
	            && shouldAddZombie()
	            && world.isEmpty(new Position(row, Game.NUM_COLS));
	  
	    if (canAdd) {
	        this.remainingZombies--;
	        this.zombiesAlive++;
	        return new Zombie(new Position(row, Game.NUM_COLS), world, this);
	    }
	    return null; 
	}
	
	public Zombie spawnZombie(int row) {
	    boolean canAdd = getRemainingZombies() > 0
	            && shouldAddZombie()
	            && world.isEmpty(new Position(row, Game.NUM_COLS));
	    if (canAdd) {
	        this.remainingZombies--;
	        this.zombiesAlive++;
	        return new Zombie(new Position(row, Game.NUM_COLS), world, this);
	    }
	    return null;
	}
	
	public void onZombieKilled() {
		zombiesAlive--;
	}
	
	public int getRemainingZombies() {
		return remainingZombies;
	}

	public boolean doZombiesReachedTheHouse() {
		for (int row = 0; row < GameWorld.NUM_ROWS; row++) {
			if (!world.isEmpty(new Position(row, -1))) {
				return true;
			}
		}
		return false;
	}
	public boolean allZombiesWereKilled() {
		return this.getRemainingZombies()==0&&zombiesAlive==0;
	}
}
	