package baseball;

public class Referee {
	private static final int NUMBER_LENGTH = 3;
	private static final int INITIAL_VALUE = 0;
	private static final String BALL = "볼";
	private static final String STRIKE = "스트라이크";
	private static final String NOTHING = "낫싱";

	private BaseBallNumber computerNumber;
	private int strike;
	private int ball;

	public void readyForGame( BaseBallNumber computerNumber ) {
		this.computerNumber = computerNumber;
	}

	public void judgeResult( BaseBallNumber playerNumber ) {
		initBallAndStrike();

		for ( int idx = 0; idx < NUMBER_LENGTH; idx++ ) {
			if ( isStrike(playerNumber, idx) ) {
				strike++;
				continue;
			}

			if ( isBall(playerNumber, idx) ) {
				ball++;
			}
		}
	}

	public String getResult() {
		if ( isNothing() ) {
			return NOTHING;
		}
		return ballAndStrike();
	}

	public boolean isAnswer() {
		return strike == 3;
	}

	private void initBallAndStrike() {
		strike = INITIAL_VALUE;
		ball = INITIAL_VALUE;
	}

	private String ballAndStrike() {

		if ( isOnlyStrike() ) {
			return strike + "스트라이크";
		}

		if ( isOnlyBall() ) {
			return ball + "볼";
		}

		return ball + BALL + " " + strike + STRIKE;
	}

	private boolean isStrike(BaseBallNumber playerNumber, int idx) {
		return computerNumber.hasNumber(playerNumber.getNthDigit(idx), idx);
	}

	private boolean isBall(BaseBallNumber playerNumber, int idx) {
		return computerNumber.containsNumber(playerNumber.getNthDigit(idx));
	}

	private boolean isNothing() {
		return strike + ball == INITIAL_VALUE;
	}

	private boolean isOnlyBall() {
		return strike == 0;
	}

	private boolean isOnlyStrike() {
		return ball == 0;
	}
}
