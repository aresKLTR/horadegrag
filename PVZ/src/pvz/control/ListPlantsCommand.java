package pvz.control;

import java.util.List;

import pvz.logic.GameModel;
import pvz.logic.PlantFactory;
import pvz.logic.gameobjects.Plant;
import pvz.view.GameView;
import pvz.view.Messages;

public class ListPlantsCommand extends Command {
	public ListPlantsCommand() {
		this.name = Messages.COMMAND_LIST_PLANTS_NAME;
		this.shortcut = Messages.COMMAND_LIST_PLANTS_SHORTCUT;
		this.details = Messages.COMMAND_LIST_PLANTS_DETAILS;
		this.help =  Messages.COMMAND_LIST_PLANTS_HELP;
    }
	
	public Command create(String[] words) {
		  if(words!=null&&words.length>0&&matchCommand(words[0])) {
			  return this;
		  }
		return null; 
	  }

	@Override
	  public boolean matchCommand(String string) {
		  name=name.toLowerCase();
		  return string.equals(name)||string.equals(shortcut);
	  }

	@Override
	public void execute(GameModel model, GameView view) {
		//necesito Plant y plant factory para hacer esta funcion
		List<Plant> plantList= PlantFactory.getAvailablePlants();
		for(int i=0;i<plantList.size();i++) {
			Plant plant = plantList.get(i);
			view.showMessage(plant.getDescription()); 
		}
	}
}
