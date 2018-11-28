package se.blinfo.regexp.sample;

import java.util.concurrent.ThreadLocalRandom;

/**
 *
 * E. g. 3D6+3
 * 
 * @author hl
 */
public class RolePlayingDieParser {

    private static final String DIE = "D";

    public static Integer roll(String dieString) {
        Integer result = null;
        if (dieString == null) {
            return result;
        }
        int numberOfDice;
        int dieSize;
        String operator = "";
        int modifier = 0;
        if (!dieString.contains(DIE)) {
            return result;
        }
        result = 0;
        try {
            numberOfDice = Integer.valueOf(dieString.substring(0, dieString.indexOf(DIE)));
            if (!dieString.contains("+") && !dieString.contains("-")) {
                dieSize = Integer.valueOf(dieString.substring(dieString.indexOf(DIE) + 1));
            } else if (dieString.contains("+")) {
                dieSize = Integer.valueOf(dieString.substring(dieString.indexOf(DIE) + 1, dieString.indexOf("+")));
                operator = "+";
                modifier = Integer.valueOf(dieString.substring(dieString.indexOf("+") + 1));
            } else {
                dieSize = Integer.valueOf(dieString.substring(dieString.indexOf(DIE) + 1, dieString.indexOf("-")));
                operator = "-";
                modifier = Integer.valueOf(dieString.substring(dieString.indexOf("-") + 1));
            }
        } catch (NumberFormatException ex) {
            return null;
        }
        for (int i = 0; i < numberOfDice; i++) {
            result += ThreadLocalRandom.current().nextInt(1, dieSize + 1);
        }
        if (operator.equals("+")) {
            return result + modifier;
        }
        if (operator.equals("-")) {
            return result - modifier;
        }
        return result;
    }

    public static void main(String[] args) {
        System.out.println(RolePlayingDieParser.roll("1D1+1"));
        System.out.println(RolePlayingDieParser.roll("1D1-1"));
        System.out.println(RolePlayingDieParser.roll("1D1"));
        System.out.println(RolePlayingDieParser.roll("3D10+3"));
        System.out.println(RolePlayingDieParser.roll("3D10*3"));
        System.out.println(RolePlayingDieParser.roll("1D10+10"));
        System.out.println(RolePlayingDieParser.roll(null));
    }
}
