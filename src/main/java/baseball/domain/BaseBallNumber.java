package baseball.domain;

import java.util.ArrayList;
import java.util.HashSet;

import static baseball.constant.ConstValue.*;

import camp.nextstep.edu.missionutils.Randoms;

public class BaseBallNumber {
	private final ArrayList<Integer> baseballNumber;

	public BaseBallNumber(ArrayList<Integer> baseballNumber) {
		this.baseballNumber = baseballNumber;
	}

	public static BaseBallNumber generateComputerNumber() {
		ArrayList<Integer> answerNumber = new ArrayList<>();

		while ( answerNumber.size() < NUMBER_LENGTH ) {
			int randomNumber = Randoms.pickNumberInRange(MIN_NUMBER, MAX_NUMBER);
			if ( !answerNumber.contains(randomNumber) ) {
				answerNumber.add(randomNumber);
			}
		}
		return new BaseBallNumber(answerNumber);
	}

	public static BaseBallNumber generatePlayerNumber( String inputNumber ) {
		validateNumber(inputNumber);
		ArrayList<Integer> playerNumber = convertStringToInt(inputNumber);
		return new BaseBallNumber( playerNumber );
	}

	public int getNthNumber(int idx) {
		return baseballNumber.get(idx);
	}

	public boolean containsNumber(int number) {
		return baseballNumber.contains(number);
	}

	public boolean hasNumber( int number, int idx ) {
		return baseballNumber.get(idx) == number;
	}

	private static ArrayList<Integer> convertStringToInt( String inputNumber ) {
		ArrayList<Integer> playerNumber = new ArrayList<>();
		String[] splitNumber = inputNumber.split("");
		for ( String number : splitNumber ) {
			playerNumber.add(Integer.parseInt(number));
		}
		return playerNumber;
	}

	private static void validateNumber( String inputNumber ) {
		HashSet<Character> duplicateNumber = new HashSet<>();

		if ( inputNumber.length() != NUMBER_LENGTH ) {
			throw new IllegalArgumentException();
		}

		for( int idx = 0; idx<NUMBER_LENGTH; idx++) {
			char number = inputNumber.charAt(idx);
			if ( number < (char) ( MIN_NUMBER + '0' ) || number > ( MAX_NUMBER + '0' ) ) {
				throw new IllegalArgumentException();
			}

			if ( !duplicateNumber.add(number) ) {
				throw new IllegalArgumentException();
			}
		}
	}
}
