package racingcar.model;

import static racingcar.constant.ErrorMessage.ERROR_CAR_NAME_DUPLICATED;
import static racingcar.constant.ErrorMessage.ERROR_CAR_NAME_FORMAT;
import static racingcar.constant.ErrorMessage.ERROR_CAR_NAME_LENGTH;
import static racingcar.constant.ErrorMessage.ERROR_CAR_NAME_WITH_EMPTY;
import static racingcar.constant.ErrorMessage.ERROR_INVALID_CAR_COUNT;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class Validator {
    public Validator() {

    }

    private static final int MIN_CAR_COUNT = 2;
    private static final int MAX_CAR_NAME_LENGTH = 5;
    private static final String CAR_NAME_REGEX = "^[a-zA-Z0-9_가-힣]+$";

    public void validate(List<String> carNames) {
        Set<String> carNamesSet = new HashSet<>(carNames);
        if (carNames.size() < MIN_CAR_COUNT) {
            throw new IllegalArgumentException(ERROR_INVALID_CAR_COUNT);
        }
        if (carNamesSet.size() != carNames.size()) {
            throw new IllegalArgumentException(ERROR_CAR_NAME_DUPLICATED);
        }
        if (carNames.contains("")) {
            throw new IllegalArgumentException(ERROR_CAR_NAME_WITH_EMPTY);
        }
        if (carNames.stream().mapToInt(String::length).anyMatch(length -> length > 5)) {
            throw new IllegalArgumentException(ERROR_CAR_NAME_LENGTH);
        }
        if (carNames.stream().anyMatch(carName -> !carName.matches(CAR_NAME_REGEX))) {
            throw new IllegalArgumentException(ERROR_CAR_NAME_FORMAT);
        }
    }
}
