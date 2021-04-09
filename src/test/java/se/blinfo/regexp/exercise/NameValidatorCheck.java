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
public class NameValidatorCheck {

    private static final List<String> VALID_NAMES = List.of("Persson, Leif G. W.", "Öijer, Fredrika K.", "Lidén, Karl Håkan", "Cæsar, Julia", "Andersson-Karlsson, Pär-Uno", "Lund Berg, Lisa");
    private static final List<String> INVALID_NAMES = List.of("Leif G. W. Persson", "Picasso", "Heidi Engdahl");

    @Test
    public void test_valid_names() {
        VALID_NAMES.forEach(name -> {
            assertTrue(name + " does not validate", new NameValidator(name).validate().isValid());
        });
    }

    @Test
    public void test_invalid_names() {
        INVALID_NAMES.forEach(name -> {
            assertFalse(name + " should not validate", new NameValidator(name).validate().isValid());
        });
    }

    @Test
    public void test_Name() {
        String input;
        NameValidator validator;
        input = "Qvist, Adelina";
        validator = new NameValidator(input);
        assertTrue(input + " does not validate", validator.validate().isValid());
        assertTrue("Validator should have a name", validator.getName().isPresent());
        validator.getName().ifPresent(name -> {
            assertEquals("Family name should be Qvist", "Qvist", name.getFamilyName());
            assertEquals("Given name should be Adelina", "Adelina", name.getGivenName());
            assertTrue("Initials should be empty", name.getInitials().isEmpty());
        });
        input = "Ædhelhår-Stéenbock, Ottilia Tyra-Francesca P. P.";
        validator = new NameValidator(input);
        assertTrue(input + " does not validate", validator.validate().isValid());
        assertTrue("Validator should have a name", validator.getName().isPresent());
        validator.getName().ifPresent(name -> {
            assertEquals("Family name should be Ædhelhår-Stéenbock", "Ædhelhår-Stéenbock", name.getFamilyName());
            assertEquals("Given name should be Ottilia Tyra-Francesca", "Ottilia Tyra-Francesca", name.getGivenName());
            assertTrue("Initials should be present", name.getInitials().isPresent());
            assertEquals("Initials should be P. P.", "P. P.", name.getInitials().get());
        });
    }
}
