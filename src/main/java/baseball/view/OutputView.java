package baseball.view;

import baseball.dto.GameResultDto;

public class OutputView {
    private static final int INITIAL_VALUE = 0;
    private static final String BALL = "볼";
    private static final String STRIKE = "스트라이크";
    private static final String NOTHING = "낫싱";

    private OutputView() {
    }

    public static void outputGameResult(GameResultDto gameResultDto) {
        String message = getMessage(gameResultDto);
        System.out.println(message);
    }

    public static String getMessage(GameResultDto gameResultDto) {
        if (isNothing(gameResultDto.getStrike(), gameResultDto.getBall())) {
            return NOTHING;
        }
        return ballAndStrike(gameResultDto.getStrike(), gameResultDto.getBall());
    }

    private static String ballAndStrike(int strike, int ball) {

        if (isOnlyStrike(ball)) {
            return strike + STRIKE;
        }

        if (isOnlyBall(strike)) {
            return ball + BALL;
        }

        return ball + BALL + " " + strike + STRIKE;
    }

    public static boolean isNothing(int strike, int ball) {
        return strike + ball == INITIAL_VALUE;
    }

    public static boolean isOnlyStrike(int ball) {
        return ball == INITIAL_VALUE;
    }

    public static boolean isOnlyBall(int strike) {
        return strike == INITIAL_VALUE;
    }
}
