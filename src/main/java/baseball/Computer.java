package baseball;

public class Computer {

	Number numbers;

	public void generate() {
		numbers = Number.generateRandomNumbers();
	}

	public Number getNumber() {
		return numbers;
	}

}
