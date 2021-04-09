package se.blinfo.regexp.exercise;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;
import org.junit.Test;

/**
 *
 * @author Håkan Lidén
 */
public class PlusGiroValidatorCheck {

    @Test
    public void check_valid_PlusGiro_number() {
        String input;
        input = "1234567-8";
        assertTrue("Number " + input + " should be valid", new PlusGiroValidator(input).validate().isValid());
        input = "987654-3";
        assertTrue("Number " + input + " should be valid", new PlusGiroValidator(input).validate().isValid());
    }

    @Test
    public void check_invalid_PlusGiro_number() {
        String input;
        input = "1234-567";
        assertFalse("Number " + input + " should be invalid", new PlusGiroValidator(input).validate().isValid());
        input = "987654-10";
        assertFalse("Number " + input + " should be invalid", new PlusGiroValidator(input).validate().isValid());
    }

}
