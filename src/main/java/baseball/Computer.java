package baseball;

public class Computer {

	Number number;

	public void generate() {
		number = Number.generateRandomNumbers();
	}

	public Number getNumber() {
		return number;
	}

}
