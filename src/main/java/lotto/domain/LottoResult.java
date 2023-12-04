package lotto.domain;

import java.util.Arrays;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

public class LottoResult {
    private final Map<Rank, Integer> result;

    public LottoResult(List<Lotto> lottos, Lotto winningLotto, BonusNumber bonusNumber) {
        this.result = new LinkedHashMap<>();
        initData();
        calculateNumberOfWins(lottos, winningLotto, bonusNumber);
    }

    public Map<Rank, Integer> getResult() {
        return result;
    }

    public void calculateNumberOfWins(List<Lotto> lottos, Lotto winningLotto, BonusNumber bonusNumber) {
        for (Lotto lotto : lottos) {
            countWinningRank(winningLotto.countMatchNumbers(lotto), bonusNumber.hasBonusNumber(lotto));
        }
    }

    private void initData() {
        Arrays.stream(Rank.values()).forEach(rank ->
                result.put(rank, 0));
    }

    private void countWinningRank(int matchCount, boolean matchBonus) {
        Rank rank = Rank.getRank(matchCount, matchBonus);
        result.put(rank, result.get(rank) + 1);
    }

    private double calculateTotalPrize() {
        return result.entrySet().stream()
                .mapToDouble(entry -> entry.getKey().prize * entry.getValue())
                .sum();
    }

    public double calculateRateOfReturn(int amount) {
        double totalPrize = calculateTotalPrize();
        return (totalPrize / amount) * 100;
    }
}
