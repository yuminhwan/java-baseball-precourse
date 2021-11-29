package baseball.domain;

import camp.nextstep.edu.missionutils.Console;

public class Player {

    private BaseBallNumbers playerNumbers;

    public void inputNumbers() {
        String inputNumber = Console.readLine();
        playerNumbers = BaseBallNumbers.generatePlayerNumber(inputNumber);
    }

    public BaseBallNumbers getPlayerNumbers() {
        return playerNumbers;
    }
}
