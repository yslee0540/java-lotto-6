package lotto.constant;

public enum ExceptionMessage {
    NON_NUMERIC("숫자로만 이루어진 값을 입력해주세요."),
    WRONG_RANGE("1000 이상의 숫자만 입력 가능합니다."),
    WRONG_UNIT("1000원 단위의 숫자만 입력 가능합니다.");

    private final String message;
    private static final String ERROR_TAG = "[ERROR] ";

    ExceptionMessage(String message) {
        this.message = ERROR_TAG + message;
    }

    public String getMessage() {
        return message;
    }
}
