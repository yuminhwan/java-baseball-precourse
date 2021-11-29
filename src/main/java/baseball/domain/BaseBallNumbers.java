package baseball.domain;

import static baseball.message.SystemMessage.*;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

import camp.nextstep.edu.missionutils.Randoms;

public class BaseBallNumbers {
    private static final int MIN_NUMBER = 1;
    private static final int MAX_NUMBER = 9;
    private static final int NUMBER_LENGTH = 3;

    private final List<Integer> baseballNumbers;

    public BaseBallNumbers(List<Integer> baseballNumbers) {
        this.baseballNumbers = baseballNumbers;
    }

    public static BaseBallNumbers generateComputerNumbers() {
        List<Integer> answerNumbers = new ArrayList<>();

        while (answerNumbers.size() < NUMBER_LENGTH) {
            int randomNumber = Randoms.pickNumberInRange(MIN_NUMBER, MAX_NUMBER);
            if (!answerNumbers.contains(randomNumber)) {
                answerNumbers.add(randomNumber);
            }
        }
        return new BaseBallNumbers(answerNumbers);
    }

    public static BaseBallNumbers generatePlayerNumbers(String inputNumbers) {
        validateNumber(inputNumbers);
        List<Integer> playerNumbers = convertStringToInt(inputNumbers);
        return new BaseBallNumbers(playerNumbers);
    }

    private static List<Integer> convertStringToInt(String inputNumbers) {
        String[] splitNumbers = inputNumbers.split("");

        return Arrays.stream(splitNumbers)
            .map(Integer::parseInt)
            .collect(Collectors.toCollection(ArrayList::new));
    }

    private static void validateNumber(String inputNumbers) {
        Set<Character> duplicateNumbers = new HashSet<>();

        if (inputNumbers.length() != NUMBER_LENGTH) {
            throw new IllegalArgumentException(INVALID_LENGTH);
        }

        for (int idx = 0; idx < NUMBER_LENGTH; idx++) {
            char number = inputNumbers.charAt(idx);
            if (number < Character.forDigit(MIN_NUMBER, 10) || number > Character.forDigit(MAX_NUMBER, 10)) {
                throw new IllegalArgumentException(INVALID_NUMBER);
            }

            if (!duplicateNumbers.add(number)) {
                throw new IllegalArgumentException(DUPLICATE_NUMBER);
            }
        }
    }

    public int size() {
        return baseballNumbers.size();
    }

    public boolean containsNumber(BaseBallNumbers compareNumber, int idx) {
        return baseballNumbers.contains(compareNumber.baseballNumbers.get(idx));
    }

    public boolean hasNumber(BaseBallNumbers compareNumber, int idx) {
        return baseballNumbers.get(idx).equals(compareNumber.baseballNumbers.get(idx));
    }
}
