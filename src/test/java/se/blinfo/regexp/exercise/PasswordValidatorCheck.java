package se.blinfo.regexp.exercise;

import java.util.List;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;
import org.junit.Test;

/**
 *
 * @author Håkan Lidén
 */
public class PasswordValidatorCheck {

    private static final List<String> VALID_PASSWORDS = List.of("cå?98UTÆ¥œRZ9", "tv*1ÖX-l4", "qz%51Y@ltP8", "yh$798Å+cc0");
    private static final List<String> INVALID_PASSWORDS = List.of("password", "admin", "myPassword", "cé?98UTÆ¥œRZ9");

    @Test
    public void test_valid_passwords() {
        VALID_PASSWORDS.forEach(passwd -> {
            assertTrue(passwd + " should be valid", new PasswordValidator(passwd).validate().isValid());
        });
    }

    @Test
    public void test_invalid_passwords() {
        INVALID_PASSWORDS.forEach(passwd -> {
            assertFalse(passwd + " should not be valid", new PasswordValidator(passwd).validate().isValid());
        });
    }
}
