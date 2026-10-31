package pvz.control;

import java.util.Objects;

import pvz.logic.Game;
import pvz.view.GamePrinter;
import pvz.view.GameView;
import pvz.view.Messages;


/**
 * Input/output coordinator of the game (the C in MVC).
 *
 * <p>Owns the game loop: reads a line from stdin, parses it into a
 * command, validates parameters (plant type, position), delegates
 * state changes to {@link Game}, and triggers a board reprint via
 * {@link tp1.pvz.view.GameView>} when the cycle advances. It holds no game
 * state of its own; the source of truth is always {@link Game}.
 */
public class Controller {
	
	private Game game;
	
	private GameView view;

	public Controller(Game game) {
		this.game = game;
		this.view = new GamePrinter(game);
	}

	/**
	 * Runs the game logic.
	 */
	public void run() {
		view.showGame();
		while (!game.hasGameFinished()) {
			String[] words = prompt();
			Command command = Command.parse(words);
			if (command != null) {
				command.execute(game, view);
				} 
			else {
			       view.showError(Messages.UNKNOWN_COMMAND);
		   }
		}
		view.showEndMessage();
	}
	
	private String[] prompt() {
	return view.getPrompt();
	}

	@Override
	public int hashCode() {
		return Objects.hash(game, view);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Controller other = (Controller) obj;
		return Objects.equals(game, other.game) && Objects.equals(view, other.view);
	}

}