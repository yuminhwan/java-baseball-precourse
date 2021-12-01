package baseball.domain;

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

    private BaseBallNumbers(List<BaseBallNumber> baseballNumbers) {
        this.baseballNumbers = baseballNumbers;
    }

    public static BaseBallNumbers generateComputerNumbers() {
        Set<Integer> randomNumbers = new HashSet<>();

        while (randomNumbers.size() < NUMBER_LENGTH) {
            int randomNumber = Randoms.pickNumberInRange(MIN_NUMBER, MAX_NUMBER);
            randomNumbers.add(randomNumber);
        }

        List<BaseBallNumber> answerNumbers = randomNumbers.stream()
            .map(BaseBallNumber::new)
            .collect(Collectors.toList());
        return new BaseBallNumbers(answerNumbers);
    }

    public static BaseBallNumbers generatePlayerNumbers(List<Integer> inputNumbers) {
        List<BaseBallNumber> playerNumbers = inputNumbers.stream()
            .map(BaseBallNumber::new)
            .collect(Collectors.toList());
        return new BaseBallNumbers(playerNumbers);
    }

    public int judgeStrike(BaseBallNumbers compareNumbers) {
        int strike = 0;
        for (int idx = 0; idx < NUMBER_LENGTH; idx++) {
            if (isStrike(compareNumbers, idx)) {
                strike++;
            }
        }
        return strike;
    }

    public int judgeBall(BaseBallNumbers compareNumbers) {
        int ball = 0;
        for (int idx = 0; idx < NUMBER_LENGTH; idx++) {
            if (isBall(compareNumbers, idx)) {
                ball++;
            }
        }
        return ball;
    }

    private boolean isBall(BaseBallNumbers compareNumbers, int idx) {
        return !isStrike(compareNumbers, idx) && baseballNumbers.contains(compareNumbers.baseballNumbers.get(idx));
    }

    private boolean isStrike(BaseBallNumbers compareNumbers, int idx) {
        return baseballNumbers.get(idx).equals(compareNumbers.baseballNumbers.get(idx));
    }
}
