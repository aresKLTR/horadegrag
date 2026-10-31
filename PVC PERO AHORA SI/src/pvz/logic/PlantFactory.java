package pvz.logic;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;

import pvz.logic.gameobjects.Plant;
import pvz.logic.gameobjects.Sunflower;
import pvz.logic.gameobjects.WallNut;
import pvz.logic.gameobjects.Peashooter;
import pvz.utils.Position;

public class PlantFactory {
	  public PlantFactory() {
		
   	}
	  private static final List<Plant> AVAILABLE_PLANTS = Arrays.asList(
	      new Sunflower(null, null),
	      new Peashooter(null, null),
	      new WallNut(null,null)
	  );
	  
	  public static Plant spawnPlant(String plantName, GameWorld game, Position position) {
			if(plantName.equalsIgnoreCase("peashooter")||plantName.equalsIgnoreCase("p")) {
				return new Peashooter(position,game);
			}
			else if(plantName.equalsIgnoreCase("sunflower")||plantName.equalsIgnoreCase("s")) {
				return new Sunflower(position,game);
			}
			else if(plantName.equalsIgnoreCase("wallnut")||plantName.equalsIgnoreCase("wn")){
				return new WallNut(position,game);
			}
		//	else if(plantName.equalsIgnoreCase("cherry")||plantName.equalsIgnoreCase("c")){
				//return new CherryBomb(position,game); descomentar cuando esté
		//	}
		return null;
	  }

	  public static List<Plant> getAvailablePlants() {
	    return Collections.unmodifiableList(AVAILABLE_PLANTS);
	  }

	}