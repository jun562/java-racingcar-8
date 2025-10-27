package racingcar.model;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static racingcar.constant.ErrorMessage.ERROR_INVALID_ATTEMPT_COUNT;

import java.util.List;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;
import org.junit.jupiter.params.provider.ValueSource;

class ParserTest {
    private Parser parser;

    @BeforeEach
    void setParser() {
        parser = new Parser();
    }

    @Test
    @DisplayName("쉼표를_통한_자동차_이름_분리_테스트")
    void parseCarNames() {
        String input = "car,woni,jun,woowa";
        List<String> result = parser.parseCarNames(input);
        assertEquals(result, List.of("car", "woni", "jun", "woowa"));
    }

    @Test
    @DisplayName("자동차_이름_끝에_공백_존재하는_경우")
    void parseCarNamesWithWhiteSpace() {
        String input = " car, woni ,jun ,woowa";
        List<String> result = parser.parseCarNames(input);
        assertEquals(result, List.of("car", "woni", "jun", "woowa"));
    }

    @Test
    @DisplayName("자동차_이름이_하나일_경우")
    void parseCarNameSingle() {
        String input = "car";
        List<String> result = parser.parseCarNames(input);
        assertEquals(result, List.of("car"));
    }

    @Test
    @DisplayName("자동차_이름이_없는_경우")
    void parseCarNamesWithEmptyItem() {
        String input = "car,,wooni";
        List<String> result = parser.parseCarNames(input);
        assertEquals(result, List.of("car", "", "wooni"));
    }

    @Test
    @DisplayName("자동차_입력이_쉼표로_끝나는_경우")
    void parseCarNamesEndsWithComma() {
        String input = "car,woni,";
        List<String> result = parser.parseCarNames(input);
        assertEquals(result, List.of("car", "woni"));
    }

    @Test
    @DisplayName("자동차_입력이_빈_문자열인_경우")
    void parseCarNamesWithEmpty() {
        String input = "";
        List<String> result = parser.parseCarNames(input);
        assertEquals(result, List.of(""));
    }

    @ParameterizedTest
    @CsvSource({
            "5, 5",
            "0, 0",
            "-3, -3"
    })
    @DisplayName("시도할_횟수가_정수인_경우")
    void parseAttemptCountWhenInteger(String input, int expected) {
        int result = parser.parseAttemptCount(input);

        assertEquals(result, expected);
    }

    @Test
    @DisplayName("시도할_횟수가_공백을_포함한_정수인_경우")
    void parseAttemptCountWhenIntegerWithWhiteSpace() {
        String input = "5 ";

        int result = parser.parseAttemptCount(input);

        assertEquals(result, 5);
    }

    @ParameterizedTest
    @ValueSource(strings = {
            "/",
            "1.1",
            "",
            "-1.1"
    })
    @DisplayName("시도할_횟수가_정수가_아닌_경우")
    void parseAttemptCountWhenNotInteger(String input) {
        IllegalArgumentException exception = assertThrows(IllegalArgumentException.class, () -> {
            parser.parseAttemptCount(input);
        });

        assertEquals(ERROR_INVALID_ATTEMPT_COUNT, exception.getMessage());
    }
}