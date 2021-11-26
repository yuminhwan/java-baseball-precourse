package baseball;

import camp.nextstep.edu.missionutils.Console;

public class Player {

	private Number numbers;

	public void inputNumbers() {
		String inputNumbers = Console.readLine();
		numbers = Number.generatePlayerNumbers(inputNumbers);
	}

	public int inputCommand() {
		String inputNumber = Console.readLine();
		Number.validateCommand(inputNumber);
		return Integer.parseInt(inputNumber);
	}

	public Number getNumbers() {
		return numbers;
	}
}
