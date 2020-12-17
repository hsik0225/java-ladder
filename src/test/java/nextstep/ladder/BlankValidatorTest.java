package nextstep.ladder;

import org.assertj.core.api.ThrowableAssert;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.NullAndEmptySource;

import static org.assertj.core.api.AssertionsForClassTypes.assertThatThrownBy;

import nextstep.ladder.view.validator.BlankValidator;
import nextstep.ladder.view.validator.InputValidator;

public class BlankValidatorTest {

    private final InputValidator validator = new BlankValidator();

    @ParameterizedTest
    @NullAndEmptySource
    @DisplayName("null값과 빈 문자열일 경우 예외 발생")
    public void validate_NullAndEmpty_ExceptionThrown(String input) {

        // when
        ThrowableAssert.ThrowingCallable callable = () -> validator.validate(input);

        //then
        assertThatThrownBy(callable).isExactlyInstanceOf(IllegalArgumentException.class)
                .hasMessage(BlankValidator.BLANK_ERROR);
    }
}
