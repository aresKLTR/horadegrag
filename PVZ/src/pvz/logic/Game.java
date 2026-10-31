package pvz.logic;

import java.util.Objects;
import java.util.Random;

import pvz.control.Level;
import pvz.logic.gameobjects.Plant;
import pvz.logic.gameobjects.Zombie;
import pvz.utils.Position;

public class Game implements GameModel, GameStatus, GameWorld {

	public static final int INITIAL_COINS = 50;

	private long seed;
	private Random random;
	
	private GameObjectContainer container;

	private ZombiesManager manager;
	private Level level;
	private int cycle;
	private int coins;
	private boolean playerQuits;
	private boolean isFinished;

	public boolean canPlace(Position pos) {
	    return isEmpty(pos) && isInsideBoard(pos);
	}
	
	public boolean enoughCoins(Plant plant) {
		return coins >= plant.getCost();
	}

	private void initializeGame() {
	    this.coins = INITIAL_COINS;
	    this.cycle = 0;
	    this.isFinished = false;
	    this.playerQuits = false;
	    this.random = new Random(this.seed);

	    // Inicializamos el único contenedor de la partida
	    this.container = new GameObjectContainer();
	    
	    // Inicializamos el manager pasándole 'this' como GameWorld
	    this.manager = new ZombiesManager(this, this.level, this.random);
	}

	public int getCycles() { return cycle; }

	public void addCoins(int amount) { coins += amount; }

	public int getCoins() { return coins; }

	public int getRemainingZombies() { return manager.getRemainingZombies(); }

	public Game(long seed, Level level) {
	    this.seed = seed;
	    this.level = level;
	    initializeGame();
	}

	public String positionToString(Position position) {
	    if (position == null) return "";
	    // Al haber un solo contenedor, consultamos directamente el icono en esa posición
	    return container.iconInPosition(position);   
	}

	public boolean playerwins() {
		return this.manager.allZombiesWereKilled();
	}

	public boolean zombiesWin() {
	    return this.manager.doZombiesReachedTheHouse();
	}

	public boolean playerQuits() { return this.playerQuits; }

	public boolean hasGameFinished() { return this.isFinished; }

	public void quit() {
		this.isFinished = true;
		this.playerQuits = true;
	}

	public void reset() {
		initializeGame();
	}

	public void update() {
	    // 1. Intentar generar un zombi a través del manager en una fila aleatoria
	    int row = random.nextInt(NUM_ROWS);
	    Zombie newZombie = manager.spawnZombie(row);
	    if (newZombie != null) {
	        container.add(newZombie); // Se añade al contenedor unificado
	        newZombie.onEnter();
	    }

	    // 2. Actualizar todos los objetos del juego (plantas y zombis juntos)
	    container.update();
	    
	    // 3. Eliminar objetos muertos del contenedor unificado
	    // Nota: si container.removeDead() devuelve cuántos objetos murieron, 
	    // puedes gestionar aquí la bajada de zombis vivos si es necesario.
	    int removed = container.removeDead();
	    // Si sabes que ha muerto un zombi, puedes llamar a manager.onZombieKilled() 
	    // (dependiendo de cómo gestione tu container la eliminación de zombis).

	    cycle++;
	    
	    if (playerwins() || this.manager.doZombiesReachedTheHouse()) {
	        isFinished = true;
	    }
	}

	public boolean isEmpty(Position position) {
		if (position == null) {
			return true;
		}
		return this.container.isEmpty(position);
	}

	public boolean isInsideBoard(Position position) {
	    return position != null && position.isInsideBoard(NUM_ROWS, NUM_COLS);
	}

	public boolean attackZombie(Position pos, int damage) { 
		if (!container.isEmpty(pos)) {
            container.receivePlantDamage(pos, damage);
            return true;
        }
        return false;
	}
	
	public boolean attackNearestZombie(Position shooterPos, int damage) {
	    int col = shooterPos.col() + 1;
	    boolean hit = false;
	    int row = shooterPos.row();
	    while (!hit && col < Game.NUM_COLS) {
	        Position pos = new Position(row, col);
	        if (!container.isEmpty(pos)&& container.receivePlantDamage(pos, damage)) { 
	            hit = true;                                
	        }
	        col++;
	    }
	    return hit;
	}

	public void attackPlant(Position pos, int damage) {
	    container.receiveZombieDamage(pos, damage);
	}

	public boolean addPlant(Plant plant) {
		if (canPlace(plant.getPosition()) && enoughCoins(plant)) {
	        coins -= plant.getCost();
	        container.add(plant);
	        plant.onEnter();
	        return true;
		}
	    return false;
	}
	
    @Override
   public int hashCode() {
	return Objects.hash(Integer.valueOf(coins), Integer.valueOf(cycle), level, Integer.valueOf(getRemainingZombies()),
			Long.valueOf(seed));
   }

   @Override
   public boolean equals(Object obj) {
	if (this == obj) return true;
	if ((obj == null) || (getClass() != obj.getClass())) return false;
	Game other = (Game) obj;
	return coins == other.coins && cycle == other.cycle && level == other.level
			&& getRemainingZombies() == other.getRemainingZombies() && seed == other.seed;
   }

   @Override
   public boolean canAttack(Position pos, int damage) {
       if (pos != null && !container.isEmpty(pos)) {
           attackPlant(pos, damage);
           return true;
       }
       return false;
   }

   @Override
   public boolean checkGameObject(String string) {
	// TODO Auto-generated method stub
	return false;
   }
}