package lotto.domain;

import lotto.constant.ExceptionMessage;
import lotto.constant.LottoConstant;

public record Money(int price) {
    public Money {
        validateRange(price);
        validateUnit(price);
    }

    private void validateRange(int number) {
        if (number < LottoConstant.MIN_PRICE_NUMBER) {
            throw new IllegalArgumentException(ExceptionMessage.WRONG_PRICE_RANGE.getMessage());
        }
    }

    private void validateUnit(int number) {
        if (number % LottoConstant.MIN_PRICE_NUMBER != 0) {
            throw new IllegalArgumentException(ExceptionMessage.WRONG_UNIT.getMessage());
        }
    }

}
