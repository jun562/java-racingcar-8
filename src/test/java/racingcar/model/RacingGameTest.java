package racingcar.model;

import static org.assertj.core.api.Assertions.assertThat;
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

    @Test
    @DisplayName("단독_우승자_선정")
    void findSingleWinner() {
        RacingGame game = new RacingGame(List.of("pobi", "car", "jun"), 1);
        List<Car> cars = game.getCars();

        cars.get(0).move(4); // pobi
        cars.get(1).move(3); // car
        cars.get(2).move(3); // jun

        List<String> winners = game.findWinners();

        assertThat(winners).containsOnly("pobi");
    }

    @Test
    @DisplayName("공동_우승자_선정")
    void findMultipleWinners() {
        RacingGame game = new RacingGame(List.of("pobi", "car", "jun"), 1);
        List<Car> cars = game.getCars();

        cars.get(0).move(4); // pobi
        cars.get(1).move(4); // car
        cars.get(2).move(3); // jun

        List<String> winners = game.findWinners();

        assertThat(winners).containsOnly("pobi", "car");
    }

}