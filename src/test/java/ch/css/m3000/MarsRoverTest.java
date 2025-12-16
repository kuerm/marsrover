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
            "1, 1, NORTH, f, 1, 2",
            "1, 1, NORTH, ff, 1, 3"
    })
    void move(int startingX, int startingY, Direction startingDirection, String commands, int expectingPositionX, int expectingPositionY) {
        MarsRover sut = new MarsRover(new Position(startingX, startingY), startingDirection);

        sut.move(commands);

        Position actualPosition = sut.position();
        assertThat(actualPosition).isEqualTo(new Position(expectingPositionX, expectingPositionY));

    }
}
