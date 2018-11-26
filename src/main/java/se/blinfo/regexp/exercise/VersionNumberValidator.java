package se.blinfo.regexp.exercise;

import java.util.Arrays;
import java.util.List;
import java.util.stream.IntStream;
import se.blinfo.regexp.sample.AbstractValidator;

/**
 *
 * @author hl
 */
public class VersionNumberValidator extends AbstractValidator {

    private static final String REGEXP = "";

    public VersionNumberValidator(String input) {
        super(input, REGEXP);
    }

    public Version getVersion() {
        throw new UnsupportedOperationException("This method should be implemented as a part of the exercise.");
    }

    public static class Version {

        private final Integer major;
        private final Integer minor;
        private final Integer bugFix;

        public Version(String major, String minor, String bugFix) {
            this.major = Integer.valueOf(major);
            this.minor = Integer.valueOf(minor);
            this.bugFix = bugFix != null ? Integer.valueOf(bugFix) : null;
        }

        public Integer getMajor() {
            return major;
        }

        public Integer getMinor() {
            return minor;
        }

        public Integer getBugFix() {
            return bugFix;
        }

        @Override
        public String toString() {
            if (getBugFix() != null) {
                return "Version{" + "major: " + major + ", minor: " + minor + ", bugFix: " + bugFix + "}";
            }
            return "Version{" + "major: " + major + ", minor: " + minor + "}";
        }

    }

    public static void main(String[] args) {
        System.out.println("The following should validate to \"true\"");
        List<String> validInput = Arrays.asList("1.0", "1.2.14", "2.3.121", "0.4");
        validInput.forEach(s -> System.out.println(new VersionNumberValidator(s).validate()));
        IntStream.range(0, 5).forEach(i -> {
            System.out.println(new VersionNumberValidator(i + "." + 3 + "." + i).validate());
        });
        System.out.println("\nThe following should validate to \"false\"");
        List<String> invalidInput = Arrays.asList("1",
                "v.1", "1.2.beta",
                "3.11-SNAPSHOT");
        invalidInput.forEach(s -> System.out.println(new VersionNumberValidator(s).validate()));
        System.out.println(new VersionNumberValidator("2.0.61").getVersion());
    }

}
