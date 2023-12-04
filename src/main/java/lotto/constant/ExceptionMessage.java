package lotto.constant;

public enum ExceptionMessage {
    NON_NUMERIC("숫자로만 이루어진 값을 입력해주세요."),
    WRONG_PRICE_RANGE("1000 이상의 숫자만 입력 가능합니다."),
    WRONG_UNIT("1000원 단위의 숫자만 입력 가능합니다."),
    WRONG_SIZE("6개의 숫자를 입력해주세요."),
    DUPLICATE("중복된 숫자가 포함되어 있습니다."),
    WRONG_LOTTO_RANGE("1 ~ 45 사이의 숫자를 입력해주세요.");

    private final String message;
    private static final String ERROR_TAG = "[ERROR] ";

    ExceptionMessage(String message) {
        this.message = ERROR_TAG + message;
    }

    public String getMessage() {
        return message;
    }
}
