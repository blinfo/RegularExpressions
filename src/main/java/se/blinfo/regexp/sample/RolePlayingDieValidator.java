package se.blinfo.regexp.sample;

/**
 * Validate a string to se if it is a valid die combination.
 * <p>
 * The combination is:
 * <ol>
 * <li>number of dice</li>
 * <li>letter D (or T) for "Dice" (or "Tärning)</li>
 * <li>number of sides to the die<li>
 * <li>optional "+" or "-" for adjustments</li>
 * <li>optional value to add or subtract, depending on the previous character</li>
 * </ol>
 *
 * @author hl
 */
public class RolePlayingDieValidator extends AbstractValidator {

    private static final String REG_EXP = ".*\\d+[dDtT]\\d+([-+]?\\d*)?.*";

    public RolePlayingDieValidator(String input) {
        super(input, REG_EXP);
    }

    @Override
    public Result validate() {
        return new Result(input, regExp, input.matches(regExp));
    }

    public static void main(String[] args) {
        System.out.println(new RolePlayingDieValidator("3D10+3").validate());
        System.out.println(new RolePlayingDieValidator("3D10-3").validate());
        System.out.println(new RolePlayingDieValidator("Roll 3D10 for damage.").validate());
    }
}
