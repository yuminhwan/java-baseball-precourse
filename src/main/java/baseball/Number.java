package baseball;

import java.util.ArrayList;
import java.util.HashSet;

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

	public static Number generatePlayerNumbers(String inputNumbers) {
		validateNumbers(inputNumbers);
		ArrayList<Integer> playerNumbers = convertStringToList(inputNumbers);

		return new Number(playerNumbers);
	}

	private static ArrayList<Integer> convertStringToList(String inputNumbers) {
		ArrayList<Integer> playerNumbers = new ArrayList<>();
		String[] splitNumbers = inputNumbers.split("");
		for ( String number : splitNumbers ) {
			playerNumbers.add(Integer.parseInt(number));
		}
		return playerNumbers;
	}

	private static void validateNumbers(String inputNumbers) {
		HashSet<Character> duplicateNumber = new HashSet<>();

		if ( inputNumbers.length() != 3 ) {
			throw new IllegalArgumentException();
		}

		for( int i = 0; i<inputNumbers.length(); i++) {
			char number = inputNumbers.charAt(i);
			if ( number < '1' || number > '9'  ) {
				throw new IllegalArgumentException();
			}

			if ( !duplicateNumber.add(number) ) {
				throw new IllegalArgumentException();
			}
		}
	}

}
