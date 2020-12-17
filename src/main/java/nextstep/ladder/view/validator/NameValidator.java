package nextstep.ladder.view.validator;

public class NameValidator implements InputValidator {

    public static final String NAME_RANGE_ERROR = "이름은 5글자 이하이어야 합니다.";

    private static final String NAME_DELIMITER = ",";

    private final BlankValidator blankValidator;

    public NameValidator() {
        this.blankValidator = new BlankValidator();
    }

    @Override
    public void validate(String input) {
        blankValidator.validate(input);

        String[] names = input.split(NAME_DELIMITER);
        for (String name : names) {
            checkRange(name);
        }
    }

    private void checkRange(String name) {
        if (name.length() > 5) {
            throw new IllegalArgumentException(NAME_RANGE_ERROR);
        }
    }
}
