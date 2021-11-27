package baseball;

import camp.nextstep.edu.missionutils.Console;

public class GameController {
	private static final int RESTART = 1;
	private static final int END_GAME = 2;

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
			readyForGame();
			startGame();
		} while (finishGame());
	}

	private void startGame() {
		do {
			System.out.print("숫자를 입력해주세요 : ");
			player.inputNumber();
			referee.judgeResult( player.getPlayerNumber() );
			System.out.println( referee.getResult() );
		} while ( !referee.isAnswer() );
	}

	private void readyForGame() {
		computer.generateComputerNumber();
		referee.saveComputerNumber(computer.getComputerNumber());
	}

	private boolean finishGame() {
		System.out.println("3개의 숫자를 모두 맞히셨습니다! 게임 종료");
		System.out.println("게임을 새로 시작하려면 1, 종료하려면 2를 입력하세요.");
		String inputCommand = Console.readLine();
		validateCommand(inputCommand);
		return inputCommand.equals( String.valueOf(RESTART) );
	}

	private void validateCommand( String command ) {
		if ( !command.equals( String.valueOf(RESTART) ) && !command.equals( String.valueOf(END_GAME) ) ) {
			throw new IllegalArgumentException();
		}
	}
}