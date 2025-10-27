package racingcar.model;

public class Car {
    private final String name;
    private int distance;

    public Car(String name) {
        this.name = name;
        this.distance = 0;
    }

    public String getCarName() {
        return name;
    }

    public int getCurrentDistance() {
        return distance;
    }
}
