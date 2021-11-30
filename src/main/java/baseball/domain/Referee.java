package baseball.domain;

import java.util.HashMap;
import java.util.Map;

public class Referee {
    private static final String BALL = "볼";
    private static final String STRIKE = "스트라이크";

    private final BaseBallNumbers computerNumbers;

    public Referee(BaseBallNumbers computerNumbers) {
        this.computerNumbers = computerNumbers;
    }

    public GameResult judgeResult(BaseBallNumbers playerNumbers) {
        Map<String, Integer> result = new HashMap<>();

        for (int idx = 0; idx < playerNumbers.size(); idx++) {
            judgeBallAndStrike(playerNumbers, result, idx);
        }

        return new GameResult(result.getOrDefault(STRIKE, 0), result.getOrDefault(BALL, 0));
    }

    private void judgeBallAndStrike(BaseBallNumbers playerNumbers, Map<String, Integer> result, int idx) {
        if (isStrike(playerNumbers, idx)) {
            result.put(STRIKE, result.getOrDefault(STRIKE, 0) + 1);
            return;
        }

        if (isBall(playerNumbers, idx)) {
            result.put(BALL, result.getOrDefault(BALL, 0) + 1);
        }
    }

    private boolean isStrike(BaseBallNumbers playerNumbers, int idx) {
        return computerNumbers.hasNumber(playerNumbers, idx);
    }

    private boolean isBall(BaseBallNumbers playerNumbers, int idx) {
        return computerNumbers.containsNumber(playerNumbers, idx);
    }

}
