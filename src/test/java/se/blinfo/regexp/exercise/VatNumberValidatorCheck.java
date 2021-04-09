package se.blinfo.regexp.exercise;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;
import org.junit.Test;

/**
 *
 * @author Håkan Lidén
 */
public class VatNumberValidatorCheck {

    @Test
    public void check_valid_VAT_number() {
        String input;
        input = "SE 012345678901";
        assertTrue("Input " + input + " should be valid", new VatNumberValidator(input).validate().isValid());
        input = "SE234567890101";
        assertTrue("Input " + input + " should be valid", new VatNumberValidator(input).validate().isValid());
    }

    @Test
    public void check_invalid_VAT_number() {
        String input;
        input = "SE 012345678902";
        assertFalse("Input " + input + " should be valid", new VatNumberValidator(input).validate().isValid());
        input = "SE23456789001";
        assertFalse("Input " + input + " should be valid", new VatNumberValidator(input).validate().isValid());
        input = "NO 012345678901";
        assertFalse("Input " + input + " should be valid", new VatNumberValidator(input).validate().isValid());
    }
}
