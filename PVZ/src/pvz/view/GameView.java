package pvz.view;
//import pvz.logic.Game;

public interface GameView {
  // show methods
  void showGame();
  void showEndMessage();
  void showError(String message);
  void showMessage(String message);

  // get data from view
  String[] getPrompt();
  /**
   * Prints complete representation (status+board) of the game.
   */

  /**
   * Prints the message to be printed once the game has finished.
   */
}
