package baseball;

public class Computer {

	private BaseBallNumber computerNumber;

	public void generate() {
		computerNumber = BaseBallNumber.generateAnswerNumber();
	}

	public BaseBallNumber getComputerNumber() {
		return computerNumber;
	}
}
