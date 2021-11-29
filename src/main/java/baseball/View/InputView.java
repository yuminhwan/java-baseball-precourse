package baseball.View;

import camp.nextstep.edu.missionutils.Console;

public class InputView {
    private static final String REQUEST_INPUT_NUMBER = "숫자를 입력해주세요 : ";
    private static final String ANSWER_AND_GAME_OVER = "3개의 숫자를 모두 맞히셨습니다! 게임 종료";
    private static final String REQUEST_RESTART_OR_END = "게임을 새로 시작하려면 1, 종료하려면 2를 입력하세요.";

    public String inputBaseBallNumbers() {
        System.out.print(REQUEST_INPUT_NUMBER);
        return Console.readLine();
    }

    public String inputCommandNumber() {
        System.out.println(ANSWER_AND_GAME_OVER);
        System.out.println(REQUEST_RESTART_OR_END);
        return Console.readLine();
    }
}
