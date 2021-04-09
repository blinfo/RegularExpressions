package se.blinfo.regexp.exercise;

import java.util.UUID;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;
import org.junit.Test;

/**
 *
 * @author Håkan Lidén
 */
public class UUIDValidatorCheck {

    @Test
    public void check_valid_UUID() {
        String input = UUID.randomUUID().toString();
        assertTrue("Input " + input + " should be valid", new UUIDValidator(input).validate().isValid());
        input = "862ea32b-77dc-4055-a94f-0c4d43df7901";
        assertTrue("Input " + input + " should be valid", new UUIDValidator(input).validate().isValid());
    }

    @Test
    public void check_invalid_UUID() {
        String input = UUID.randomUUID().toString().toUpperCase();
        assertFalse("Input " + input + " should be invalid", new UUIDValidator(input).validate().isValid());
        input = "862e-a32b-77dc-4055a94f-0c4d43df7901";
        assertFalse("Input " + input + " should be valid", new UUIDValidator(input).validate().isValid());
        input = "862ea32g-77hc-4055-a94i-0c4j43kf790n";
        assertFalse("Input " + input + " should be valid", new UUIDValidator(input).validate().isValid());
    }
}
