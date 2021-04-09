package se.blinfo.regexp.exercise;

import se.blinfo.regexp.sample.AbstractValidator;

/**
 * Validate BankGiro Number.
 * <p>
 * Valid formats (nnnn-nnnn, nnn-nnnn)<br>
 * <b>This is not necessarily all valid number formats!</b>
 * <ol>
 * <li>917-3477</li>
 * <li>5694-2428</li>
 * </ol>
 *
 * @author hl
 */
public class BankGiroValidator extends AbstractValidator {

    private static final String REGEXP = "";

    public BankGiroValidator(String input) {
        super(input, REGEXP);
    }
}
