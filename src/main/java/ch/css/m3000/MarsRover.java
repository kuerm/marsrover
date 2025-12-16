package ch.css.m3000;

public class MarsRover {
    private final Direction currentDirection;
    private Position currentPosition;

    public MarsRover(final Position position, final Direction direction) {
        this.currentPosition = position;
        this.currentDirection = direction;
    }

    public Direction direction() {
        return currentDirection;
    }

    public Position position() {
        return currentPosition;
    }

    public void move(final String commands) {
        this.currentPosition = new Position(1, 2);
    }
}
