package racingcar.model;

import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class RacingGame {
    private List<Car> cars;
    private final int attemptCount;

    public RacingGame(List<String> carNames, int attemptCount) {
        this.cars = createCarsFromNames(carNames);
        this.attemptCount = attemptCount;
    }

    public List<Car> getCars() {
        return this.cars;
    }

    public int getAttemptCount() {
        return this.attemptCount;
    }

    private List<Car> createCarsFromNames(List<String> carNames) {
        Stream<String> carNamesStream = carNames.stream();
        Stream<Car> carsStream = carNamesStream.map(Car::new);
        return carsStream.collect(Collectors.toList());
    }
}
