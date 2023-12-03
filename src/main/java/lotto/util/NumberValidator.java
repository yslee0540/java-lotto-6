package lotto.util;

import lotto.constant.ExceptionMessage;

public class NumberValidator {
    public static int stringToInt(String input) {
        validateInteger(input);
        return Integer.parseInt(input);
    }

    private static void validateInteger(String input) {
        try {
            Integer.parseInt(input);
        } catch (IllegalArgumentException e) {
            throw new IllegalArgumentException(ExceptionMessage.NON_NUMERIC.getMessage());
        }
    }
}
