package racingcar.model;

import java.util.List;

public class Parser {
    public Parser() {

    }

    public List<String> parse(String input) {
        List<String> carNames = List.of(input.split(","));
        return carNames;
    }
}
