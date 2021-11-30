package baseball.view;

import java.util.Arrays;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

import camp.nextstep.edu.missionutils.Console;

public class InputView {
    private static final String INVALID_LENGTH = "세 자리를 입력해야 합니다.";
    private static final String INVALID_NUMBER = "1-9 사이의 숫자를 입력해야 합니다.";
    private static final String DUPLICATE_NUMBER = "서로 동일하지 않은 숫자를 입력해야 합니다.";
    private static final String INVALID_COMMAND_NUMBER = "1 또는 2만 입력해야 합니다.";
    private static final String REQUEST_INPUT_NUMBER = "숫자를 입력해주세요 : ";
    private static final String ANSWER_AND_GAME_OVER = "3개의 숫자를 모두 맞히셨습니다! 게임 종료";
    private static final String REQUEST_RESTART_OR_END = "게임을 새로 시작하려면 1, 종료하려면 2를 입력하세요.";
    private static final String RESTART_COMMAND = "1";
    private static final String END_COMMAND = "2";
    private static final int MIN_NUMBER = '1';
    private static final int MAX_NUMBER = '9';
    private static final int NUMBER_LENGTH = 3;

    private InputView() {
    }

    public static List<Integer> inputBaseBallNumbers() {
        System.out.print(REQUEST_INPUT_NUMBER);
        String inputNumbers = Console.readLine();
        validateNumbers(inputNumbers);
        return Arrays.stream(inputNumbers.split(""))
            .map(Integer::parseInt)
            .collect(Collectors.toList());
    }

    public static String inputCommandNumber() {
        System.out.println(ANSWER_AND_GAME_OVER);
        System.out.println(REQUEST_RESTART_OR_END);
        String commandNumber = Console.readLine();
        validateCommand(commandNumber);
        return commandNumber;
    }

    private static void validateNumbers(String inputNumbers) {
        Set<Character> duplicateNumbers = new HashSet<>();

        if (inputNumbers.length() != NUMBER_LENGTH) {
            throw new IllegalArgumentException(INVALID_LENGTH);
        }

        for (int idx = 0; idx < NUMBER_LENGTH; idx++) {
            char number = inputNumbers.charAt(idx);
            validateDigitAndNumberRange(number);
            validateDuplicate(duplicateNumbers, number);
        }
    }

    private static void validateDuplicate(Set<Character> duplicateNumbers, char number) {
        if (!duplicateNumbers.add(number)) {
            throw new IllegalArgumentException(DUPLICATE_NUMBER);
        }
    }

    private static void validateDigitAndNumberRange(char number) {
        if (number < MIN_NUMBER || number > MAX_NUMBER) {
            throw new IllegalArgumentException(INVALID_NUMBER);
        }
    }

    private static void validateCommand(String command) {
        if (!command.equals(RESTART_COMMAND) && !command.equals(END_COMMAND)) {
            throw new IllegalArgumentException(INVALID_COMMAND_NUMBER);
        }
    }
}
