package baseball;

public class GameController {
	private final Player player;
	private final Computer computer;
	private final Referee referee;

	public GameController() {
		player = new Player();
		computer = new Computer();
		referee = new Referee();
	}

	public void run() {
		do {
			startGame();
		} while (!finishGame());
	}

	private void startGame() {
		computer.generate();
		referee.readyForGame(computer.getComputerNumber());
		do {
			System.out.print("숫자를 입력해주세요 : ");
			player.inputNumber();
			referee.judgeResult(player.getPlayerNumber());
			System.out.println(referee.getResult());
		} while ( !referee.isAnswer() );
	}

	private boolean finishGame() {
		System.out.println("3개의 숫자를 모두 맞히셨습니다! 게임 종료");
		System.out.println("게임을 새로 시작하려면 1, 종료하려면 2를 입력하세요.");
		return player.inputCommand() == 2;
	}
}