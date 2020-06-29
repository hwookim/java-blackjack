package domain.result;

import static org.assertj.core.api.Assertions.assertThat;

import java.util.stream.Stream;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

class PrizeRatioTest {

    @ParameterizedTest
    @MethodSource("createWinningResult")
    void getResult(PrizeRatio prizeRatio, double expected) {
        assertThat(prizeRatio.getRatio()).isEqualTo(expected);
    }

    private static Stream<Arguments> createWinningResult() {
        return Stream.of(
            Arguments.of(PrizeRatio.WIN, 1),
            Arguments.of(PrizeRatio.LOSE, -1),
            Arguments.of(PrizeRatio.DRAW, 0),
            Arguments.of(PrizeRatio.BLACKJACK, 1.5)
        );
    }

}