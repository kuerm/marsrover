package ch.css.m3000;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

import static org.assertj.core.api.Assertions.assertThat;

class MarsRoverTest {
    @Test
    void initialStartingPosition() {
        MarsRover sut = new MarsRover(new Position(2, 3), Direction.NORTH);

        Direction actualDirection = sut.direction();
        Position actualPosition = sut.position();

        assertThat(actualDirection).isEqualTo(Direction.NORTH);
        assertThat(actualPosition).isEqualTo(new Position(2, 3));
    }

    @Test
    void anotherInitialStartingPosition() {
        MarsRover sut = new MarsRover(new Position(4, 5), Direction.WEST);

        Direction actualDirection = sut.direction();
        Position actualPosition = sut.position();

        assertThat(actualDirection).isEqualTo(Direction.WEST);
        assertThat(actualPosition).isEqualTo(new Position(4, 5));
    }

    @ParameterizedTest
    @CsvSource({
            "1, 1, f, 1, 2",
            "1, 1, ff, 1, 3",
            "1, 1, fff, 1, 4",
            "1, 1, b, 1, 0",
            "3, 6, bbbf, 3, 4",
    })
    void move(int startingX, int startingY, String commands, int expectingPositionX, int expectingPositionY) {
        MarsRover sut = new MarsRover(new Position(startingX, startingY), Direction.NORTH);

        MarsRover actual = sut.move(commands);

        Position actualPosition = actual.position();
        assertThat(actualPosition).isEqualTo(new Position(expectingPositionX, expectingPositionY));
    }

    @ParameterizedTest
    @CsvSource({
            "NORTH, l, WEST",
            "NORTH, ll, SOUTH",
    })
    void turn(Direction startingDirection, String commands, Direction expectedDirection) {
        MarsRover sut = new MarsRover(new Position(5, 5), startingDirection);

        MarsRover actual = sut.turn(commands);

        Direction actualDirection = actual.direction();
        assertThat(actualDirection).isEqualTo(expectedDirection);

    }
}
