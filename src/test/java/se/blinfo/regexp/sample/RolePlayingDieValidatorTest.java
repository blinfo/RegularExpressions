package se.blinfo.regexp.sample;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;
import org.junit.Test;

/**
 *
 * @author Håkan Lidén
 */
public class RolePlayingDieValidatorTest {

    @Test
    public void test_valid_die_patterns() {
        String diePattern;
        diePattern = "3D10+3";
        assertTrue("Die pattern " + diePattern + " should be valid", new RolePlayingDieValidator(diePattern).validate().isValid());
        diePattern = "2T6-2";
        assertTrue("Die pattern " + diePattern + " should be valid", new RolePlayingDieValidator(diePattern).validate().isValid());
        diePattern = "Roll 2d4 for damage.";
        assertTrue("Die pattern " + diePattern + " should be valid", new RolePlayingDieValidator(diePattern).validate().isValid());
    }
    @Test
    public void test_invalid_die_patterns() {
        String diePattern;
        diePattern = "3D10*3";
        assertFalse("Die pattern " + diePattern + " should be valid", new RolePlayingDieValidator(diePattern).validate().isValid());
        diePattern = "2T6/2";
        assertFalse("Die pattern " + diePattern + " should be valid", new RolePlayingDieValidator(diePattern).validate().isValid());
        diePattern = "Roll 2L4 for damage.";
        assertFalse("Die pattern " + diePattern + " should be valid", new RolePlayingDieValidator(diePattern).validate().isValid());
    }

}
