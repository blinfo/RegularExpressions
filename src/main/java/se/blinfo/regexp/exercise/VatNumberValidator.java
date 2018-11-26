package se.blinfo.regexp.exercise;

import java.util.Arrays;
import java.util.List;
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

    public static void main(String[] args) {
        System.out.println("The following should validate to \"true\"");
        List<String> validInput = Arrays.asList("SE 987654321001", "SE 123456789001", "SE123456789001");
        validInput.forEach(s -> System.out.println(new VatNumberValidator(s).validate()));
        System.out.println("\nThe following should validate to \"false\"");
        List<String> invalidInput = Arrays.asList("SE  987654321000", "SWE987654321001", "SE 98765432101");
        invalidInput.forEach(s -> System.out.println(new VatNumberValidator(s).validate()));
    }

}
