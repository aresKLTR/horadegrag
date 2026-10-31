package pvz.control;

import pvz.logic.GameModel;
import pvz.view.GameView;
import pvz.view.Messages;
import pvz.logic.SunsManager;
import pvz.utils.Position;

public class CatchCommand extends Command {
	
	private Position position;
	
	 public CatchCommand() {
			this.name = Messages.COMMAND_CATCH_NAME;
			this.shortcut = Messages.COMMAND_CATCH_SHORTCUT;
			this.details = Messages.COMMAND_CATCH_DETAILS;
			this.help =  Messages.COMMAND_CATCH_HELP;
		  }
	@Override
	public boolean matchCommand(String string) {
		  name=name.toLowerCase();
		  return string.equals(name)||string.equals(shortcut);
	}

	@Override
	public Command create(String[] words) {
		 if (words == null || words.length != 3) {
		        return null;
		    }

		    if (!matchCommand(words[0])) {
		        return null;
		    }

		    else {
		    	String colWord=words[1];
		    	String rowWord=words[2];
		    	char r=rowWord.charAt(0);
			    char c=colWord.charAt(0);
			    if(colWord.length() > 1 || rowWord.length() > 1||c<'0'||c>'9'||r<'0'||r>'9') {
			    	return null;
			    }
			    int numCol = c - '0';
			    int numRow = r - '0';
		        this.position = new Position(numRow, numCol);
		        
		        }
			return this;
	}

	@Override
	public void execute(GameModel model, GameView view) {
		
	}

}
