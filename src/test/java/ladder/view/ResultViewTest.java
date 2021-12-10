package ladder.view;

import ladder.domain.ladder.Height;
import ladder.domain.ladder.Ladder;
import ladder.domain.user.Players;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.Arrays;

class ResultViewTest {

    @Test
    @DisplayName("사다리 출력 그림 보기 위해 작성")
    void printResult() {
        Players players = new Players(Arrays.asList("pobi", "honux", "crong", "jk", "Q"));
        Ladder ladder = Ladder.createLadder(players, new Height(5));
        ResultView.printResult(players.getPlayers(), ladder.getLines());
    }

}