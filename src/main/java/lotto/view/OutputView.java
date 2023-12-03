package lotto.view;

import java.util.List;
import lotto.domain.Lotto;

public class OutputView {
    private static final String LOTTO_COUNT = "%d개를 구매했습니다.%n";

    public static void printLottoCount(int count) {
        System.out.println();
        System.out.printf(LOTTO_COUNT, count);
    }

    public static void printPurchaseLotto(List<Lotto> lottos) {
        for (Lotto lotto : lottos) {
            System.out.println(lotto);
        }
    }
}
