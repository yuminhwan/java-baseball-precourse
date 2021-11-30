package baseball;

import static baseball.message.SystemMessage.*;

import baseball.View.InputView;
import baseball.View.OutputView;
import baseball.domain.Computer;
import baseball.domain.GameResult;
import baseball.domain.Player;
import baseball.domain.Referee;

public class Application {
    private static final String RESTART_COMMAND = "1";
    private static final String END_COMMAND = "2";

    public static void main(String[] args) {
        InputView inputView = new InputView();
        do {
            Computer computer = new Computer();
            Referee referee = new Referee(computer.getComputerNumbers());
            startGame(inputView, referee);
        } while (restartGame(inputView));

    }

    private static void startGame(InputView inputView, Referee referee) {
        GameResult gameResult;
        do {
            Player player = new Player(inputView.inputBaseBallNumbers());
            gameResult = referee.judgeResult(player.getPlayerNumbers());
            OutputView.outputGameResult(gameResult);
        } while (!gameResult.isAnswer());
    }

    private static boolean restartGame(InputView inputView) {
        String inputCommand = inputView.inputCommandNumber();
        validateCommand(inputCommand);
        return inputCommand.equals(RESTART_COMMAND);
    }

    private static void validateCommand(String command) {
        if (!command.equals(RESTART_COMMAND) && !command.equals(END_COMMAND)) {
            throw new IllegalArgumentException(INVALID_COMMAND_NUMBER);
        }
    }

}
