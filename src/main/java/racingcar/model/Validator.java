package racingcar.model;

import java.util.List;

public class Validator {
    public Validator() {

    }

    private static final int MIN_CAR_COUNT = 2;
    private static final String ERROR_MESSAGE = "경주할 자동차는 2대 이상이어야 합니다.";

    public void validate(List<String> carNames) {
        if (carNames.size() < MIN_CAR_COUNT) {
            throw new IllegalArgumentException(ERROR_MESSAGE);
        }
    }

}
