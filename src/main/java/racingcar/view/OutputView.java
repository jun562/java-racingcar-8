package racingcar.view;

import java.util.List;
import racingcar.model.Car;

public class OutputView {
    private OutputView() {

    }

    public static void printResultHeader() {
        System.out.println("\n실행 결과");
    }

    public static void printRoundResult(List<Car> cars) {
        for (Car car : cars) {
            String distanceDash = "-".repeat(car.getCurrentDistance());

            System.out.printf("%s : %s\n", car.getCarName(), distanceDash);
        }
        System.out.println();
    }

    public static void printWinners(List<String> winners) {
        String winnerNames = String.join(", ", winners);
        System.out.printf("최종 우승자 : %s\n", winnerNames);
    }
}
