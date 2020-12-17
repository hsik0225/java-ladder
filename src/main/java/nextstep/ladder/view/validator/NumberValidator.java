package nextstep.ladder.view.validator;

public class NumberValidator implements InputValidator {

    public static final String NOT_NUMBER_ERROR = "숫자만 입력해주세요.";

    private final BlankValidator blankValidator;

    public NumberValidator() {
        this.blankValidator = new BlankValidator();
    }

    @Override
    public void validate(String input) {
        this.blankValidator.validate(input);
        checkNumber(input);
    }

    private void checkNumber(String input) {
        try {
            Integer.parseInt(input);
        } catch (NumberFormatException e) {
            throw new IllegalArgumentException(NOT_NUMBER_ERROR);
        }
    }
}
