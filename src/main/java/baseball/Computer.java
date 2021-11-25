package baseball;

import java.util.HashMap;
import java.util.Map;

public class Computer {

	Number computerNumbers;
	Map<String, Integer> result;

	public void generate() {
		computerNumbers = Number.generateRandomNumbers();
	}

	public void calculateResultCount(Number playerNumbers) {

		int strike = 0;
		int ball = 0;

		for (int i = 0; i < 3; i++) {
			if ( computerNumbers.isSameNumber(playerNumbers.getNumByIdx(i), i) ) {
				strike++;
				continue;
			}

			if ( computerNumbers.isContainNumber(playerNumbers.getNumByIdx(i)) ) {
				ball++;
			}
		}

		saveResult(strike,ball);
	}

	private void saveResult (int strike, int ball) {
		result = new HashMap<>();
		result.put("STRIKE", strike);
		result.put("BALL", ball);
	}

}
