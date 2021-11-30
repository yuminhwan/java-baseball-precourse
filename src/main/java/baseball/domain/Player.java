package baseball.domain;

import java.util.List;

public class Player {

    private final BaseBallNumbers playerNumbers;

    public Player(List<Integer> inputNumber) {
        this.playerNumbers = BaseBallNumbers.generatePlayerNumbers(inputNumber);
    }

    public BaseBallNumbers getPlayerNumbers() {
        return playerNumbers;
    }
}
