package se.blinfo.regexp.sample;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 *
 * @author hl
 */
public abstract class AbstractValidator implements Validator {

    protected final String input;
    protected final String regExp;
    protected Matcher matcher;

    public AbstractValidator(String input, String regExp) {
        this.input = input;
        this.regExp = regExp;
    }

    @Override
    public Result validate() {
        if (regExp == null || regExp.isEmpty()) {
            throw new IllegalArgumentException("The regular expression must not be null or empty string!");
        }
        matcher = Pattern.compile(regExp).matcher(input);
        return new Result(input, regExp, matcher.matches());
    }
}
