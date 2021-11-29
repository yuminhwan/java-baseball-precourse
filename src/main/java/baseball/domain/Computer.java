package baseball.domain;

public class Computer {

    private final BaseBallNumbers computerNumbers;

    public Computer() {
        this.computerNumbers = BaseBallNumbers.generateComputerNumbers();
    }

    public BaseBallNumbers getComputerNumbers() {
        return computerNumbers;
    }
}
