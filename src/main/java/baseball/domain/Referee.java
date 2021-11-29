package baseball.domain;

public class Referee {
	private static final int INITIAL_VALUE = 0;
	private static final int ANSWER_COUNT = 3;
	private static final String BALL = "볼";
	private static final String STRIKE = "스트라이크";
	private static final String NOTHING = "낫싱";

	private BaseBallNumber computerNumber;
	private int strike;
	private int ball;

	public void saveComputerNumber(BaseBallNumber computerNumber) {
		this.computerNumber = computerNumber;
	}

	public void judgeResult(BaseBallNumber playerNumber) {
		initBallAndStrike();

		for (int idx = 0; idx < playerNumber.size(); idx++) {
			judgeBallAndStrike(playerNumber, idx);
		}
	}

	private void judgeBallAndStrike(BaseBallNumber playerNumber, int idx) {
		if (isStrike(playerNumber, idx)) {
			strike++;
			return;
		}

		if (isBall(playerNumber, idx)) {
			ball++;
		}
	}

	private void initBallAndStrike() {
		strike = INITIAL_VALUE;
		ball = INITIAL_VALUE;
	}

	private boolean isStrike(BaseBallNumber playerNumber, int idx) {
		return computerNumber.hasNumber(playerNumber, idx);
	}

	private boolean isBall(BaseBallNumber playerNumber, int idx) {
		return computerNumber.containsNumber(playerNumber, idx);
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
