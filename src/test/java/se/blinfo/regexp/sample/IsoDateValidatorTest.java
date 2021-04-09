package se.blinfo.regexp.sample;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;
import org.junit.Test;

/**
 *
 * @author Håkan Lidén
 */
public class IsoDateValidatorTest {

    @Test
    public void test_valid_date() {
        String date = "1987-11-30";
        Validator validator = new IsoDateValidator(date);
        assertTrue("Date: " + date + " should be valid", validator.validate().isValid());
    }

    @Test
    public void test_invalid_date() {
        String date = "1987-11-31";
        Validator validator = new IsoDateValidator(date);
        assertFalse("Date: " + date + " should be invalid", validator.validate().isValid());
    }

    @Test
    public void test_valid_date_for_leap_year() {
        String date = "2000-02-29";
        Validator validator = new IsoDateValidator(date);
        assertTrue("Date: " + date + " should be valid", validator.validate().isValid());
    }

    @Test
    public void test_invalid_date_for_leap_year() {
        String date = "1900-02-29";
        Validator validator = new IsoDateValidator(date);
        assertFalse("Date: " + date + " should be invalid", validator.validate().isValid());
    }
}
