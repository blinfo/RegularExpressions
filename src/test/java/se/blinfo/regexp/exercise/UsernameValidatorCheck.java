package se.blinfo.regexp.exercise;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;
import org.junit.Test;

/**
 *
 * @author Håkan Lidén
 */
public class UsernameValidatorCheck {

    @Test
    public void check_valid_Username() {
        //snisse, ottoman, spiderman, bettan
        String input;
        input = "snisse";
        assertTrue("Username " + input + " should be valid", new UsernameValidator(input).validate().isValid());
        input = "spiderman";
        assertTrue("Username " + input + " should be valid", new UsernameValidator(input).validate().isValid());
        input = "ottoman";
        assertTrue("Username " + input + " should be valid", new UsernameValidator(input).validate().isValid());
        input = "bettan";
        assertTrue("Username " + input + " should be valid", new UsernameValidator(input).validate().isValid());
    }
    
    @Test
    public void check_invalid_Username() {
        String input;
        input = "tomtenissen";
        assertFalse("Username " + input + " should be invalid", new UsernameValidator(input).validate().isValid());
        input = "mary-jane";
        assertFalse("Username " + input + " should be invalid", new UsernameValidator(input).validate().isValid());
        input = "sofa";
        assertFalse("Username " + input + " should be invalid", new UsernameValidator(input).validate().isValid());
        input = "snisse2";
        assertFalse("Username " + input + " should be invalid", new UsernameValidator(input).validate().isValid());
    }
    
}