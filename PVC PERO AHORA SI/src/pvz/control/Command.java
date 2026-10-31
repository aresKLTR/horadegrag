package pvz.control;
import java.util.List;
import java.util.Arrays;
import pvz.logic.GameModel;
import pvz.view.GameView;


public abstract class Command {
	
  private static final List<Command> AVAILABLE_COMMANDS = Arrays.asList(
      new AddPlantCommand(),
      new ListPlantsCommand(),
      new ResetCommand(),
      new HelpCommand(),
      new ExitCommand(),
      new NoneCommand()
  );
  
  protected String name = "";
  protected String shortcut = "";
  protected String details = "";
  protected String help = "";
  
  public static List<Command> getAvailableCommands() {
	    return AVAILABLE_COMMANDS;
	}
  
  public abstract boolean matchCommand(String string);
  
  public abstract Command create(String[] commandWords);
  
  public abstract void execute(GameModel model, GameView view);
  
  public static Command parse(String[] commandWords) {
	   if (commandWords == null || commandWords.length == 0) {
	        return null;
	    }
	   
	    for (Command command : AVAILABLE_COMMANDS) {
	        if (command.matchCommand(commandWords[0])) {
	            return command.create(commandWords);
	        }
	    }

	    return null;
	}
}
