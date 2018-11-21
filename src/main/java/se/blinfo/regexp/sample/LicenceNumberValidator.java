package se.blinfo.regexp.sample;

import java.util.Arrays;
import java.util.List;

/**
 *
 * @author hl
 */
public class LicenceNumberValidator extends AbstractValidator {

    private static final String REG_EXP = "[A-HJ-PR-UW-Z]{3} {0,1}(0\\d[A-HJ-PR-UW-Z1-9]|[1-9]\\d[A-HJ-PR-UW-Z0-9])";
    /**
     * Letter combinations removed from the licence plate list.
     * <p>
     * Source:
     * https://www.transportstyrelsen.se/sv/vagtrafik/Fordon/Om-registreringsskylt/Byte-av-registreringsnummer/Sparrade-bokstavskombinationer/
     *
     *
     */
    public static final List<String> BLOCKED_LETTER_COMBINATIONS = Arrays.asList("APA", 
            "ARG", "ASS", "BAJ", "BSS", "CUC", "CUK", "DUM", "ETA", "ETT", "FAG", "FAN", 
            "FEG", "FEL", "FEM", "FES", "FET", "FNL", "FUC", "FUK", "FUL", "GAM", "GAY",
            "GEJ", "GEY", "GHB", "GUD", "GYN", "HAT", "HBT", "HKH", "HOR", "HOT", "KGB",
            "KKK", "KUC", "KUF", "KUG", "KUK", "KYK", "LAM", "LAT", "LEM", "LOJ", "LSD",
            "LUS", "MAD", "MAO", "MEN", "MES", "MLB", "MUS", "NAZ", "NRP", "NSF", "NYP",
            "OND", "OOO", "ORM", "PAJ", "PKK", "PLO", "PMS", "PUB", "RAP", "RAS", "ROM",
            "RPS", "RUS", "SEG", "SEX", "SJU", "SOS", "SPY", "SUG", "SUP", "SUR", "TBC",
            "TOA", "TOK", "TRE", "TYP", "UFO", "USA", "WAM", "WAR", "WWW", "XTC", "XTZ",
            "XXL", "XXX", "ZEX", "ZOG", "ZPY", "ZUG", "ZUP", "ZOO");

    public LicenceNumberValidator(String input) {
        super(input, REG_EXP);
    }

    /**
     * Validate the Swedish licence plate number
     * <ol>
     * <li>Check that the input string matches the pattern</li>
     * <li>If it is a pattern match, check that the letter combination is not
     * one of the blocked combinations.</li>
     * </ol>
     *
     * @return
     */
    @Override
    public Result validate() {
        boolean valid = input.matches(regExp) ? isValid() : false;
        return new Result(input, regExp, valid);
    }

    private boolean isValid() {
        return !BLOCKED_LETTER_COMBINATIONS.contains(input.substring(0, 3));
    }

    public static void main(String[] args) {
        String plate = "HEX 408";
        System.out.println(new LicenceNumberValidator(plate).validate());
        plate = "APA123";
        System.out.println(new LicenceNumberValidator(plate).validate());
        plate = "CPU12Y";
        System.out.println(new LicenceNumberValidator(plate).validate());
        plate = "APB123";
        System.out.println(new LicenceNumberValidator(plate).validate());
    }
}
