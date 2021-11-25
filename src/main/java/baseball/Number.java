package baseball;

import java.util.ArrayList;

import camp.nextstep.edu.missionutils.Randoms;

public class Number {

	private final ArrayList<Integer> numbers;

	public Number(ArrayList<Integer> numbers) {
		this.numbers = numbers;
	}

	public static Number generateRandomNumbers() {
		ArrayList<Integer> numbers = new ArrayList<>();

		while (numbers.size() < 3) {
			int randomNumber = Randoms.pickNumberInRange(1, 9);
			if (!numbers.contains(randomNumber)) {
				numbers.add(randomNumber);
			}
		}
		return new Number(numbers);
	}

}
