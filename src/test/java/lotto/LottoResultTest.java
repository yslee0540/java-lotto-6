package lotto;

import static org.assertj.core.api.Assertions.assertThat;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import lotto.domain.BonusNumber;
import lotto.domain.Lotto;
import lotto.domain.LottoResult;
import lotto.domain.Rank;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

public class LottoResultTest {
    private Lotto winningLotto;
    private BonusNumber bonusNumber;

    @BeforeEach
    void setUp() {
        winningLotto = new Lotto(List.of(1, 2, 3, 4, 5, 6));
        bonusNumber = new BonusNumber(7, winningLotto);
    }

    @DisplayName("로또 당첨 내역 개수 세기")
    @Test
    void getLottoResult() {
        List<Lotto> lottos = new ArrayList<>();
        lottos.add(new Lotto(List.of(1, 2, 3, 4, 5, 6)));
        lottos.add(new Lotto(List.of(1, 2, 3, 4, 5, 7)));
        lottos.add(new Lotto(List.of(1, 2, 3, 4, 5, 8)));
        lottos.add(new Lotto(List.of(1, 2, 3, 4, 8, 9)));
        lottos.add(new Lotto(List.of(1, 2, 3, 8, 9, 10)));
        lottos.add(new Lotto(List.of(4, 5, 6, 11, 20, 42)));
        lottos.add(new Lotto(List.of(5, 6, 7, 8, 9, 10)));

        Map<Rank, Integer> result = new HashMap<>();
        result.put(Rank.FIRST, 1);
        result.put(Rank.SECOND, 1);
        result.put(Rank.THIRD, 1);
        result.put(Rank.FOURTH, 1);
        result.put(Rank.FIFTH, 2);
        result.put(Rank.MISS, 1);

        LottoResult lottoResult = new LottoResult(lottos, winningLotto, bonusNumber);
        assertThat(lottoResult.getResult()).isEqualTo(result);
    }

    @DisplayName("총 수익률 계산하기")
    @Test
    void getRateOfReturn() {
        List<Lotto> lottos = new ArrayList<>();
        lottos.add(new Lotto(List.of(11, 21, 13, 14, 15, 16)));
        lottos.add(new Lotto(List.of(12, 22, 32, 42, 25, 27)));
        lottos.add(new Lotto(List.of(13, 32, 33, 34, 35, 38)));
        lottos.add(new Lotto(List.of(11, 22, 33, 34, 38, 39)));
        lottos.add(new Lotto(List.of(11, 22, 33, 34, 38, 39)));
        lottos.add(new Lotto(List.of(1, 2, 3, 4, 9, 10)));

        LottoResult lottoResult = new LottoResult(lottos, winningLotto, bonusNumber);
        double rate = lottoResult.calculateRateOfReturn(6000);
        double actual = Double.parseDouble(String.format("%.1f", rate));
        assertThat(actual).isEqualTo(833.3);
    }
}
