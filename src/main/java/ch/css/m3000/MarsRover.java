package ch.css.m3000;

public class MarsRover {
    private final Direction currentDirection;
    private final Position currentPosition;

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

    public MarsRover move(final String commands) {
        var position1 = this.currentPosition;
        for (var c : commands.chars().toArray()) {
            int step = c == 'f' ? 1 : -1;
            position1 = new Position(position1.x(), position1.y() + step);
        }

        return new MarsRover(position1, currentDirection);

    }
}
