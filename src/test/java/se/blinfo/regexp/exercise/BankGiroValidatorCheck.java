package se.blinfo.regexp.exercise;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;
import org.junit.Test;

/**
 *
 * @author Håkan Lidén
 */
public class BankGiroValidatorCheck {

    @Test
    public void check_valid_BankGiro_number() {
        String input;
        input = "1234-5678";
        assertTrue("Number " + input + " should be valid", new BankGiroValidator(input).validate().isValid());
        input = "987-6543";
        assertTrue("Number " + input + " should be valid", new BankGiroValidator(input).validate().isValid());
    }

    @Test
    public void check_invalid_BankGiro_number() {
        String input;
        input = "1234-567";
        assertFalse("Number " + input + " should be invalid", new BankGiroValidator(input).validate().isValid());
        input = "987654-1";
        assertFalse("Number " + input + " should be invalid", new BankGiroValidator(input).validate().isValid());
    }

}
