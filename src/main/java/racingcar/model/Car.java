package racingcar.model;

public class Car {
    private static final int MOVE_THRESHOLD = 4;

    private final String name;
    private int distance;

    public Car(String name) {
        this.name = name;
        this.distance = 0;
    }

    public void move(int number) {
        if (number >= MOVE_THRESHOLD) {
            this.distance++;
        }
    }

    public String getCarName() {
        return this.name;
    }

    public int getCurrentDistance() {
        return this.distance;
    }
}
