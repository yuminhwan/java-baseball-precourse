package baseball.View;

import baseball.domain.GameResult;

public class OutputView {
    private static final String BALL = "볼";
    private static final String STRIKE = "스트라이크";
    private static final String NOTHING = "낫싱";

    private OutputView() {
    }

    public static void outputGameResult(GameResult gameResult) {
        String message = getOutputResult(gameResult);
        System.out.println(message);
    }

    public static String getOutputResult(GameResult gameResult) {
        if (gameResult.isNothing()) {
            return NOTHING;
        }
        return ballAndStrike(gameResult);
    }

    private static String ballAndStrike(GameResult gameResult) {

        if (gameResult.isOnlyStrike()) {
            return gameResult.getStrike() + STRIKE;
        }

        if (gameResult.isOnlyBall()) {
            return gameResult.getBall() + BALL;
        }

        return gameResult.getBall() + BALL + " " + gameResult.getStrike() + STRIKE;
    }
}
