package baseball.domain;

public class Referee {

    private final BaseBallNumbers computerNumbers;

    public Referee(BaseBallNumbers computerNumbers) {
        this.computerNumbers = computerNumbers;
    }

    public GameResult judgeResult(BaseBallNumbers playerNumbers) {
        int strike = computerNumbers.judgeStrike(playerNumbers);
        int ball = computerNumbers.judgeBall(playerNumbers);
        return new GameResult(strike, ball);
    }

}
