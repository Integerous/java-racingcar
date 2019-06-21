package step4.domain;

import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

public class CarTest {

    private Car car = new Car("testCar");

    @Test
    void 자동차는_이름으로_생성된다() {
        assertThat(car).isNotNull();
    }

    @Test
    void 생성된_자동차의_최초위치는_0이다() {
        assertThat(car.isInitialPositionZero(car)).isTrue();
    }
}
