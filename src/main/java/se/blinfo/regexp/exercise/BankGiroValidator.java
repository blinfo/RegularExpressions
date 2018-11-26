package se.blinfo.regexp.exercise;

import java.util.Arrays;
import java.util.List;
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

    public static void main(String[] args) {
        System.out.println("The following should validate to \"true\"");
        List<String> validInput = Arrays.asList("917-3477", "5694-2428");
        validInput.forEach(s -> System.out.println(new BankGiroValidator(s).validate()));
        System.out.println("\nThe following should validate to \"false\"");
        List<String> invalidInput = Arrays.asList("9173477", "12-47851", "127864-1");
        invalidInput.forEach(s -> System.out.println(new BankGiroValidator(s).validate()));
    }

}
