package racingcar.model;

import static org.junit.jupiter.api.Assertions.assertDoesNotThrow;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static racingcar.constant.ErrorMessage.ERROR_CAR_NAME_DUPLICATED;
import static racingcar.constant.ErrorMessage.ERROR_CAR_NAME_FORMAT;
import static racingcar.constant.ErrorMessage.ERROR_CAR_NAME_LENGTH;
import static racingcar.constant.ErrorMessage.ERROR_CAR_NAME_WITH_EMPTY;
import static racingcar.constant.ErrorMessage.ERROR_INVALID_CAR_COUNT;

import java.util.List;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class CarNameValidatorTest {
    private CarNameValidator carNameValidator;

    @BeforeEach
    void setValidator() {
        carNameValidator = new CarNameValidator();
    }

    //    성공 케이스
    @Test
    @DisplayName("입력된_자동차가_2대인 경우")
    void validateCarCountWhenTwo() {
        List<String> carNames = List.of("car", "wooni");

        assertDoesNotThrow(() -> {
            carNameValidator.validate(carNames);
        });
    }

    @Test
    @DisplayName("입력된_자동차가_3대인_경우")
    void validateCarCountWhenThree() {
        List<String> carNames = List.of("car", "wooni", "pobi");

        assertDoesNotThrow(() -> {
            carNameValidator.validate(carNames);
        });
    }

    @Test
    @DisplayName("자동차의_이름이_모두_다른_경우")
    void validateNamesWhenUnique() {
        List<String> carNames = List.of("pobi", "car", "wooni");

        assertDoesNotThrow(() -> {
            carNameValidator.validate(carNames);
        });
    }

    @Test
    @DisplayName("자동차의_이름이_5글자_이하인_경우")
    void validateNameLengthWhenLessThanFive() {
        List<String> carNames = List.of("c", "ca", "car", "car1", "car12");

        assertDoesNotThrow(() -> {
            carNameValidator.validate(carNames);
        });
    }

    @Test
    @DisplayName("영문자_한글_숫자_밑줄_조합인_자동차인_경우")
    void validateNameWithWordCharacter() {
        List<String> carNames = List.of("car", "c1234", "우아한카", "car_1", "포bi", "좋은_차");

        assertDoesNotThrow(() -> {
            carNameValidator.validate(carNames);
        });
    }

    //    예외 케이스
    @Test
    @DisplayName("입력된_자동차가_1대인_경우")
    void validateCarNumbersWhenOne() {
        List<String> carNames = List.of("car");

        IllegalArgumentException exception = assertThrows(IllegalArgumentException.class, () -> {
            carNameValidator.validate(carNames);
        });

        assertEquals(ERROR_INVALID_CAR_COUNT, exception.getMessage());
    }

    @Test
    @DisplayName("입력된_자동차가_없는_경우")
    void validateCarNumbersWhenZero() {
        List<String> carNames = List.of("");

        IllegalArgumentException exception = assertThrows(IllegalArgumentException.class, () -> {
            carNameValidator.validate(carNames);
        });

        assertEquals(ERROR_INVALID_CAR_COUNT, exception.getMessage());
    }

    @Test
    @DisplayName("중복된_이름의_자동차가_존재하는_경우")
    void validateNamesWhenDuplicated() {
        List<String> carNames = List.of("pobi", "pobi", "wooni");
        String errorMessage = "경주할 자동차의 이름은 중복되지 않아야 합니다.";

        IllegalArgumentException exception = assertThrows(IllegalArgumentException.class, () -> {
            carNameValidator.validate(carNames);
        });

        assertEquals(ERROR_CAR_NAME_DUPLICATED, exception.getMessage());

    }

    @Test
    @DisplayName("자동차의_이름이_빈_문자열인_경우")
    void validateNamesWithEmpty() {
        List<String> carNames = List.of("pobi", "", "wooni");

        IllegalArgumentException exception = assertThrows(IllegalArgumentException.class, () -> {
            carNameValidator.validate(carNames);
        });

        assertEquals(ERROR_CAR_NAME_WITH_EMPTY, exception.getMessage());
    }

    @Test
    @DisplayName("자동차의_이름이_5글자_초과인_경우")
    void validateNameLengthWhenExceedFive() {
        List<String> carNames = List.of("car123", "car");

        IllegalArgumentException exception = assertThrows(IllegalArgumentException.class, () -> {
            carNameValidator.validate(carNames);
        });

        assertEquals(ERROR_CAR_NAME_LENGTH, exception.getMessage());
    }

    @Test
    @DisplayName("자동차_이름에_공백이_포함된_경우")
    void validateNameWithWhiteSpace() {
        List<String> carNames = List.of("car 1", "car 2", "car 3");

        IllegalArgumentException exception = assertThrows(IllegalArgumentException.class, () -> {
            carNameValidator.validate(carNames);
        });

        assertEquals(ERROR_CAR_NAME_FORMAT, exception.getMessage());
    }

    //    비단어 문자 : [^a-zA-Z0-9_가-힣]
    @Test
    @DisplayName("자동차_이름에_비단어_문자가_포함된_경우")
    void validateNameWithNonWordCharacter() {
        List<String> carNames = List.of("c.a.r", "c+a*r", "c!a&r");

        IllegalArgumentException exception = assertThrows(IllegalArgumentException.class, () -> {
            carNameValidator.validate(carNames);
        });

        assertEquals(ERROR_CAR_NAME_FORMAT, exception.getMessage());
    }
}