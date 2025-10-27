package racingcar.view;

import java.util.List;
import racingcar.model.Car;

public class Output {
    private Output() {

    }

    public static void printResultHeader() {
        System.out.println("\n실행 결과");
    }

    public static void printOneTime(List<Car> cars) {
        for (Car car : cars) {
            String name = car.getCarName();
            int distance = car.getCurrentDistance();

            String distanceDash = "-".repeat(distance);

            System.out.printf("%s : %s\n", name, distanceDash);
        }
        System.out.println();
    }

}
