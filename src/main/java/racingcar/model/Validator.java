package racingcar.model;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class Validator {
    public Validator() {

    }

    private static final int MIN_CAR_COUNT = 2;
    private static final int MAX_CAR_NAME_LENGTH = 5;
    private static final String ERROR_MESSAGE = "경주할 자동차는 2대 이상이어야 합니다.";
    private static final String ERROR_MESSAGE2 = "경주할 자동차의 이름은 중복되지 않아야 합니다.";
    private static final String ERROR_MESSAGE3 = "자동차의 이름은 비어있지 않아야 합니다.";
    private static final String ERROR_MESSAGE4 = "자동차의 이름은 5글자 이하여야 합니다.";

    public void validate(List<String> carNames) {
        Set<String> carNamesSet = new HashSet<>(carNames);
        if (carNames.size() < MIN_CAR_COUNT) {
            throw new IllegalArgumentException(ERROR_MESSAGE);
        }
        if (carNamesSet.size() != carNames.size()) {
            throw new IllegalArgumentException(ERROR_MESSAGE2);
        }
        if (carNames.contains("")) {
            throw new IllegalArgumentException(ERROR_MESSAGE3);
        }
        if (carNames.stream().mapToInt(String::length).anyMatch(length -> length > 5)) {
            throw new IllegalArgumentException(ERROR_MESSAGE4);
        }

    }

}
