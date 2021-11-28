package baseball;

import static baseball.constant.ConstValue.*;

import baseball.domain.Computer;
import baseball.domain.Player;
import baseball.domain.Referee;

import camp.nextstep.edu.missionutils.Console;

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
			readyForGame();
			startGame();
		} while (restartGame());
	}

	private void readyForGame() {
		computer.generateComputerNumber();
		referee.saveComputerNumber(computer.getComputerNumber());
	}

	private void startGame() {
		do {
			inputPlayerNumber();
			referee.judgeResult( player.getPlayerNumber() );
			referee.printResult();
		} while ( !referee.isAnswer() );
	}

	private void inputPlayerNumber() {
		System.out.print( REQUEST_INPUT_NUMBER );
		player.inputNumber();
	}

	private boolean restartGame() {
		String inputCommand = inputCommandNumber();
		validateCommand(inputCommand);
		return inputCommand.equals( RESTART );
	}

	private String inputCommandNumber() {
		System.out.println(CORRECT_AND_GAME_OVER);
		System.out.println(REQUEST_RESTART_OR_END);
		return Console.readLine();
	}

	private void validateCommand( String command ) {
		if ( !command.equals( RESTART ) && !command.equals( END_GAME ) ) {
			throw new IllegalArgumentException();
		}
	}
}