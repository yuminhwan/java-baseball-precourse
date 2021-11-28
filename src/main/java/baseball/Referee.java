package baseball;

import static baseball.ConstValue.*;

public class Referee {

	private BaseBallNumber computerNumber;
	private int strike;
	private int ball;

	public void saveComputerNumber( BaseBallNumber computerNumber ) {
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

	public void printResult() {
		System.out.println( getResult() );
	}

	private String getResult() {
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
			return strike + STRIKE;
		}

		if ( isOnlyBall() ) {
			return ball + BALL;
		}

		return ball + BALL + " " + strike + STRIKE;
	}

	private boolean isStrike(BaseBallNumber playerNumber, int idx) {
		return computerNumber.hasNumber(playerNumber.getNthNumber(idx), idx);
	}

	private boolean isBall(BaseBallNumber playerNumber, int idx) {
		return computerNumber.containsNumber(playerNumber.getNthNumber(idx));
	}

	private boolean isNothing() {
		return strike + ball == INITIAL_VALUE;
	}

	private boolean isOnlyBall() {
		return strike == INITIAL_VALUE;
	}

	private boolean isOnlyStrike() {
		return ball == INITIAL_VALUE;
	}
}
