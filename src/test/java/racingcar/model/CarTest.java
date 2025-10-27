package racingcar.model;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

class CarTest {
    private Car car;

    @BeforeEach
    void setCar() {
        car = new Car("car");
    }

    @Test
    @DisplayName("자동차_객체_생성_확인")
    void getObject() {
        assertEquals("car", car.getCarName());
        assertEquals(0, car.getCurrentDistance());
    }


    @ParameterizedTest
    @ValueSource(ints = {4, 5, 6, 7, 8, 9})
    @DisplayName("무작위_값이_4이상인_경우_전진")
    void moveCar(int number) {
        car.move(number);

        assertEquals(1, car.getCurrentDistance());
    }

    @ParameterizedTest
    @ValueSource(ints = {0, 1, 2, 3})
    @DisplayName("무작위_값이_4미만인_경우_멈춤")
    void stopCar(int number) {
        car.move(number);

        assertEquals(0, car.getCurrentDistance());
    }
}