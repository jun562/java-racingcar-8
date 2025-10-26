package racingcar.model;

import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class Parser {
    public Parser() {

    }

    public List<String> parse(String input) {
        List<String> carNames = List.of(input.split(","));

        Stream<String> carNamesStream = carNames.stream();
        Stream<String> trimmedCarNamesStream = carNamesStream.map(String::trim);

        return trimmedCarNamesStream.collect(Collectors.toList());
    }
}
