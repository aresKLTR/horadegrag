package pvz.control;

import pvz.logic.GameModel;
import pvz.view.GameView;
import pvz.view.Messages;

public class ResetCommand extends Command{
	public ResetCommand() {
		this.name = Messages.COMMAND_RESET_NAME;
		this.shortcut = Messages.COMMAND_RESET_SHORTCUT;
		this.details = Messages.COMMAND_RESET_DETAILS;
		this.help =  Messages.COMMAND_RESET_HELP;
    }
	  @Override
	 public void execute(GameModel model, GameView view) {
		 model.reset();
		 view.showGame();
	 }
	  @Override
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
}
