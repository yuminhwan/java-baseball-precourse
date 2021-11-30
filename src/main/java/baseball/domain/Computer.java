package baseball.domain;

public class Computer {

    private final BaseBallNumbers computerNumbers;

    public Computer(BaseBallNumbers computerNumbers) {
        this.computerNumbers = computerNumbers;
    }

    public BaseBallNumbers getComputerNumbers() {
        return computerNumbers;
    }
}
