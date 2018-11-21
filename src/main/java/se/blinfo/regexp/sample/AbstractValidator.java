package se.blinfo.regexp.sample;

/**
 *
 * @author hl
 */
abstract class AbstractValidator implements Validator {

    protected final String input;
    protected final String regExp;

    public AbstractValidator(String input, String regExp) {
        this.input = input;
        this.regExp = regExp;
    }

}
