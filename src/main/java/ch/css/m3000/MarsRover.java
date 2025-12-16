package ch.css.m3000;

public class MarsRover {
    private final Position currentPosition;
    private final Direction currentDirection;

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
}
