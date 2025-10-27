package racingcar.model;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class CarTest {
    @Test
    @DisplayName("자동차_객체_생성_확인")
    void getObject() {
        Car car = new Car("car");

        assertEquals("car", car.getCarName());
        assertEquals(0, car.getCurrentDistance());
    }
}