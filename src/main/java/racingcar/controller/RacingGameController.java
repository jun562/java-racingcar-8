package racingcar.controller;

import java.util.List;
import racingcar.model.RacingGame;
import racingcar.view.Output;

public class RacingGameController {
    public RacingGameController() {

    }

    public void runGame(RacingGame racingGame) {
        printStartMessage();
        executeGameRounds(racingGame);
        printFinalResults(racingGame);
    }

    private void printStartMessage() {
        Output.printResultHeader();
    }

    private void executeGameRounds(RacingGame racingGame) {
        int attemptCount = racingGame.getAttemptCount();

        for (int count = 0; count < attemptCount; count++) {
            racingGame.playOneTime();
            Output.printRoundResult(racingGame.getCars());
        }
    }

    private void printFinalResults(RacingGame racingGame) {
        List<String> winners = racingGame.findWinners();
        Output.printWinners(winners);
    }
}
