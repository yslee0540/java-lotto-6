package lotto.view;

import java.util.List;
import java.util.Map;
import lotto.domain.Lotto;
import lotto.domain.Rank;

public class OutputView {
    private static final String LOTTO_COUNT = "%d개를 구매했습니다.%n";
    private static final String RESULT_MESSAGE = "\n당첨 통계\n---";
    private static final String LOTTO_RESULT = "%d개 일치 (%,d원) - %d개%n";
    private static final String LOTTO_SECOND_RESULT = "%d개 일치, 보너스 볼 일치 (%,d원) - %d개%n";
    private static final String RETURN_OF_RATE_MESSAGE = "총 수익률은 %.1f%%입니다.";

    public static void printLottoCount(int count) {
        System.out.println();
        System.out.printf(LOTTO_COUNT, count);
    }

    public static void printPurchaseLotto(List<Lotto> lottos) {
        for (Lotto lotto : lottos) {
            System.out.println(lotto);
        }
    }

    public static void printResultMessage() {
        System.out.println(RESULT_MESSAGE);
    }

    public static void printStatics(Map<Rank, Integer> result) {
        StringBuilder stringBuilder = new StringBuilder();
        result.entrySet().stream()
                .filter(entry -> entry.getKey() != Rank.MISS)
                .forEach(entry -> stringBuilder.append(formatRank(entry.getKey(), entry.getValue())));
        System.out.println(stringBuilder);
    }

    private static String formatRank(Rank rank, long count) {
        if (rank == Rank.SECOND) {
            return String.format(LOTTO_SECOND_RESULT, rank.matchCount, rank.prize, count);
        }
        return String.format(LOTTO_RESULT, rank.matchCount, rank.prize, count);
    }

    public static void printRateOfReturn(double rate) {
        System.out.printf(RETURN_OF_RATE_MESSAGE, rate);
    }
}
