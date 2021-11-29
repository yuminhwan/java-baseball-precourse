package baseball.domain;

public class Computer {

    private BaseBallNumbers computerNumbers;

    public void generateComputerNumbers() {
        computerNumbers = BaseBallNumbers.generateComputerNumbers();
    }

    public BaseBallNumbers getComputerNumbers() {
        return computerNumbers;
    }
}
