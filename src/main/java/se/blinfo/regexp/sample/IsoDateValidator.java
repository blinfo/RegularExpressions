package se.blinfo.regexp.sample;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 *
 * @author hl
 */
public class IsoDateValidator extends AbstractValidator {

    private static final String REG_EXP = "^(1[89]\\d{2}|20\\d{2})-(0[1-9]|1[0-2])-(0[1-9]|[12][0-9]|3[01])$";
    private final Pattern pattern;

    public IsoDateValidator(String input) {
        super(input, REG_EXP);
        pattern = Pattern.compile(regExp);
    }

    @Override
    public Result validate() {
        boolean valid = false;
        Matcher matcher = pattern.matcher(input);
        if (matcher.matches()) {
            // Read the input again.
            matcher.reset();
            if (matcher.find()) {
                Integer year = Integer.parseInt(matcher.group(1));
                Integer month = Integer.parseInt(matcher.group(2));
                Integer day = Integer.parseInt(matcher.group(3));
                switch (month) {
                    case 1:
                    case 3:
                    case 5:
                    case 7:
                    case 8:
                    case 10:
                    case 12:
                        valid = day < 32;
                        break;
                    case 4:
                    case 6:
                    case 9:
                    case 11:
                        valid = day < 31;
                        break;
                    case 2:
                        int modulo100 = year % 100;
                        if ((modulo100 == 0 && year % 400 == 0) || (modulo100 != 0 && year % 4 == 0)) {
                            valid = day < 30;
                        } else {
                            valid = day < 29;
                        }
                    default:
                        break;
                }
            }
        }
        return new Result(input, regExp, valid);
    }

    public static void main(String[] args) {
        System.out.println(new IsoDateValidator("1987-11-30").validate());
    }

}