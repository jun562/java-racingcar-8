package racingcar.model;

import static org.junit.jupiter.api.Assertions.assertDoesNotThrow;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

import java.util.List;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class ValidatorTest {
    private Validator validator;

    @BeforeEach
    void setValidator() {
        validator = new Validator();
    }

    //    성공 케이스
    @Test
    @DisplayName("입력된_자동차가_2대인 경우")
    void validateCarNumbersWhenTwo() {
        List<String> carNames = List.of("car", "wooni");
        assertDoesNotThrow(() -> {
            validator.validate(carNames);
        });
    }

    @Test
    @DisplayName("입력된_자동차가_3대인_경우")
    void validateCarNumbersWhenThree() {
        List<String> carNames = List.of("car", "wooni", "pobi");
        assertDoesNotThrow(() -> {
            validator.validate(carNames);
        });
    }

    //    예외 케이스
    @Test
    @DisplayName("입력된_자동차가_1대인_경우")
    void validateCarNumbersWhenOne() {
        List<String> carNames = List.of("car");
        String errorMessage = "경주할 자동차는 2대 이상이어야 합니다.";

        IllegalArgumentException exception = assertThrows(IllegalArgumentException.class, () -> {
            validator.validate(carNames);
        });

        assertEquals(errorMessage, exception.getMessage());
    }

    @Test
    @DisplayName("입력된_자동차가_없는_경우")
    void validateCarNumbersWhenZero() {
        List<String> carNames = List.of("");
        String errorMessage = "경주할 자동차는 2대 이상이어야 합니다.";

        IllegalArgumentException exception = assertThrows(IllegalArgumentException.class, () -> {
            validator.validate(carNames);
        });

        assertEquals(errorMessage, exception.getMessage());
    }


}