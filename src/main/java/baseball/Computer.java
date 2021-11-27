package baseball;

public class Computer {

	private BaseBallNumber computerNumber;

	public void generateComputerNumber() {
		computerNumber = BaseBallNumber.generateComputerNumber();
	}

	public BaseBallNumber getComputerNumber() {
		return computerNumber;
	}
}
