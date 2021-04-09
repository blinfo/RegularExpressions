package se.blinfo.regexp.exercise;

import java.util.Arrays;
import java.util.List;
import se.blinfo.regexp.sample.AbstractValidator;

/**
 *
 * User Name Validator.
 * <p>
 * For the purpose of this exercise, the username should consist of six through
 * nine lower case letters a-z. E. g. snisse, ottoman, spiderman, bettan
 *
 * @author hl
 */
public class UsernameValidator extends AbstractValidator {

    private static final String REGEXP = "";

    public UsernameValidator(String input) {
        super(input, REGEXP);
    }
}
