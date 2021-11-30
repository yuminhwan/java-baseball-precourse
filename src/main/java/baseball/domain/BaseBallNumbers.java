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

    private final List<BaseBallNumber> baseballNumbers;

    public BaseBallNumbers(List<BaseBallNumber> baseballNumbers) {
        this.baseballNumbers = baseballNumbers;
    }

    public static BaseBallNumbers generateComputerNumbers() {
        List<BaseBallNumber> answerNumbers = new ArrayList<>();

        while (answerNumbers.size() < NUMBER_LENGTH) {
            int randomNumber = Randoms.pickNumberInRange(MIN_NUMBER, MAX_NUMBER);
            BaseBallNumber baseballNumber = BaseBallNumber.generateBaseBallNumber(randomNumber);
            if (!answerNumbers.contains(baseballNumber)) {
                answerNumbers.add(baseballNumber);
            }
        }
        return new BaseBallNumbers(answerNumbers);
    }

    public static BaseBallNumbers generatePlayerNumbers(String inputNumbers) {
        validateNumbers(inputNumbers);
        List<BaseBallNumber> playerNumbers = convertStringToBaseBallNumber(inputNumbers);
        return new BaseBallNumbers(playerNumbers);
    }

    private static List<BaseBallNumber> convertStringToBaseBallNumber(String inputNumbers) {
        String[] splitNumbers = inputNumbers.split("");

        return Arrays.stream(splitNumbers)
            .map(Integer::parseInt)
            .map(BaseBallNumber::generateBaseBallNumber)
            .collect(Collectors.toCollection(ArrayList::new));
    }

    private static void validateNumbers(String inputNumbers) {
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

    public boolean containsNumber(BaseBallNumbers compareNumbers, int idx) {
        return baseballNumbers.contains(compareNumbers.baseballNumbers.get(idx));
    }

    public boolean hasNumber(BaseBallNumbers compareNumbers, int idx) {
        return baseballNumbers.get(idx).equals(compareNumbers.baseballNumbers.get(idx));
    }
}
