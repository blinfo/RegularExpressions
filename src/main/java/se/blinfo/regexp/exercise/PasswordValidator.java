package se.blinfo.regexp.exercise;

import java.util.Arrays;
import java.util.List;
import se.blinfo.regexp.sample.AbstractValidator;

/**
 * Validate a New Password.
 * <p>
 * For the purpose of this exercise the password format should be:
 * <ol>
 * <li>two lower case letters (including åäöæøœ)</li>
 * <li>one special character (*+-?@£$€¥!#¤%&)</li>
 * <li>one through three digits</li>
 * <li>one through three uppercase letters (including ÅÄÖÆØŒ)</li>
 * <li>one special character</li>
 * <li>one through three letters (upper or lowercase)</li>
 * <li>one digit</li>
 * </ol>
 * E. g. cå?98UTÆ¥œRZ9, tv*1ÖX€l4, qz%51Y@ltP8
 *
 * @author hl
 */
public class PasswordValidator extends AbstractValidator {

    private static final String REGEXP = "";

    public PasswordValidator(String input) {
        super(input, REGEXP);
    }

    public static void main(String[] args) {
        System.out.println("The following should validate to \"true\"");
        List<String> validInput = Arrays.asList("cå?98UTÆ¥œRZ9", "tv*1ÖX€l4", "qz%51Y@ltP8");
        validInput.forEach(s -> System.out.println(new PasswordValidator(s).validate()));
        System.out.println("\nThe following should validate to \"false\"");
        List<String> invalidInput = Arrays.asList("password", "admin", "myPassword", "cé?98UTÆ¥œRZ9");
        invalidInput.forEach(s -> System.out.println(new PasswordValidator(s).validate()));
    }

}
