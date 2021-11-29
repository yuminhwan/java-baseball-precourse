package baseball.domain;

public class Referee {
    private static final int INITIAL_VALUE = 0;

    private final BaseBallNumbers computerNumbers;

    public Referee(BaseBallNumbers computerNumbers) {
        this.computerNumbers = computerNumbers;
    }

    public GameResult judgeResult(BaseBallNumbers playerNumbers) {
        int strike = INITIAL_VALUE;
        int ball = INITIAL_VALUE;

        for (int idx = 0; idx < playerNumbers.size(); idx++) {
            if (isStrike(playerNumbers, idx)) {
                strike++;
                continue;
            }

            if (isBall(playerNumbers, idx)) {
                ball++;
            }
        }

        return new GameResult(strike, ball);
    }

    private boolean isStrike(BaseBallNumbers playerNumbers, int idx) {
        return computerNumbers.hasNumber(playerNumbers, idx);
    }

    private boolean isBall(BaseBallNumbers playerNumbers, int idx) {
        return computerNumbers.containsNumber(playerNumbers, idx);
    }

}
