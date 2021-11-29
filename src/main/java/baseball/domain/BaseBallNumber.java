package baseball.domain;

import static baseball.message.SystemMessage.*;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

import camp.nextstep.edu.missionutils.Randoms;

public class BaseBallNumber {
	private static final int MIN_NUMBER = 1;
	private static final int MAX_NUMBER = 9;
	private static final int NUMBER_LENGTH = 3;

	private final List<Integer> baseballNumber;

	public BaseBallNumber(List<Integer> baseballNumber) {
		this.baseballNumber = baseballNumber;
	}

	public static BaseBallNumber generateComputerNumber() {
		List<Integer> answerNumber = new ArrayList<>();

		while (answerNumber.size() < NUMBER_LENGTH) {
			int randomNumber = Randoms.pickNumberInRange(MIN_NUMBER, MAX_NUMBER);
			if (!answerNumber.contains(randomNumber)) {
				answerNumber.add(randomNumber);
			}
		}
		return new BaseBallNumber(answerNumber);
	}

	public static BaseBallNumber generatePlayerNumber(String inputNumber) {
		validateNumber(inputNumber);
		List<Integer> playerNumber = convertStringToInt(inputNumber);
		return new BaseBallNumber(playerNumber);
	}

	private static List<Integer> convertStringToInt(String inputNumber) {
		String[] splitNumber = inputNumber.split("");

		return Arrays.stream(splitNumber)
			.map(Integer::parseInt)
			.collect(Collectors.toCollection(ArrayList::new));
	}

	private static void validateNumber(String inputNumber) {
		Set<Character> duplicateNumber = new HashSet<>();

		if (inputNumber.length() != NUMBER_LENGTH) {
			throw new IllegalArgumentException(INVALID_LENGTH);
		}

		for (int idx = 0; idx < NUMBER_LENGTH; idx++) {
			char number = inputNumber.charAt(idx);
			if (number < Character.forDigit(MIN_NUMBER, 10) || number > Character.forDigit(MAX_NUMBER, 10)) {
				throw new IllegalArgumentException(INVALID_NUMBER);
			}

			if (!duplicateNumber.add(number)) {
				throw new IllegalArgumentException(DUPLICATE_NUMBER);
			}
		}
	}

	private int getNumberByIdx(int idx) {
		return baseballNumber.get(idx);
	}

	public int size() {
		return baseballNumber.size();
	}

	public boolean containsNumber(BaseBallNumber compareNumber, int idx) {
		return baseballNumber.contains(compareNumber.getNumberByIdx(idx));
	}

	public boolean hasNumber(BaseBallNumber compareNumber, int idx) {
		return baseballNumber.get(idx) == compareNumber.getNumberByIdx(idx);
	}
}
