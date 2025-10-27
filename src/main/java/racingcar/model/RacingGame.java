package racingcar.model;

import camp.nextstep.edu.missionutils.Randoms;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;
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

    public List<String> findWinners() {
        Stream<Car> carsStream = this.cars.stream();
        Stream<Car> filteredCarsStream = carsStream.filter((car -> car.getCurrentDistance() == getMaxDistance()));
        Stream<String> filteredCarNames = filteredCarsStream.map(Car::getCarName);
        return filteredCarNames.collect(Collectors.toList());
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

    private int createRandomNumber() {
        return Randoms.pickNumberInRange(START_RANDOM_NUMBER, END_RANDOM_NUMBER);
    }

    private int getMaxDistance() {
        Stream<Car> carsStream = this.cars.stream();
        IntStream carsDistance = carsStream.mapToInt(Car::getCurrentDistance);
        return carsDistance.max().orElse(0);
    }
}
