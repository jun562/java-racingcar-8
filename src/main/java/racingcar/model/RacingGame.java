package racingcar.model;

import java.util.List;
import java.util.stream.Collectors;

public class RacingGame {
    private List<Car> cars;
    private final int attemptCount;

    public RacingGame(List<String> carNames, int attemptCount) {
        this.cars = carNames.stream().map(Car::new).collect(Collectors.toList());
        this.attemptCount = attemptCount;
    }

    public List<Car> getCars() {
        return this.cars;
    }

    public int getAttemptCount() {
        return this.attemptCount;
    }
}
