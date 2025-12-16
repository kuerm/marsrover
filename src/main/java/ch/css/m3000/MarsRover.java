package ch.css.m3000;

public record MarsRover(Position position, Direction direction) {
    private static final char FORWARD_STEP = 'f';

    private static boolean isForwardCommand(final int c) {
        return c == FORWARD_STEP;
    }

    public MarsRover move(final String commands) {
        var newPosition = this.position;
        for (var command : commands.chars().toArray()) {
            int step = isForwardCommand(command) ? 1 : -1;
            newPosition = new Position(newPosition.x(), newPosition.y() + step);
        }

        return new MarsRover(newPosition, direction);
    }

    public MarsRover turn(final String commands) {
        var currentDirection = direction;
        for (var command : commands.chars().toArray()) {
            currentDirection = currentDirection.turnLeft();
        }
        return new MarsRover(this.position, currentDirection);
    }
}
