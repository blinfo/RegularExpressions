package se.blinfo.regexp.sample;

import java.util.concurrent.ThreadLocalRandom;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import java.util.stream.IntStream;

/**
 *
 * @author hl
 */
public class RolePlayingDieParser {

    private static final String REG_EXP = "(\\d+)([dDtT]{1})(\\d+)([-*/+]?)(\\d*)";
    private static final Pattern PATTERN = Pattern.compile(REG_EXP);
    private static final int NUMBER_OF_DICE = 1,
            DIE_MAX = 3, OPERATOR = 4, MODIFIER = 5;

    public static Integer roll(String die) {
        Matcher matcher = PATTERN.matcher(die);
        if (!matcher.matches()) {
            return 0;
        }
        matcher.reset();
        if (!matcher.find()) {
            return 0;
        }
        try {
            int modifier = matcher.group(MODIFIER).isEmpty() ? 0 : Integer.parseInt(matcher.group(MODIFIER));
            Integer result = IntStream.range(0, Integer.parseInt(matcher.group(NUMBER_OF_DICE)))
                    .map(i -> rollDie(matcher.group(DIE_MAX)))
                    .reduce((a, b) -> a + b).orElse(0);
            return matcher.group(OPERATOR).equals("-")
                    ? result - modifier
                    : matcher.group(OPERATOR).equals("+")
                    ? result + modifier
                    : result;
        } catch (NumberFormatException e) {
            return 0;
        }
    }

    private static int rollDie(String dieMax) throws NumberFormatException {
        return ThreadLocalRandom.current().nextInt(0, Integer.parseInt(dieMax)) + 1;
    }
}
