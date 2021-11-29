package baseball.domain;

public class Referee {
    private static final int INITIAL_VALUE = 0;
    private static final int ANSWER_COUNT = 3;
    private static final String BALL = "볼";
    private static final String STRIKE = "스트라이크";
    private static final String NOTHING = "낫싱";

    private BaseBallNumbers computerNumbers;
    private int strike;
    private int ball;

    public void saveComputerNumbers(BaseBallNumbers computerNumbers) {
        this.computerNumbers = computerNumbers;
    }

    public void judgeResult(BaseBallNumbers playerNumbers) {
        initBallAndStrike();

        for (int idx = 0; idx < playerNumbers.size(); idx++) {
            judgeBallAndStrike(playerNumbers, idx);
        }
    }

    private void judgeBallAndStrike(BaseBallNumbers playerNumbers, int idx) {
        if (isStrike(playerNumbers, idx)) {
            strike++;
            return;
        }

        if (isBall(playerNumbers, idx)) {
            ball++;
        }
    }

    private void initBallAndStrike() {
        strike = INITIAL_VALUE;
        ball = INITIAL_VALUE;
    }

    private boolean isStrike(BaseBallNumbers playerNumbers, int idx) {
        return computerNumbers.hasNumber(playerNumbers, idx);
    }

    private boolean isBall(BaseBallNumbers playerNumbers, int idx) {
        return computerNumbers.containsNumber(playerNumbers, idx);
    }

    public String getResult() {
        if (isNothing()) {
            return NOTHING;
        }
        return ballAndStrike();
    }

    private boolean isNothing() {
        return strike + ball == INITIAL_VALUE;
    }

    private String ballAndStrike() {

        if (isOnlyStrike()) {
            return strike + STRIKE;
        }

        if (isOnlyBall()) {
            return ball + BALL;
        }

        return ball + BALL + " " + strike + STRIKE;
    }

    private boolean isOnlyBall() {
        return strike == INITIAL_VALUE;
    }

    private boolean isOnlyStrike() {
        return ball == INITIAL_VALUE;
    }

    public boolean isAnswer() {
        return strike == ANSWER_COUNT;
    }
}
