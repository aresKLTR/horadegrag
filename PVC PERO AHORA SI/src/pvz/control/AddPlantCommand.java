package pvz.control;

import pvz.logic.GameModel;
import pvz.view.GameView;
import pvz.logic.GameWorld;
import pvz.view.Messages;
import pvz.utils.Position;
import pvz.logic.PlantFactory;
import pvz.logic.gameobjects.Plant;

public class AddPlantCommand extends Command{

	private Position position;
	
	private String plantName;

	public AddPlantCommand() {
		this.name = Messages.COMMAND_ADD_PLANT_NAME;
		this.shortcut = Messages.COMMAND_ADD_PLANT_SHORTCUT;
		this.details = Messages.COMMAND_ADD_PLANT_DETAILS;
		this.help =  Messages.COMMAND_ADD_PLANT_HELP;
	}
	
	 @Override
	  public void execute(GameModel model, GameView view) {
	  Plant plant= PlantFactory.spawnPlant(plantName, (GameWorld)model, position);
	  if(plant==null) {
		  view.showError(Messages.INVALID_GAME_OBJECT);
	  }
	  else if(!model.canPlace(position)) { 
		  view.showError(Messages.INVALID_POSITION);
	  }
	  else if(!model.enoughCoins(plant)) {
		  view.showError(Messages.NOT_ENOUGH_COINS);
	  }
	  else{
		  model.addPlant(plant);
		  model.update();
		  view.showGame();
		  }
	  }
	  
	  
	 public Command create(String[] words) {
		    if (words == null || words.length != 4) {
		        return null;
		    }

		    if (!matchCommand(words[0])) {
		        return null;
		    }

		    else {
		    	String colWord=words[2];
		    	String rowWord=words[3];
		    	char r=rowWord.charAt(0);
			    char c=colWord.charAt(0);
			    if(colWord.length() > 1 || rowWord.length() > 1||c<'0'||c>'9'||r<'0'||r>'9') {
			    	return null;
			    }
			    int numCol = c - '0';
			    int numRow = r - '0';
			        
			    this.plantName = words[1];
		        this.position = new Position(numRow, numCol);
		        }
			    return this;
	 }

	 @Override
	  public boolean matchCommand(String string) {
		  name=name.toLowerCase();
		  return string.equals(name)||string.equals(shortcut);
	  }
}
