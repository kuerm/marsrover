package ch.css.m3000;

public record MarsRover(Position position, Direction direction) {
    private static final char FORWARD_STEP = 'f';

    private static boolean isForwardCommand(final int c) {
        return c == FORWARD_STEP;
    }

    public MarsRover move(final String commands) {
        var position1 = this.position;
        for (var command : commands.chars().toArray()) {
            int step = isForwardCommand(command) ? 1 : -1;
            position1 = new Position(position1.x(), position1.y() + step);
        }

        return new MarsRover(position1, direction);

    }
}
