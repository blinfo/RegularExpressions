package se.blinfo.regexp.sample;

/**
 *
 * Validation of SwedishSocialSecurityNumbers
 * <ol>
 * <li>Check that the input string matches the pattern for security numbers</li>
 * <li>If it is a pattern match, validate the luhn number (check the last
 * digit). If the input string contains more then 10 <i>digits</i>, remove the
 * first two since these are not validated. Also remove the optional hyphen
 * ("-").</li>
 * </ol>
 *
 * @author hl
 */
public class SwedishSocialSecurityNumberValidator extends AbstractValidator {

    private static final String REG_EXP = "(19|20)?\\d{2}(0[1-9]|1[0-2])(0[1-9]|[1-2]\\d|3[0-1])[- ]?\\d{4}";

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
        String luhnNumber = input.replaceAll("-", "");
        if (luhnNumber.length() == 12) {
            luhnNumber = luhnNumber.substring(2);
        }
        int a = 1;
        int sum = 0;
        int term;
        for (int i = luhnNumber.length() - 1; i >= 0; i--) {
            term = Character.digit(luhnNumber.charAt(i), 10) * a;
            if (term > 9) {
                term -= 9;
            }
            sum += term;
            a = 3 - a;
        }
        return sum % 10 == 0;
    }

    public static void main(String[] args) {
        System.out.println(new SwedishSocialSecurityNumberValidator("19641002-8515").validate());
        System.out.println(new SwedishSocialSecurityNumberValidator("196410028515").validate());
        System.out.println(new SwedishSocialSecurityNumberValidator("641002-8515").validate());
        System.out.println(new SwedishSocialSecurityNumberValidator("6410028515").validate());
        System.out.println(new SwedishSocialSecurityNumberValidator("940224-5626").validate());
    }
}
