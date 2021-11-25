package baseball;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Set;

import camp.nextstep.edu.missionutils.Console;

public class Player {

	private Number numbers;

	public void inputNumbers() {
		String inputNumbers = Console.readLine();
		numbers = Number.generatePlayerNumbers(inputNumbers);
	}

	public Number getNumbers() {
		return numbers;
	}

}
