package baseball;

import baseball.domain.Computer;
import baseball.domain.Player;
import baseball.domain.Referee;

public class Application {
	public static void main(String[] args) {
		Player player = new Player();
		Computer computer = new Computer();
		Referee referee = new Referee();
		GameController baseBall = new GameController(player, computer, referee);
		baseBall.run();
	}
}
