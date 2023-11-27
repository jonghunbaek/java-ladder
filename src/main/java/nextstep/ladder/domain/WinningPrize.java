package nextstep.ladder.domain;

import nextstep.ladder.exception.ExceptionMessage;

import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class WinningPrize {

    private final Map<Position, String> winningPrize;

    public WinningPrize(List<String> prizes, int height) {
        this.winningPrize = IntStream.range(0, prizes.size())
            .boxed()
            .collect(Collectors.toMap(
                i -> Position.of(i, height),
                prizes::get,
                (oldVal, newVal) -> newVal,
                LinkedHashMap::new
            ));
    }

    public String findWinningPrizeBy(Player player) {
        Position position = winningPrize.keySet().stream()
            .filter(player::isEqualCoordinate)
            .findFirst()
            .orElseThrow(() -> new IllegalArgumentException(ExceptionMessage.NOT_EXIST_PLAYER.message()));

        return winningPrize.get(position);
    }

    @Override
    public String toString() {
        return winningPrize.values().stream()
            .map(val ->String.format("%-6s", val))
            .collect(Collectors.joining());
    }
}