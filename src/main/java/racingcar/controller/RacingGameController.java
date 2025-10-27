package racingcar.controller;

import java.util.List;
import racingcar.model.Car;
import racingcar.model.RacingGame;
import racingcar.view.Output;

public class RacingGameController {
    public RacingGameController() {

    }

    public void runGame(RacingGame racingGame) {
        Output.printResultHeader();

        int attemptCount = racingGame.getAttemptCount();

        for (int count = 0; count < attemptCount; count++) {
            racingGame.playOneTime();

            List<Car> roundResult = racingGame.getCars();
            Output.printRoundResult(roundResult);
        }

        List<String> winners = racingGame.findWinners();

        Output.printWinners(winners);
    }
}
