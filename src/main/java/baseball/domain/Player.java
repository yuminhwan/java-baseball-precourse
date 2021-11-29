package baseball.domain;

public class Player {

    private final BaseBallNumbers playerNumbers;

    public Player(String inputNumber) {
        this.playerNumbers = BaseBallNumbers.generatePlayerNumbers(inputNumber);
    }

    public BaseBallNumbers getPlayerNumbers() {
        return playerNumbers;
    }
}
