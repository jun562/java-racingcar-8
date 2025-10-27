package racingcar.model.validation;

import static racingcar.constant.ErrorMessage.ERROR_INVALID_ATTEMPT_COUNT;

public class AttemptCountValidator {
    private static final int MIN_ATTEMPT_COUNT = 1;

    public AttemptCountValidator() {

    }

    public void validate(int attemptCount) {
        if (attemptCount < MIN_ATTEMPT_COUNT) {
            throw new IllegalArgumentException(ERROR_INVALID_ATTEMPT_COUNT);
        }
    }

}
