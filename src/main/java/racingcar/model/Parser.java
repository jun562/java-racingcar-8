package racingcar.model;

import static racingcar.constant.ErrorMessage.ERROR_INVALID_ATTEMPT_COUNT;

import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class Parser {
    public Parser() {

    }

    public List<String> parseCarNames(String input) {
        return trimCarNames(splitCarNames(input));
    }

    public int parseAttemptCount(String input) {
        try {
            return Integer.parseInt(input.trim());
        } catch (NumberFormatException e) {
            throw new IllegalArgumentException(ERROR_INVALID_ATTEMPT_COUNT);
        }
    }

    private List<String> splitCarNames(String input) {
        return List.of(input.split(","));
    }

    private List<String> trimCarNames(List<String> carNames) {
        Stream<String> carNamesStream = carNames.stream();
        Stream<String> trimmedCarNamesStream = carNamesStream.map(String::trim);
        return trimmedCarNamesStream.collect(Collectors.toList());
    }


}
