package racingcar;

import static camp.nextstep.edu.missionutils.test.Assertions.assertRandomNumberInRangeTest;
import static camp.nextstep.edu.missionutils.test.Assertions.assertSimpleTest;
import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

import camp.nextstep.edu.missionutils.test.NsTest;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

class ApplicationTest extends NsTest {
    private static final int MOVING_FORWARD = 4;
    private static final int STOP = 3;

    @Test
    void 기능_테스트() {
        assertRandomNumberInRangeTest(
                () -> {
                    run("pobi,woni", "1");
                    assertThat(output()).contains("pobi : -", "woni : ", "최종 우승자 : pobi");
                },
                MOVING_FORWARD, STOP
        );
    }

    @Test
    void 공동_우승자인_경우() {
        assertRandomNumberInRangeTest(
                () -> {
                    run("pobi,woni", "2");
                    assertThat(output()).contains("pobi : -", "woni : -", "최종 우승자 : pobi, woni");
                },
                MOVING_FORWARD, STOP,
                STOP, MOVING_FORWARD
        );
    }

    @Test
    void 예외_테스트() {
        assertSimpleTest(() ->
                assertThatThrownBy(() -> runException("pobi,javaji", "1"))
                        .isInstanceOf(IllegalArgumentException.class)
        );
    }

    @ParameterizedTest
    @CsvSource({
            "'pobi', '1'", // 자동차 1대 이하인 경우
            "'pobi,pobi', '1'", // 자동차 이름이 중복되는 경우
            "'pobi,,java', '1'", // 자동차 이름이 빈 문자열인 경우
            "'pobi,javaj2', '1'", // 자동차의 이름이 5글자 초과하는 경우
            "'pobi*,java', '1'", // 자동차 이름에 비단어 문자가 포함된 경우
            "'pobi,java', '1.0'", // 시도할 횟수가 양의 정수가 아닌 경우 (실수)
            "'pobi,java', 'n'", // 시도할 횟수가 양의 정수가 아닌 경우 (숫자가 아닌 문자)
            "'pobi,java', '0'", // 시도할 횟수가 양의 정수가 아닌 경우 (0)
            "'pobi,java', '-1'", // 시도할 횟수가 양의 정수가 아닌 경우 (음수)
    })
    void 다양한_입력_예외_테스트(String carNames, String attemptCount) {
        assertSimpleTest(() ->
                assertThatThrownBy(() -> runException(carNames, attemptCount))
                        .isInstanceOf(IllegalArgumentException.class)
        );
    }

    @Override
    public void runMain() {
        Application.main(new String[]{});
    }
}
