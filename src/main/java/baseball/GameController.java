package baseball;

import static baseball.message.SystemMessage.*;

import baseball.domain.Computer;
import baseball.domain.Player;
import baseball.domain.Referee;
import camp.nextstep.edu.missionutils.Console;

public class GameController {
    private static final String RESTART_COMMAND = "1";
    private static final String END_COMMAND = "2";

    private final Player player;
    private final Computer computer;
    private final Referee referee;

    public GameController(Player player, Computer computer, Referee referee) {
        this.player = player;
        this.computer = computer;
        this.referee = referee;
    }

    public void run() {
        do {
            readyForGame();
            startGame();
        } while (restartGame());
    }

    private void readyForGame() {
        computer.generateComputerNumbers();
        referee.saveComputerNumbers(computer.getComputerNumbers());
    }

    private void startGame() {
        do {
            inputPlayerNumbers();
            referee.judgeResult(player.getPlayerNumbers());
            System.out.println(referee.getResult());
        } while (!referee.isAnswer());
    }

    private void inputPlayerNumbers() {
        System.out.print(REQUEST_INPUT_NUMBER);
        player.inputNumbers();
    }

    private boolean restartGame() {
        String inputCommand = inputCommandNumber();
        validateCommand(inputCommand);
        return inputCommand.equals(RESTART_COMMAND);
    }

    private String inputCommandNumber() {
        System.out.println(ANSWER_AND_GAME_OVER);
        System.out.println(REQUEST_RESTART_OR_END);
        return Console.readLine();
    }

    private void validateCommand(String command) {
        if (!command.equals(RESTART_COMMAND) && !command.equals(END_COMMAND)) {
            throw new IllegalArgumentException(INVALID_COMMAND_NUMBER);
        }
    }
}
