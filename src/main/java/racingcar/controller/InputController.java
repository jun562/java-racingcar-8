package racingcar.controller;

import java.util.List;
import racingcar.model.AttemptCountValidator;
import racingcar.model.CarNameValidator;
import racingcar.model.Parser;
import racingcar.model.RacingGame;
import racingcar.view.Input;

public class InputController {
    private final Parser parser;
    private final CarNameValidator carNameValidator;
    private final AttemptCountValidator attemptCountValidator;

    public InputController() {
        this.parser = new Parser();
        this.carNameValidator = new CarNameValidator();
        this.attemptCountValidator = new AttemptCountValidator();
    }

    public RacingGame getRacingGame() {
        return new RacingGame(getCarNamesList(), getAttemptCount());
    }

    private List<String> getCarNamesList() {
        String carNamesInput = Input.readCarNames();
        List<String> carNames = parser.parseCarNames(carNamesInput);
        carNameValidator.validate(carNames);
        return carNames;
    }

    private int getAttemptCount() {
        String attemptCountInput = Input.readAttemptCount();
        int attemptCount = parser.parseAttemptCount(attemptCountInput);
        attemptCountValidator.validate(attemptCount);
        return attemptCount;
    }
}
