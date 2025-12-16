package ch.css.m3000;

public enum Direction {
    WEST, NORTH, SOUTH, EAST;

    public Direction turnLeft() {
        return switch (this) {
            case NORTH -> WEST;
            case WEST -> SOUTH;
            case SOUTH -> EAST;
            case EAST -> NORTH;
        };

    }
}
