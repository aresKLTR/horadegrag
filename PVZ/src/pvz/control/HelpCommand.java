package pvz.control;

import java.util.List;

import pvz.logic.GameModel;
import pvz.view.GameView;
import pvz.view.Messages; 


public class HelpCommand extends Command {
	
	  public HelpCommand() {
		this.name = Messages.COMMAND_HELP_NAME;
		this.shortcut = Messages.COMMAND_HELP_SHORTCUT;
		this.details = Messages.COMMAND_HELP_DETAILS;
		this.help =  Messages.COMMAND_HELP_HELP;
	  }

	  @Override
	  public void execute(GameModel model, GameView view) {
		  /*no usamos model ya que este sirve para que se modifique el estado actual de la partida,
		  pero como en help solo muestra la lista de ayuda, pues no usamos el GameModel y 
		  estamos obligados a ponerlo como parametro por el simple hecho de que es la clase hija*/
		  view.showMessage(Messages.HELP_AVAILABLE_COMMANDS);
		  List<Command> commands = getAvailableCommands();
		  for(int i=0;i<commands.size();i++) {
			  if(commands.get(i)!=null) {
				  Command cmd= commands.get(i);
				  view.showMessage(cmd.help);
			  }
		  }
	  }
	  @Override
	  public Command create(String[] words) {
		  if(words.length>0&&matchCommand(words[0])) {
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