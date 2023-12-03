package lotto.domain;

import lotto.constant.ExceptionMessage;
import lotto.constant.LottoConstant;

public class Money {
    private final int price;

    public Money(int price) {
        validateRange(price);
        validateUnit(price);
        this.price = price;
    }

    public int getLottoCount() {
        return price / LottoConstant.LOTTO_PRICE_UNIT;
    }

    private void validateRange(int number) {
        if (number < LottoConstant.MIN_PRICE_NUMBER) {
            throw new IllegalArgumentException(ExceptionMessage.WRONG_RANGE.getMessage());
        }
    }

    private void validateUnit(int number) {
        if (number % LottoConstant.MIN_PRICE_NUMBER != 0) {
            throw new IllegalArgumentException(ExceptionMessage.WRONG_UNIT.getMessage());
        }
    }

}
