package se.blinfo.regexp.exercise;

import java.util.Optional;
import se.blinfo.regexp.sample.AbstractValidator;

/**
 *
 * Validate that the name have been entered in the prescribed way.
 * <p>
 * Expected patterns:<br>
 * familyName(s, maximum 2), givenName(s, maximum 4), (optional) initials (with
 * dot).
 * <ol>
 * <li>Persson, Leif G. W.</li>
 * <li>Öijer, Fredrika K.</li>
 * <li>Lidén, Karl Håkan</li>
 * <li>Cæsar, Julia</li>
 * <li>Andersson-Karlsson, Pär-Uno</li>
 * <li>Lund Berg, Lisa</li>
 * </ol>
 * Also implement the method that populates and returns the input string as a
 * name object.
 *
 * @author hl
 */
public class NameValidator extends AbstractValidator {

    private static final String REGEXP = "";

    public NameValidator(String input) {
        super(input, REGEXP);
    }

    public Optional<Name> getName() {
        throw new UnsupportedOperationException("This method should be implemented as a part of the exercise.");
    }

    public static class Name {

        private final String familyName;
        private final String givenName;
        private final String initials;

        public Name(String familyName, String givenName, String initials) {
            this.familyName = familyName;
            this.givenName = givenName;
            this.initials = initials;
        }

        public String getFamilyName() {
            return familyName;
        }

        public String getGivenName() {
            return givenName;
        }

        public Optional<String> getInitials() {
            return Optional.ofNullable(initials);
        }

        @Override
        public String toString() {
            return "Name{"
                    + "familyName=" + familyName + ", "
                    + "givenName=" + givenName
                    + getInitials().map(in -> ", initials=" + in).orElse("")
                    + '}';
        }

    }
}
