package se.blinfo.regexp;

import java.util.ArrayList;
import java.util.List;
import se.blinfo.regexp.sample.IsoDateValidator;
import se.blinfo.regexp.sample.LicenceNumberValidator;
import se.blinfo.regexp.sample.SwedishSocialSecurityNumberValidator;
import se.blinfo.regexp.sample.Validator;

/**
 *
 * @author hl
 */
public class RegExpValidate {

    private static final List<Validator> VALIDATOR_LIST = new ArrayList<>();

    static {
        VALIDATOR_LIST.add(new IsoDateValidator("1987-02-18"));
        VALIDATOR_LIST.add(new IsoDateValidator("1987-02-27"));
        VALIDATOR_LIST.add(new IsoDateValidator("1988-02-29"));
        VALIDATOR_LIST.add(new IsoDateValidator("1987-02-29"));
        VALIDATOR_LIST.add(new SwedishSocialSecurityNumberValidator("940224-5626"));
        VALIDATOR_LIST.add(new SwedishSocialSecurityNumberValidator("199402245626"));
        VALIDATOR_LIST.add(new SwedishSocialSecurityNumberValidator("199402245624"));
        VALIDATOR_LIST.add(new SwedishSocialSecurityNumberValidator("9940224-5624"));
        VALIDATOR_LIST.add(new LicenceNumberValidator("HEX 408"));
        VALIDATOR_LIST.add(new LicenceNumberValidator("APB024"));
        VALIDATOR_LIST.add(new LicenceNumberValidator("BUL02A"));
        VALIDATOR_LIST.add(new LicenceNumberValidator("TRW02C"));
        VALIDATOR_LIST.add(new LicenceNumberValidator("hex 408"));
        VALIDATOR_LIST.add(new LicenceNumberValidator("HEX 000"));
        VALIDATOR_LIST.add(new LicenceNumberValidator("BUT 010"));
        VALIDATOR_LIST.add(new LicenceNumberValidator("APV 000"));
        VALIDATOR_LIST.add(new LicenceNumberValidator("WWW123"));
    }
    
    public void run() {
        System.out.println("Result of validations:");
        VALIDATOR_LIST.forEach(v -> System.out.println(v.getClass().getSimpleName() + " - " + v.validate()));
    }
    
    public static void main(String[] args) {
        new RegExpValidate().run();
    }
    
}
