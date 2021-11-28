package baseball.domain;

public class Computer {

	private BaseBallNumber computerNumber;

	public void generateComputerNumber() {
		computerNumber = BaseBallNumber.generateComputerNumber();
	}

	public BaseBallNumber getComputerNumber() {
		return computerNumber;
	}
}
