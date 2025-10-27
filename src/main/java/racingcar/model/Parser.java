package racingcar.model;

import static racingcar.constant.ErrorMessage.ERROR_INVALID_ATTEMPT_COUNT;

import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class Parser {
    private static final String CAR_NAME_DELIMITER = ",";

    public Parser() {

    }

    public List<String> parseCarNames(String input) {
        return trimCarNames(splitCarNames(input));
    }

    public int parseAttemptCount(String input) {
        try {
            return Integer.parseInt(trimAttemptCount(input));
        } catch (NumberFormatException e) {
            throw new IllegalArgumentException(ERROR_INVALID_ATTEMPT_COUNT);
        }
    }

    private List<String> splitCarNames(String input) {
        return List.of(input.split(CAR_NAME_DELIMITER));
    }

    private List<String> trimCarNames(List<String> carNames) {
        Stream<String> carNamesStream = carNames.stream();
        Stream<String> trimmedCarNamesStream = carNamesStream.map(String::trim);
        return trimmedCarNamesStream.collect(Collectors.toList());
    }

    private String trimAttemptCount(String input) {
        return input.trim();
    }

}
