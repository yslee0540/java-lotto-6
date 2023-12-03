package lotto.domain;

import java.util.ArrayList;
import java.util.List;
import lotto.util.RandomNumberGenerator;

public class LottoMachine {

    public List<Lotto> issue(int lottoCount) {
        List<Lotto> lottos = new ArrayList<>();
        for (int i = 0; i < lottoCount; i++) {
            lottos.add(new Lotto(RandomNumberGenerator.generate()));
        }
        return lottos;
    }
}
