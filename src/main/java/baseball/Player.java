package baseball;

import camp.nextstep.edu.missionutils.Console;

public class Player {

	private BaseBallNumber playerNumber;

	public void inputNumber() {
		String inputNumber = Console.readLine();
		playerNumber = BaseBallNumber.generatePlayerNumber(inputNumber);
	}

	public int inputCommand() {
		String inputNumber = Console.readLine();
		BaseBallNumber.validateCommand(inputNumber);
		return Integer.parseInt(inputNumber);
	}

	public BaseBallNumber getPlayerNumber() {
		return playerNumber;
	}
}
