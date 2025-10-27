package racingcar.model;

import static org.junit.jupiter.api.Assertions.assertEquals;

import java.util.List;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class RacingGameTest {
    @Test
    @DisplayName("입력받은_자동차_이름으로_자동차_객체_생성")
    void createCarsWhenNameGiven() {
        List<String> carNames = List.of("pobi", "car", "jun");
        int attemptCount = 5;

        RacingGame game = new RacingGame(carNames, attemptCount);
        List<Car> cars = game.getCars();

        for (int index = 0; index < cars.size(); index++) {
            Car currentCar = cars.get(index);
            String expectedName = carNames.get(index);

            assertEquals(expectedName, currentCar.getCarName());
            assertEquals(0, currentCar.getCurrentDistance());
        }

    }

}