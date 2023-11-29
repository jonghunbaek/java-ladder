package nextstep.ladder.domain;

public class Point {

    private int x;
    private Direction direction;

    public Point(int x, Direction direction) {
        this.x = x;
        this.direction = direction;
    }

    public int move(int point) {
        return direction.nextPoint(point);
    }
}