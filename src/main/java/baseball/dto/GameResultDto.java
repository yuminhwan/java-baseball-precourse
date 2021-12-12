package baseball.dto;

import baseball.domain.GameResult;

public class GameResultDto {
    private final int strike;
    private final int ball;

    private GameResultDto(int strike, int ball) {
        this.strike = strike;
        this.ball = ball;
    }

    public static GameResultDto from(GameResult gameResult) {
        return new GameResultDto(gameResult.getStrike(), gameResult.getBall());
    }

    public int getStrike() {
        return strike;
    }

    public int getBall() {
        return ball;
    }

}
