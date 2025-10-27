package racingcar.model;

import camp.nextstep.edu.missionutils.Randoms;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class RacingGame {
    private static final int START_RANDOM_NUMBER = 0;
    private static final int END_RANDOM_NUMBER = 9;

    private List<Car> cars;
    private final int attemptCount;

    public RacingGame(List<String> carNames, int attemptCount) {
        this.cars = createCarsFromNames(carNames);
        this.attemptCount = attemptCount;
    }

    public void playOneTime() {
        for (Car car : this.cars) {
            car.move(createRandomNumber());
        }
    }

    public int createRandomNumber() {
        return Randoms.pickNumberInRange(START_RANDOM_NUMBER, END_RANDOM_NUMBER);
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
