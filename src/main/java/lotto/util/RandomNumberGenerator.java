package lotto.util;

import static lotto.constant.LottoConstant.LOTTO_SIZE;
import static lotto.constant.LottoConstant.MAX_LOTTO_NUMBER;
import static lotto.constant.LottoConstant.MIN_LOTTO_NUMBER;

import camp.nextstep.edu.missionutils.Randoms;
import java.util.List;
import java.util.stream.Collectors;

public class RandomNumberGenerator {
    public static List<Integer> generate() {
        List<Integer> numbers = Randoms.pickUniqueNumbersInRange(
                MIN_LOTTO_NUMBER, MAX_LOTTO_NUMBER, LOTTO_SIZE);
        return sortRandomNumbers(numbers);
    }

    private static List<Integer> sortRandomNumbers(List<Integer> numbers) {
        return numbers.stream().sorted().collect(Collectors.toList());
    }
}
