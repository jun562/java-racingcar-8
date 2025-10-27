package racingcar.model;

import static org.junit.jupiter.api.Assertions.assertDoesNotThrow;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static racingcar.constant.ErrorMessage.ERROR_INVALID_ATTEMPT_COUNT;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import racingcar.model.validation.AttemptCountValidator;

class AttemptCountValidatorTest {
    private AttemptCountValidator attemptCountValidator;

    @BeforeEach
    void setValidator() {
        attemptCountValidator = new AttemptCountValidator();
    }

    //    성공 케이스
    @Test
    @DisplayName("입력된_횟수가_양의_정수인_경우")
    void validateWhenPositiveInteger() {
        int attemptCount = 3;

        assertDoesNotThrow(() -> {
            attemptCountValidator.validate(attemptCount);
        });
    }

    //    예외 케이스
    @Test
    @DisplayName("입력된_횟수가_0인_경우")
    void validateWhenZero() {
        int attemptCount = 0;

        IllegalArgumentException exception = assertThrows(IllegalArgumentException.class, () -> {
            attemptCountValidator.validate(attemptCount);
        });

        assertEquals(ERROR_INVALID_ATTEMPT_COUNT, exception.getMessage());
    }

    @Test
    @DisplayName("입력된_횟수가_음의_정수인_경우")
    void validateWhenNegativeInteger() {
        int attemptCount = -1;

        IllegalArgumentException exception = assertThrows(IllegalArgumentException.class, () -> {
            attemptCountValidator.validate(attemptCount);
        });

        assertEquals(ERROR_INVALID_ATTEMPT_COUNT, exception.getMessage());
    }
}