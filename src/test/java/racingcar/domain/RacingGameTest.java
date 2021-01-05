package racingcar.domain;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;
import racingcar.domain.RacingGame;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

import static org.assertj.core.api.Assertions.*;

public class RacingGameTest {

    private RacingGame racingGame;
    private static final int SPEED = 4;

    @BeforeEach
    void setUp() {
        racingGame = new RacingGame("d,b,v");
    }

    @Test
    void splitTest(){
        racingGame.racing();
        List<CarInfo> carInfos = racingGame.getStatus();
        List<String> carNames = carInfos.stream().map(CarInfo::getName).collect(Collectors.toList());
        assertThat(carNames).containsExactly("d","b","v");
    }

    @Test
    void singleWinnerTest() {
        Car car1 = new Car("yell");
        Car car2 = new Car("dino");
        Car car3 = new Car("pobi");

        car1.nextStep(SPEED);
        racingGame = new RacingGame(Arrays.asList(car1, car2, car3));

        assertThat(racingGame.findWinners()).containsExactly("yell");
    }

    @Test
    void multiWinnersTest(){
        Car car1 = new Car("yell");
        Car car2 = new Car("dino");
        Car car3 = new Car("pobi");

        car1.nextStep(SPEED); car3.nextStep(SPEED);
        racingGame = new RacingGame(Arrays.asList(car1, car2, car3));

        assertThat(racingGame.findWinners()).containsExactly("yell", "pobi");
    }

}