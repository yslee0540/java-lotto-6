package lotto.domain;

import lotto.constant.ExceptionMessage;
import lotto.constant.LottoConstant;

public class BonusNumber {
    private final int number;

    public BonusNumber(int number, Lotto lotto) {
        validateRange(number);
        validateDuplicate(number, lotto);
        this.number = number;
    }

    private void validateRange(int number) {
        if (number < LottoConstant.MIN_LOTTO_NUMBER || number > LottoConstant.MAX_LOTTO_NUMBER) {
            throw new IllegalArgumentException(ExceptionMessage.WRONG_LOTTO_RANGE.getMessage());
        }
    }

    private void validateDuplicate(int number, Lotto lotto) {
        if (lotto.getNumbers().contains(number)) {
            throw new IllegalArgumentException(ExceptionMessage.DUPLICATE.getMessage());
        }
    }

    public boolean hasBonusNumber(Lotto lotto) {
        return lotto.getNumbers().contains(number);
    }
}
