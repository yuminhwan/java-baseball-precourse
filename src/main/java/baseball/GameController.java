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
		computer.generate();
		do {
			System.out.print("숫자를 입력해주세요 : ");
			player.inputNumbers();
			computer.calculateResultCount(player.getNumbers());
			System.out.println(computer.printResult());
		} while ( !computer.isCorrect() );
	}

	private boolean finishGame() {
		return true;
	}
}