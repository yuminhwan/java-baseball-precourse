package baseball;

public class GameController {
	private final Player player;
	private final Computer computer;

	public GameController() {
		player = new Player();
		computer = new Computer();
	}

	public void run() {
		do {
			startGame();
		} while (!finishGame());
	}

	private void startGame() {

	}

	private boolean finishGame() {
		return true;
	}
}