package pvz.control;

import pvz.logic.GameModel;
import pvz.view.GameView;
import pvz.view.Messages;

public class ExitCommand extends Command{
	public ExitCommand() {
		this.name = Messages.COMMAND_EXIT_NAME;
		this.shortcut = Messages.COMMAND_EXIT_SHORTCUT;
		this.details = Messages.COMMAND_EXIT_DETAILS;
		this.help =  Messages.COMMAND_EXIT_HELP;
    }
	 @Override
	  public void execute(GameModel model, GameView view) {
		 view.showMessage(Messages.PLAYER_QUITS);
		 model.quit();
	  } 
	 @Override
	  public boolean matchCommand(String string) {
		  name=name.toLowerCase();
		  return string.equals(name)||string.equals(shortcut);
	  }
	 @Override
	  public Command create(String[] words) {
		  if(words!=null&&words.length>0&&matchCommand(words[0])) {
			  return this;
		  }
		return null; 
	  }
}