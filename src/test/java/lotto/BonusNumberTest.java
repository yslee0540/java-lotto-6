package lotto;

import static org.assertj.core.api.Assertions.assertThatThrownBy;

import java.util.List;
import lotto.constant.ExceptionMessage;
import lotto.domain.BonusNumber;
import lotto.domain.Lotto;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

class BonusNumberTest {
    private Lotto lotto;

    @BeforeEach
    void setUp() {
        lotto = new Lotto(List.of(1, 2, 3, 4, 5, 6));
    }

    @DisplayName("숫자 범위가 1~45가 아니면 예외가 발생한다.")
    @ParameterizedTest
    @ValueSource(ints = {-1, 0, 46})
    void throw_exception_when_invalid_range(int input) {
        assertThatThrownBy(() -> new BonusNumber(input, lotto))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage(ExceptionMessage.WRONG_LOTTO_RANGE.getMessage());
    }

    @DisplayName("보너스 넘버가 당첨 로또 번호와 중복되면 예외가 발생한다.")
    @ParameterizedTest
    @ValueSource(ints = {1, 2, 3, 4, 5, 6})
    void throw_exception_when_duplicate(int input) {
        assertThatThrownBy(() -> new BonusNumber(input, lotto))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage(ExceptionMessage.DUPLICATE.getMessage());
    }
}