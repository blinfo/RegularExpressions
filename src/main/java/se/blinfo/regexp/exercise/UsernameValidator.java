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

    public static void main(String[] args) {
        System.out.println("The following should validate to \"true\"");
        List<String> validInput = Arrays.asList("snisse", "ottoman", "superman", "bettan");
        validInput.forEach(s -> System.out.println(new UsernameValidator(s).validate()));
        System.out.println("\nThe following should validate to \"false\"");
        List<String> invalidInput = Arrays.asList("SNISSE", "root", "myUserName", "hln142");
        invalidInput.forEach(s -> System.out.println(new UsernameValidator(s).validate()));
    }

}
