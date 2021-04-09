package se.blinfo.regexp.sample;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;
import org.junit.Test;

/**
 *
 * @author Håkan Lidén
 */
public class LicenceNumberValidatorTest {

    @Test
    public void test_valid_number() {
        String plate = "HEX 408";
        assertTrue("Number " + plate + " should be valid", new LicenceNumberValidator(plate).validate().isValid());
        plate = "HEX408";
        assertTrue("Number " + plate + " should be valid", new LicenceNumberValidator(plate).validate().isValid());
        plate = "HEX40T";
        assertTrue("Number " + plate + " should be valid", new LicenceNumberValidator(plate).validate().isValid());
    }

    @Test
    public void test_invalid_number() {
        String plate = "APA123";
        assertFalse("Number " + plate + " should be invalid", new LicenceNumberValidator(plate).validate().isValid());
        plate = "APA 123";
        assertFalse("Number " + plate + " should be invalid", new LicenceNumberValidator(plate).validate().isValid());
    }

}
