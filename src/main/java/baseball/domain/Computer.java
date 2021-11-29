package baseball.domain;

public class Computer {

	private BaseBallNumbers computerNumbers;

	public void generateComputerNumbers() {
		computerNumbers = BaseBallNumbers.generateComputerNumber();
	}

	public BaseBallNumbers getComputerNumbers() {
		return computerNumbers;
	}
}
