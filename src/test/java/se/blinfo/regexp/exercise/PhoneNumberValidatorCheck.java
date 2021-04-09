package se.blinfo.regexp.exercise;

import java.util.List;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;
import org.junit.Test;

/**
 *
 * @author Håkan Lidén
 */
public class PhoneNumberValidatorCheck {

    private static final List<String> VALID_NUMBERS = List.of("+46 70 4235734",
            "073 1239574", "0650 541490", "+46 650 541490", "060 5411490",
            "+46 60 541490", "08 54114290", "+46 8 54114290");
    private static final List<String> INVALID_NUMBERS = List.of("-46 70 4235734",
            "073-1239574", "0650541490", "+46650 541490", "46 60 5411490",
            "+46 060 541490", "8 54114290", "+46 8 541 142 90", "+046 650 541400");

    @Test
    public void test_valid_number() {
        VALID_NUMBERS.forEach(number -> {
            assertTrue(number + " should be valid", new PhoneNumberValidator(number).validate().isValid());
        });
    }

    @Test
    public void test_invalid_number() {
        INVALID_NUMBERS.forEach(number -> {
            assertFalse(number + " should not be valid", new PhoneNumberValidator(number).validate().isValid());
        });
    }

    @Test
    public void test_PhoneNumber() {
        String input;
        PhoneNumberValidator validator;
        input = "+42 70 4235734";
        validator = new PhoneNumberValidator(input);
        assertTrue("Number should be valid", validator.validate().isValid());
        assertTrue("Validator should have a number", validator.getPhoneNumber().isPresent());
        validator.getPhoneNumber().ifPresent(number -> {
            assertEquals("Country code should be +42", "+42", number.getCountryCode());
            assertEquals("Regional code should be 70", "70", number.getRegionalCode());
            assertEquals("Number should be 4235734", "4235734", number.getNumber());
            assertEquals("The toString method should produce the same as the input", "+42 70 4235734", number.toString());
        });
        input = "070 4235734";
        validator = new PhoneNumberValidator(input);
        assertTrue("Number should be valid", validator.validate().isValid());
        assertTrue("Validator should have a number", validator.getPhoneNumber().isPresent());
        validator.getPhoneNumber().ifPresent(number -> {
            assertEquals("Country code should be +46", "+46", number.getCountryCode());
            assertEquals("Regional code should be 70", "70", number.getRegionalCode());
            assertEquals("Number should be 4235734", "4235734", number.getNumber());
            String result = "+46 70 4235734";
            assertEquals("The toString method should produce " + result, result, number.toString());
        });
    }
}
