package racingcar.model;

import static org.junit.jupiter.api.Assertions.*;

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
        assertEquals(result, List.of("car","woni","jun","woowa"));
    }

}