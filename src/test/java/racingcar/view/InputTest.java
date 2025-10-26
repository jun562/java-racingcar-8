package racingcar.view;

import static camp.nextstep.edu.missionutils.test.Assertions.assertSimpleTest;
import static org.assertj.core.api.Assertions.assertThat;


import camp.nextstep.edu.missionutils.test.NsTest;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class InputTest extends NsTest {
    @Test
    @DisplayName("자동차_이름_입력_테스트")
    void input_car_names() {
        assertSimpleTest(() -> {
            run("pobi,woni,jun");
            String result = Input.readCarNames();
            assertThat(result).isEqualTo("pobi,woni,jun");
        });
    }

    @Test
    @DisplayName("시도할_횟수_입력_테스트")
    void input_attempt_count() {
        assertSimpleTest(() -> {
            run("5");
            String result = Input.readAttemptCount();
            assertThat(result).isEqualTo("5");
        });
    }

    /**
     * 입력 검증 만을 위해 비워둠
     */
    @Override
    protected void runMain(){

    }

}