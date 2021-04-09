package se.blinfo.regexp.exercise;

import se.blinfo.regexp.sample.AbstractValidator;

/**
 * Validate UUID Format.
 * <p>
 * Check if input corresponds to the expected format:
 * <ol>
 * <li>a group of eight hexadecimal digits (0 - 9 and lower case a - f)</li>
 * <li>three groups of four hexadecimal digits</li>
 * <li>a group of twelve hexadecimal digits</li>
 * <li>each group is separated by a hyphen</li>
 * </ol>
 * E. g. 4b4ec661-eef0-4147-b928-a62c6f53f3a4,
 * 862ea32b-77dc-4055-a94f-0c4d43df7901, 331b9c89-fcfc-4701-86a1-8428dfeb5aea
 *
 * @author hl
 */
public class UUIDValidator extends AbstractValidator {

    private static final String REGEXP = "";

    public UUIDValidator(String input) {
        super(input, REGEXP);
    }
}
