package se.blinfo.regexp.exercise;

import java.util.Optional;
import se.blinfo.regexp.sample.AbstractValidator;

/**
 * For the purpose of this exercise, numbering is only done with digits and
 * dots. A minimum of major and minor version numbers is required, i. e. "1.0",
 * "0.7"
 * <p>
 * Valid numbers:
 * <ol>
 * <li>1.3</li>
 * <li>0.5</li>
 * <li>2.121.19</li>
 * <li>1.0</li>
 * </ol>
 * <p>
 * Invalid numbers:
 * <ol>
 * <li>1</li>
 * <li>v1</li>
 * <li>v.1.BETA</li>
 * <li>0.0.4-SNAPSHOT</li>
 * </ol>
 *
 * @author hl
 */
public class VersionNumberValidator extends AbstractValidator {

    private static final String REGEXP = "";

    public VersionNumberValidator(String input) {
        super(input, REGEXP);
    }

    public Optional<Version> getVersion() {
        throw new UnsupportedOperationException("This method should be implemented as a part of the exercise.");
    }

    public static class Version {

        private final Integer major;
        private final Integer minor;
        private final Integer bugFix;

        public Version(String major, String minor, String bugFix) {
            this.major = Integer.valueOf(major);
            this.minor = Integer.valueOf(minor);
            this.bugFix = bugFix == null ? null : Integer.valueOf(bugFix);
        }

        public Integer getMajor() {
            return major;
        }

        public Integer getMinor() {
            return minor;
        }

        public Optional<Integer> getBugFix() {
            return Optional.ofNullable(bugFix);
        }

        @Override
        public String toString() {
            return "Version{"
                    + "major: " + major + ", "
                    + "minor: " + minor
                    + getBugFix().map(bf -> ", bugFix: " + bf).orElse("")
                    + '}';
        }
    }
}
