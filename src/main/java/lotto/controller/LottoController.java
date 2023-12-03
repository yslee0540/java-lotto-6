package lotto.controller;

import lotto.domain.LottoMachine;
import lotto.domain.Money;
import lotto.util.NumberValidator;
import lotto.view.InputView;
import lotto.view.OutputView;

public class LottoController {
    public void startGame() {
        Money money = getMoney();
        showPurchaseLotto(money.getLottoCount());
    }

    private Money getMoney() {
        try {
            String money = InputView.readLottoPrice();
            return new Money(NumberValidator.stringToInt(money));
        } catch (IllegalArgumentException e) {
            System.out.println(e.getMessage());
            return getMoney();
        }
    }

    private void showPurchaseLotto(int count) {
        LottoMachine lottoMachine = new LottoMachine();
        OutputView.printLottoCount(count);
        OutputView.printPurchaseLotto(lottoMachine.issue(count));
    }
}
