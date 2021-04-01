package se.blinfo.regexp.exercise;

import java.util.Arrays;
import java.util.List;
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

    public Name getName() {
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
            if (getInitials().isPresent()) {
                return "Name{" + "familyName=" + familyName + ", givenName=" + givenName + ", initials=" + initials + '}';
            }
            return "Name{" + "familyName=" + familyName + ", givenName=" + givenName + "}";
        }

    }

    public static void main(String[] args) {
        System.out.println("The following should validate to \"true\"");
        List<String> validInput = Arrays.asList("Snissesson-Kahm, Ulla-Lisa T. T.","Persson, Leif G. W.", "Öijer, Fredrika K.", "Lidén, Karl Håkan", "Cæsar, Julia", "Karlsson-Andersson, Pär-Uno");
        validInput.forEach(s -> System.out.println(new NameValidator(s).validate()));
        System.out.println("\nThe following should validate to \"false\"");
        List<String> invalidInput = Arrays.asList("Fredrika K. Öijer", "Håkan Lidén", "Julia Cæsar", "Picasso");
        invalidInput.forEach(s -> System.out.println(new NameValidator(s).validate()));
    }
}
