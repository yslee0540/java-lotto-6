package lotto.util;

import java.util.List;
import java.util.stream.Stream;
import lotto.constant.ExceptionMessage;

public class NumberParser {
    public static List<Integer> stringToList(String input) {
        try {
            return Stream.of(input.split(","))
                    .map(Integer::valueOf)
                    .toList();
        } catch (IllegalArgumentException e) {
            throw new IllegalArgumentException(ExceptionMessage.NON_NUMERIC.getMessage());
        }
    }
}
