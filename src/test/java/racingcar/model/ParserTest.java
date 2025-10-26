package racingcar.model;

import static org.junit.jupiter.api.Assertions.assertEquals;

import java.util.List;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

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
        List<String> result = parser.parse(input);
        assertEquals(result, List.of("car", "woni", "jun", "woowa"));
    }

    @Test
    @DisplayName("자동차_이름_끝에_공백_존재하는_경우")
    void parseCarNamesWithWhiteSpace() {
        String input = " car, woni ,jun ,woowa";
        List<String> result = parser.parse(input);
        assertEquals(result, List.of("car", "woni", "jun", "woowa"));
    }

    @Test
    @DisplayName("자동차_이름이_하나일_경우")
    void parseCarNameSingle() {
        String input = "car";
        List<String> result = parser.parse(input);
        assertEquals(result, List.of("car"));
    }

    @Test
    @DisplayName("자동차_이름이_없는_경우")
    void parseCarNamesWithEmptyItem() {
        String input = "car,,wooni";
        List<String> result = parser.parse(input);
        assertEquals(result, List.of("car", "", "wooni"));
    }

    @Test
    @DisplayName("입력이_쉼표로_끝나는_경우")
    void parseCarNamesEndsWithComma() {
        String input = "car,woni,";
        List<String> result = parser.parse(input);
        assertEquals(result, List.of("car", "woni"));
    }

    @Test
    @DisplayName("입력이_빈_문자열인_경우")
    void parseCarNamesWithEmpty() {
        String input = "";
        List<String> result = parser.parse(input);
        assertEquals(result, List.of(""));
    }
}