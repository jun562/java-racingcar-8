package racingcar.model;

import static racingcar.constant.ErrorMessage.ERROR_CAR_NAME_DUPLICATED;
import static racingcar.constant.ErrorMessage.ERROR_CAR_NAME_FORMAT;
import static racingcar.constant.ErrorMessage.ERROR_CAR_NAME_LENGTH;
import static racingcar.constant.ErrorMessage.ERROR_CAR_NAME_WITH_EMPTY;
import static racingcar.constant.ErrorMessage.ERROR_INVALID_CAR_COUNT;

import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.stream.IntStream;
import java.util.stream.Stream;

public class CarNameValidator {
    public CarNameValidator() {

    }

    private static final int MIN_CAR_COUNT = 2;
    private static final int MAX_CAR_NAME_LENGTH = 5;
    private static final String CAR_NAME_REGEX = "^[a-zA-Z0-9_가-힣]+$";

    public void validate(List<String> carNames) {
        validateCount(carNames);
        validateDuplicated(carNames);
        validateEmpty(carNames);
        validateLength(carNames);
        validateFormat(carNames);
    }

    private void validateCount(List<String> carNames) {
        if (carNames.size() < MIN_CAR_COUNT) {
            throw new IllegalArgumentException(ERROR_INVALID_CAR_COUNT);
        }
    }

    private void validateDuplicated(List<String> carNames) {
        Set<String> carNamesSet = new HashSet<>(carNames);

        if (carNamesSet.size() != carNames.size()) {
            throw new IllegalArgumentException(ERROR_CAR_NAME_DUPLICATED);
        }
    }

    private void validateEmpty(List<String> carNames) {
        if (carNames.contains("")) {
            throw new IllegalArgumentException(ERROR_CAR_NAME_WITH_EMPTY);
        }
    }

    private void validateLength(List<String> carNames) {
        Stream<String> carNamesStream = carNames.stream();
        IntStream carNamesLengthStream = carNamesStream.mapToInt(String::length);

        if (carNamesLengthStream.anyMatch(length -> length > MAX_CAR_NAME_LENGTH)) {
            throw new IllegalArgumentException(ERROR_CAR_NAME_LENGTH);
        }
    }

    private void validateFormat(List<String> carNames) {
        Stream<String> carNamesStream = carNames.stream();

        if (carNamesStream.anyMatch(carName -> !carName.matches(CAR_NAME_REGEX))) {
            throw new IllegalArgumentException(ERROR_CAR_NAME_FORMAT);
        }
    }
}
