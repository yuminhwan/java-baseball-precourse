package baseball.dto;

import baseball.domain.GameResult;

public class OutputDto {
    private final int strike;
    private final int ball;

    private OutputDto(int strike, int ball) {
        this.strike = strike;
        this.ball = ball;
    }

    public static OutputDto from(GameResult gameResult) {
        return new OutputDto(gameResult.getStrike(), gameResult.getBall());
    }

    public int getStrike() {
        return strike;
    }

    public int getBall() {
        return ball;
    }

}
