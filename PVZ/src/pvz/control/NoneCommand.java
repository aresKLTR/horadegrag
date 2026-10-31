package pvz.control;

import pvz.logic.GameModel;
import pvz.view.GameView;

public class NoneCommand extends Command {

    public NoneCommand() {
        this.name = "";
    }

    @Override
    public boolean matchCommand(String string) {
        return string != null && string.isEmpty();
    }

    @Override
    public Command create(String[] commandWords) {
        if (commandWords != null && commandWords.length > 0
                && matchCommand(commandWords[0])) {
            return this;
        }
        return null;
    }

	@Override
	public void execute(GameModel model, GameView view) {
		model.update();
		view.showGame();
	}
}