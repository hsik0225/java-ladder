package nextstep.ladder.view.validator;

public class NumberValidator implements InputValidator {

    public static final String NOT_NUMBER_ERROR = "숫자만 입력해주세요.";

    public static final String TOO_LESS_LADDER_SIZE = "사다리 높이는 1 이상이어야 합니다.";

    private static final int MINIMUM_LADDER_SIZE = 1;

    private final BlankValidator blankValidator;

    public NumberValidator() {
        this.blankValidator = new BlankValidator();
    }

    @Override
    public void validate(String input) {
        this.blankValidator.validate(input);
        checkNumber(input);
        checkBound(input);
    }

    private void checkNumber(String input) {
        try {
            Integer.parseInt(input);
        } catch (NumberFormatException e) {
            throw new IllegalArgumentException(NOT_NUMBER_ERROR);
        }
    }

    private void checkBound(String input) {
        if (Integer.parseInt(input) < MINIMUM_LADDER_SIZE) {
            throw new IllegalArgumentException(TOO_LESS_LADDER_SIZE);
        }
    }
}
