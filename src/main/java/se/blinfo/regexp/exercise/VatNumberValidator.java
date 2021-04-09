package se.blinfo.regexp.exercise;

import se.blinfo.regexp.sample.AbstractValidator;

/**
 * Validate Vat Number for a Swedish company.
 *
 * Starts with "SE" followed by an optional space, then 12 digits. The last two
 * digits are <b>always</b> "01".
 *
 * @author hl
 */
public class VatNumberValidator extends AbstractValidator {

    private static final String REGEXP = "";

    public VatNumberValidator(String input) {
        super(input, REGEXP);
    }
}
