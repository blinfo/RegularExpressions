package se.blinfo.regexp.exercise;

import se.blinfo.regexp.sample.AbstractValidator;

/**
 * Validate BankGiro Number.
 * <p>
 * Valid formats (nnnnnn-n, nnnnnnn-n)<br>
 * <b>This is not necessarily all valid number formats!</b>
 * <ol>
 * <li>901950-6</li>
 * <li>5694242-8</li>
 * </ol>
 *
 * @author hl
 */
public class PlusGiroValidator extends AbstractValidator {

    private static final String REGEXP = "";

    public PlusGiroValidator(String input) {
        super(input, REGEXP);
    }
}
