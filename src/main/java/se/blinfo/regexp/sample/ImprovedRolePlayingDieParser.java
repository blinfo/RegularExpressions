package se.blinfo.regexp.sample;

import java.util.concurrent.ThreadLocalRandom;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import java.util.stream.IntStream;

/**
 *
 * Validate a string to se if it contains a valid die combination, then perform
 * the roll.
 * <p>
 * The valid combination is:
 * <ol>
 * <li>number of dice</li>
 * <li>lower or upper case letter D (or T) for "Dice" (or "Tärning)</li>
 * <li>number of sides to the die</li>
 * <li>optional "+" or "-" for adjustments</li>
 * <li>optional value to add or subtract, depending on the previous
 * character</li>
 * </ol>
 * E. g. "3D6+3", "1D10-1" or "4D4"
 * <p>
 * If the input string contains a valid die-string this is extracted, parsed and
 * the roll is performed and returned.
 * <p>
 * If you like, improve this further by limiting the dice to ordinary die sizes
 * (2, 3, 4, 6, 8, 10, 12, 20 and 100).
 *
 * @author hl
 */
public class ImprovedRolePlayingDieParser {

    private static final String REG_EXP = ".*(\\d+)[dDtT](\\d+)(?:([-+])(\\d+))?.*";
    private static final Pattern PATTERN = Pattern.compile(REG_EXP);
    private static final int NUMBER_OF_DICE = 1,
            DIE_MAX = 2, OPERATOR = 3, MODIFIER = 4;

    public static Integer roll(String dieString) {
        if (dieString == null) {
            return null;
        }
        Matcher matcher = PATTERN.matcher(dieString);
        if (!matcher.matches()) {
            return null;
        }
        matcher.reset();
        if (matcher.find()) {
//            for (int i = 0; i < matcher.groupCount(); i++) {
//                System.out.println(matcher.group(i + 1));
//            }
            return IntStream.range(0, Integer.parseInt(matcher.group(NUMBER_OF_DICE)))
                    .map(i -> rollDie(matcher.group(DIE_MAX)))
                    .reduce((a, b) -> a + b).orElse(0) + getModifierValue(matcher.group(OPERATOR), matcher.group(MODIFIER));
        }
        return null;
    }

    private static int rollDie(String dieMax) {
        return ThreadLocalRandom.current().nextInt(0, Integer.parseInt(dieMax)) + 1;
    }

    private static int getModifierValue(String operator, String modifier) {
        int result = modifier == null || modifier.isEmpty() ? 0 : Integer.valueOf(modifier);
        return operator == null || operator.isEmpty() ? 0 : operator.equals("-") ? 0 - result : result;
    }

    public static void main(String[] args) {
        System.out.println(ImprovedRolePlayingDieParser.roll("1D1+1"));
        System.out.println(ImprovedRolePlayingDieParser.roll("1D1-1"));
        System.out.println(ImprovedRolePlayingDieParser.roll("1D1"));
        System.out.println(ImprovedRolePlayingDieParser.roll("Roll 3D10+3"));
        System.out.println(ImprovedRolePlayingDieParser.roll("HP: 3D10*3"));
        System.out.println(ImprovedRolePlayingDieParser.roll("1D10+10"));
        System.out.println(ImprovedRolePlayingDieParser.roll("Roll 1D100 three times for items from table 14.1"));
        System.out.println(ImprovedRolePlayingDieParser.roll(null));
    }
}
