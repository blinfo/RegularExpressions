package se.blinfo.regexp.sample;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * An abstract validator.
 *
 * The classes extending this should at least provide the Regular Expression
 * (regExp).
 *
 * @author hl
 */
public abstract class AbstractValidator implements Validator {

    protected final String input;
    protected final String regExp;
    protected final Matcher matcher;

    protected AbstractValidator(String input, String regExp) {
        if (regExp == null || regExp.isEmpty()) {
            throw new IllegalArgumentException("The regular expression must not be null or empty string!");
        }
        this.input = input;
        this.regExp = regExp;
        matcher = Pattern.compile(regExp).matcher(input);
    }

    @Override
    public Result validate() {
        return new Result(input, regExp, matcher.matches());
    }
}
