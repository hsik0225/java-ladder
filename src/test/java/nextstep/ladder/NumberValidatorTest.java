package nextstep.ladder;

import org.assertj.core.api.ThrowableAssert;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.AssertionsForClassTypes.assertThatThrownBy;

import nextstep.ladder.view.validator.InputValidator;
import nextstep.ladder.view.validator.NumberValidator;

public class NumberValidatorTest {

    private final InputValidator validator = new NumberValidator();

    @Test
    @DisplayName("숫자가 아닐 경우 예외 발생")
    public void validate_NameOverMaximumLength_ExceptionThrown() {

        // given
        String input = "nextstep";

        // when
        ThrowableAssert.ThrowingCallable callable = () -> validator.validate(input);

        //then
        assertThatThrownBy(callable).isExactlyInstanceOf(IllegalArgumentException.class)
                .hasMessage(NumberValidator.NOT_NUMBER_ERROR);
    }
}
