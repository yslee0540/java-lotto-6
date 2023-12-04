package lotto.controller;

import java.util.List;
import lotto.constant.LottoConstant;
import lotto.domain.BonusNumber;
import lotto.domain.Lotto;
import lotto.domain.LottoMachine;
import lotto.domain.LottoResult;
import lotto.domain.Money;
import lotto.util.NumberParser;
import lotto.util.NumberValidator;
import lotto.view.InputView;
import lotto.view.OutputView;

public class LottoController {
    private int price;
    private List<Lotto> lottos;

    public void startGame() {
        Money money = readMoney();
        price = money.getPrice();
        showPurchaseLotto();
        LottoResult lottoResult = getLottoResult();
        showLottoResult(lottoResult);
    }

    private Money readMoney() {
        try {
            String money = InputView.readLottoPrice();
            return new Money(NumberValidator.stringToInt(money));
        } catch (IllegalArgumentException e) {
            System.out.println(e.getMessage());
            return readMoney();
        }
    }

    private void showPurchaseLotto() {
        LottoMachine lottoMachine = new LottoMachine();
        int lottoCount = price / LottoConstant.LOTTO_PRICE_UNIT;
        lottos = lottoMachine.issue(lottoCount);
        OutputView.printLottoCount(lottoCount);
        OutputView.printPurchaseLotto(lottos);
    }

    private Lotto readLottoNumbers() {
        try {
            String lotto = InputView.readLottoNumbers();
            return new Lotto(NumberParser.stringToList(lotto));
        } catch (IllegalArgumentException e) {
            System.out.println(e.getMessage());
            return readLottoNumbers();
        }
    }

    private BonusNumber readBonusNumber(Lotto lotto) {
        try {
            String number = InputView.readBonusNumber();
            return new BonusNumber(NumberValidator.stringToInt(number), lotto);
        } catch (IllegalArgumentException e) {
            System.out.println(e.getMessage());
            return readBonusNumber(lotto);
        }
    }

    private LottoResult getLottoResult() {
        Lotto winningLotto = readLottoNumbers();
        BonusNumber bonusNumber = readBonusNumber(winningLotto);
        return new LottoResult(lottos, winningLotto, bonusNumber);
    }

    private void showLottoResult(LottoResult lottoResult) {
         OutputView.printResultMessage();
         OutputView.printStatics(lottoResult.getResult());
         OutputView.printRateOfReturn(lottoResult.calculateRateOfReturn(price));
    }
}
