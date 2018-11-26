package se.blinfo.regexp.exercise;

import java.util.Arrays;
import java.util.List;
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

    public static void main(String[] args) {
        System.out.println("The following should validate to \"true\"");
        List<String> validInput = Arrays.asList("901950-6", "5694242-8");
        validInput.forEach(s -> System.out.println(new PlusGiroValidator(s).validate()));
        System.out.println("\nThe following should validate to \"false\"");
        List<String> invalidInput = Arrays.asList("49173477", "1422-7851", "12786-1");
        invalidInput.forEach(s -> System.out.println(new PlusGiroValidator(s).validate()));
    }

}
