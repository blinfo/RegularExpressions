package se.blinfo.regexp.sample;

import java.time.LocalDate;

/**
 *
 * Validation of SwedishSocialSecurityNumbers.
 *  * <ol>
 * <li>Check that the input string matches the pattern for security numbers</li>
 * <li>If it is a pattern match, the date part of the number is validated (the
 * number "19940229-5621" is a valid luhn number, but an invalid date)</li>
 * <li>If both of the above is true, the luhn number is validated (the last -
 * control - digit is checked). The luhn number consists of yymmddxxxx where the
 * year is represented with only two digits</li>
 * </ol>
 * Added date validation as well. "19940229-5621" is a valid luhn number, but an
 * invalid date.
 * <p>
 * For the Luhn Algorithm:
 * <a href="https://en.wikipedia.org/wiki/Luhn_algorithm">Luhn algorithm
 * (Wikipedia)</a>
 *
 * @author hl
 */
public class SwedishSocialSecurityNumberValidator extends AbstractValidator {

    /**
     * About this Regular Expression.
     * <p>
     * This expression contains five capturing groups: full year, year without
     * century digits, month, day and number, and a non capturing groups for the
     * optional century part of the year.
     *
     */
    public static final String REG_EXP = "((?:19|20)?(\\d{2}))(0[1-9]|1[0-2])(0[1-9]|[1-2]\\d|3[0-1])[- ]?(\\d{4})";
    private static final int FULL_YEAR = 1,
            YEAR = 2,
            MONTH = 3,
            DAY = 4,
            NUMBER = 5;

    public SwedishSocialSecurityNumberValidator(String input) {
        super(input, REG_EXP);
    }

    /**
     *
     * @return
     */
    @Override
    public Result validate() {
        boolean valid = input.matches(regExp) ? isValid() : false;
        return new Result(input, regExp, valid);
    }

    private boolean isValid() {
        matcher.reset();
        matcher.find();
        if (!validateDate(matcher.group(FULL_YEAR), matcher.group(MONTH), matcher.group(DAY))) {
            return false;
        }
        String luhnNumber = matcher.group(YEAR) + matcher.group(MONTH) + matcher.group(DAY) + matcher.group(NUMBER);
        int multiplier = 1;
        int sum = 0;
        int term;
        for (int i = luhnNumber.length() - 1; i >= 0; i--) {
            term = Character.digit(luhnNumber.charAt(i), 10) * multiplier;
            if (term > 9) {
                term -= 9;
            }
            sum += term;
            multiplier = 3 - multiplier;
        }
        return sum % 10 == 0;
    }

    /**
     * Validate that the number of days is correct for the given month and year.
     *
     * @param yearString
     * @param monthString
     * @param dayString
     * @return
     */
    private boolean validateDate(String yearString, String monthString, String dayString) {
        Integer year = Integer.valueOf(yearString);
        Integer month = Integer.valueOf(monthString);
        Integer day = Integer.valueOf(dayString);
        year = ensureCenturyIsProvided(year);
        switch (month) {
            case 1, 3, 5, 7, 8, 10, 12 -> {
                return day < 32;
            }
            case 4, 6, 9, 11 -> {
                return day < 31;
            }
            case 2 -> {
                int modulo100 = year % 100;
                return ((modulo100 == 0 && year % 400 == 0) || (modulo100 != 0 && year % 4 == 0))
                        ? day < 30 : day < 29;
            }
            default -> {
                return false;
            }
        }
    }

    /**
     * Ensure that the date contains century as well.
     * <p>
     * This method checks if the century is provided. Otherwise it adds it with
     * the assumption that the number provided represents someone less than a
     * hundred years of age.
     *
     * @param year
     * @return
     */
    private Integer ensureCenturyIsProvided(Integer year) {
        if (year < 100) {
            year += (year < LocalDate.now().getYear() - 2000) ? 2000 : 1900;
        }
        return year;
    }
}
