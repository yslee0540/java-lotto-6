package lotto;

import static org.assertj.core.api.Assertions.assertThatThrownBy;

import lotto.constant.ExceptionMessage;
import lotto.domain.Money;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

class MoneyTest {
    @DisplayName("구입 금액이 정상 범위가 아닐 때 예외가 발생한다.")
    @ParameterizedTest
    @ValueSource(ints = {-1000, -999, 0, 1, 999})
    void throw_exception_when_invalid_range(int input) {
        assertThatThrownBy(() -> new Money(input))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage(ExceptionMessage.WRONG_PRICE_RANGE.getMessage());
    }

    @DisplayName("금액이 1000 단위가 아닐 때 예외가 발생한다.")
    @ParameterizedTest
    @ValueSource(ints = {1001, 4500})
    void throw_exception_when_invalid_unit(int input) {
        assertThatThrownBy(() -> new Money(input))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage(ExceptionMessage.WRONG_UNIT.getMessage());
    }

}