package lotto.view;

import camp.nextstep.edu.missionutils.Console;

public class InputView {
    private static final String PRICE_INPUT_MESSAGE = "구입금액을 입력해 주세요.";
    private static final String LOTTO_INPUT_MESSAGE = "\n당첨 번호를 입력해 주세요.";
    private static final String BONUS_NUMBER_INPUT_MESSAGE = "\n보너스 번호를 입력해 주세요.";

    public static String readLottoPrice() {
        System.out.println(PRICE_INPUT_MESSAGE);
        return Console.readLine().trim();
    }

    public static String readLottoNumbers() {
        System.out.println(LOTTO_INPUT_MESSAGE);
        return Console.readLine().trim();
    }

    public static String readBonusNumber() {
        System.out.println(BONUS_NUMBER_INPUT_MESSAGE);
        return Console.readLine().trim();
    }
}
