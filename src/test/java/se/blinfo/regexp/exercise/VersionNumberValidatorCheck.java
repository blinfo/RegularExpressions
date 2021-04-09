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
public class VersionNumberValidatorCheck {

    private static final List<String> VALID_VERSIONS = List.of("1.0", "1.2.14", "2.3.121", "0.4", "0.0.3", "0.20.0");
    private static final List<String> INVALID_VERSIONS = List.of("1", "v.1", "1.2.beta", "3.11-SNAPSHOT");

    @Test
    public void test_valid_version_numbers() {
        VALID_VERSIONS.forEach(number -> {
            assertTrue(number + " should be valid", new VersionNumberValidator(number).validate().isValid());
        });
    }

    @Test
    public void test_invalid_version_numbers() {
        INVALID_VERSIONS.forEach(number -> {
            assertFalse(number + " should be valid", new VersionNumberValidator(number).validate().isValid());
        });
    }
    
    @Test
    public void test_getVersion() {
        String input;
        VersionNumberValidator validator;
        input = "1.0.35";
        validator = new VersionNumberValidator(input);
        assertTrue("There should be a version present", validator.getVersion().isPresent());
        VersionNumberValidator.Version version = validator.getVersion().get();
        assertEquals("Major version should be 1", 1l, version.getMajor().longValue());
        assertEquals("Minor version should be 0", 0l, version.getMinor().longValue());
        assertTrue("BugFix version should be present", version.getBugFix().isPresent());
        assertEquals("BugFix version should be 35", 35l, version.getBugFix().get().longValue());
        input = "v.1.0";
        validator = new VersionNumberValidator(input);
        assertTrue("There should not be a version present", validator.getVersion().isEmpty());
    }
}
