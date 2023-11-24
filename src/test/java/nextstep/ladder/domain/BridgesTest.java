package nextstep.ladder.domain;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.List;

import static nextstep.ladder.domain.Bridges.*;
import static nextstep.ladder.domain.Ladder.*;
import static nextstep.ladder.exception.ExceptionMessage.*;
import static org.assertj.core.api.Assertions.*;

public class BridgesTest {

    @DisplayName("사다리의 x축인 다리가 연속으로 존재(true)하면 예외를 발생시킨다.")
    @Test
    void createBridgesWhenTruInARow() {
        assertThatThrownBy(() -> new Bridges(List.of(true, true, false))).isInstanceOf(IllegalArgumentException.class)
            .hasMessage(NOT_TRUE_STRAIGHT.message());
    }

    @DisplayName("Bridges의 boolean값을 사다리의 다리모양(String)으로 변환해 반환한다.")
    @Test
    void toBooleans() {
        // given
        Bridges bridges = new Bridges(List.of(true, false, true));

        // when
        String stringBridges = bridges.toString();

        // then
        assertThat(stringBridges).isEqualTo(TRUE_BRIDGE + LADDER_POLE + FALSE_BRIDGE + LADDER_POLE + TRUE_BRIDGE);
    }
}
