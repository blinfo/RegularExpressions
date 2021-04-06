package se.blinfo.regexp.sample;

/**
 *
 * This class validates an ISO 8601 date string.
 * <p>
 * If the input string follows the valid pattern a further validation is done to
 * see if the number of days for each month is within range.
 *
 * @author hl
 */
public class IsoDateValidator extends AbstractValidator {

    private static final String REG_EXP = "(1[89]\\d{2}|20\\d{2})-(0[1-9]|1[0-2])-(0[1-9]|[12][0-9]|3[01])";

    public IsoDateValidator(String input) {
        super(input, REG_EXP);
    }

    @Override
    public Result validate() {
        boolean valid = false;
        if (super.validate().isMatch()) {
            // Reset matcher after check if match
            matcher.reset();
            if (matcher.find()) {
                Integer year = Integer.parseInt(matcher.group(1));
                Integer month = Integer.parseInt(matcher.group(2));
                Integer day = Integer.parseInt(matcher.group(3));
                valid = validateDays(month, day, year);
            }
        }
        return new Result(input, regExp, valid);
    }

    private boolean validateDays(Integer month, Integer day, Integer year) {
        switch (month) {
            case 1, 3, 5, 7, 8, 10, 12 -> {
                return day < 32;
            }
            case 4, 6, 9, 11 -> {
                return day < 31;
            }
            case 2 -> {
                int modulo100 = year % 100;
                if ((modulo100 == 0 && year % 400 == 0) || (modulo100 != 0 && year % 4 == 0)) {
                    return day < 30;
                } else {
                    return day < 29;
                }
            }
            default -> {
                return false;
            }
        }
    }

    public static void main(String[] args) {
        System.out.println(new IsoDateValidator("1987-11-30").validate());
        System.out.println(new IsoDateValidator("1987-02-29").validate());
        System.out.println(new IsoDateValidator("1988-02-29").validate());
    }

}
