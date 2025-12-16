package ch.css.m3000;

import org.junit.jupiter.api.Test;

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

    @Test
    void moveWhenForwardThenRoverIsOnePositionAhead() {
        MarsRover sut = new MarsRover(new Position(1, 1), Direction.NORTH);

        sut.move("f");

        Position actualPosition = sut.position();
        assertThat(actualPosition).isEqualTo(new Position(1, 2));
    }
}
