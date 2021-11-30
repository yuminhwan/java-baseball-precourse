package baseball;

import baseball.domain.BaseBallNumbers;
import baseball.domain.Computer;
import baseball.domain.GameResult;
import baseball.domain.Player;
import baseball.domain.Referee;
import baseball.dto.OutputDto;
import baseball.view.InputView;
import baseball.view.OutputView;

public class Application {
    private static final String RESTART_COMMAND = "1";

    public static void main(String[] args) {
        do {
            Computer computer = new Computer(BaseBallNumbers.generateComputerNumbers());
            Referee referee = new Referee(computer.getComputerNumbers());
            startGame(referee);
        } while (restartGame());

    }

    private static void startGame(Referee referee) {
        GameResult gameResult;
        do {
            Player player = new Player(InputView.inputBaseBallNumbers());
            gameResult = referee.judgeResult(player.getPlayerNumbers());
            OutputView.outputGameResult(OutputDto.from(gameResult));
        } while (!gameResult.isAnswer());
    }

    private static boolean restartGame() {
        String inputCommand = InputView.inputCommandNumber();
        return inputCommand.equals(RESTART_COMMAND);
    }

}
