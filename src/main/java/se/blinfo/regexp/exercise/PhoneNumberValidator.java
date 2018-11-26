package se.blinfo.regexp.exercise;

import java.util.Arrays;
import java.util.List;
import se.blinfo.regexp.sample.AbstractValidator;

/**
 * Validate phone numbers.
 *
 * The valid formats are:
 * <ul>
 * <li>+46 70 4235734</li>
 * <li>073 1239574</li>
 * <li>0650 541490</li>
 * <li>+46 650 541490</li>
 * <li>060 5411490</li>
 * <li>+46 60 541490</li>
 * <li>08 54114290</li>
 * <li>+46 8 54114290</li>
 * </ul>
 * I. e. optional country number (one through three digits with + as suffix),
 * region (one through three digits with no leading zero if country code is
 * provided, otherwise with a required leading zero) and the actual number (five
 * through eight digits). The different parts should be separated by one space.
 * <p>
 * <b>Extra:</b>
 * Implement a method to get the different parts of the number with either
 * optional or default country code.
 *
 * @author hl
 */
public class PhoneNumberValidator extends AbstractValidator {

    private static final String REGEXP = "";

    public PhoneNumberValidator(String input) {
        super(input, REGEXP);
    }

    public static void main(String[] args) {
        System.out.println("The following should validate to \"true\"");
        List<String> validInput = Arrays.asList("+46 70 4235734", "073 1239574",
                "0650 541490", "+46 650 541490", "060 5411490", "+46 60 541490",
                "08 54114290", "+46 8 54114290");
        validInput.forEach(n -> System.out.println(new PhoneNumberValidator(n).validate()));

        System.out.println("\nThe following should validate to \"false\"");
        List<String> invalidInput = Arrays.asList("-46 70 4235734", "073-1239574",
                "0650541490", "+46650 541490", "46 60 5411490", "+46 060 541490",
                "8 54114290", "+46 8 541 142 90", "+046 650 541400");
        invalidInput.forEach(n -> System.out.println(new PhoneNumberValidator(n).validate()));

    }

}
