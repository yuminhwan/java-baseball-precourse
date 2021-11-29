package baseball.domain;

public class GameResult {
    private static final int INITIAL_VALUE = 0;
    private static final int ANSWER_COUNT = 3;

    private final int strike;
    private final int ball;

    public GameResult(int strike, int ball) {
        this.strike = strike;
        this.ball = ball;
    }

    public boolean isNothing() {
        return strike + ball == INITIAL_VALUE;
    }

    public boolean isOnlyBall() {
        return strike == INITIAL_VALUE;
    }

    public boolean isOnlyStrike() {
        return ball == INITIAL_VALUE;
    }

    public boolean isAnswer() {
        return strike == ANSWER_COUNT;
    }

    public int getStrike() {
        return strike;
    }

    public int getBall() {
        return ball;
    }
}
