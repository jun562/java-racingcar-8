package racingcar;

import racingcar.controller.InputController;
import racingcar.controller.RacingGameController;
import racingcar.model.AttemptCountValidator;
import racingcar.model.CarNameValidator;
import racingcar.model.Parser;
import racingcar.model.RacingGame;

public class Application {
    public static void main(String[] args) {
        // TODO: 프로그램 구현
        Parser paser = new Parser();
        CarNameValidator carNameValidator = new CarNameValidator();
        AttemptCountValidator attemptCountValidator = new AttemptCountValidator();

        // 컨트롤러 실행
        InputController inputController = new InputController(paser, carNameValidator, attemptCountValidator);
        RacingGame racingGame = inputController.getRacingGame();
        RacingGameController racingGameController = new RacingGameController();

        // 게임 진행
        racingGameController.runGame(racingGame);
    }
}
