package nextstep.ladder.view.validator;

public class BlankValidator implements InputValidator {

    public static final String BLANK_ERROR = "null 혹은 빈 문자열을 입력하셨습니다.";

    @Override
    public void validate(String input) {
        checkNullOrEmpty(input);
    }

    private void checkNullOrEmpty(String input) {
        if (input == null || input.isEmpty()) {
            throw new IllegalArgumentException(BLANK_ERROR);
        }
    }
}
