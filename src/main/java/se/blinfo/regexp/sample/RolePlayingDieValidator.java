package se.blinfo.regexp.sample;

/**
 *
 * @author hl
 */
public class RolePlayingDieValidator extends AbstractValidator {

    private static final String REG_EXP = "(\\d+)([dDtT]{1})(\\d+)([-*/+]?)(\\d*)";

    public RolePlayingDieValidator(String input) {
        super(input, REG_EXP);
    }

    @Override
    public Result validate() {
        return new Result(input, regExp, input.matches(regExp));
    }
}
