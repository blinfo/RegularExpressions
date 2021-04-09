package se.blinfo.regexp.sample;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;
import org.junit.Test;

/**
 *
 * @author Håkan Lidén
 */
public class SwedishSocialSecurityNumberValidatorTest {

    @Test
    public void test_valid_numbers() {
        String ssn;
        ssn = "940224-5626";
        assertTrue("SSN " + ssn + " should be valid", new SwedishSocialSecurityNumberValidator(ssn).validate().isValid());
        ssn = "040229-5620";
        assertTrue("SSN " + ssn + " should be valid", new SwedishSocialSecurityNumberValidator(ssn).validate().isValid());
        ssn = "19940228-5622";
        assertTrue("SSN " + ssn + " should be valid", new SwedishSocialSecurityNumberValidator(ssn).validate().isValid());
    }

    @Test
    public void test_invalid_numbers() {
        String ssn;
        ssn = "040229-5625";
        assertFalse("SSN " + ssn + " should be invalid (invalid control digit)", new SwedishSocialSecurityNumberValidator(ssn).validate().isValid());
        ssn = "19940229-5621";
        assertFalse("SSN " + ssn + " should be invalid (invalid date)", new SwedishSocialSecurityNumberValidator(ssn).validate().isValid());
    }

}
