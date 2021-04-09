package se.blinfo.regexp.exercise;

import java.util.Optional;
import se.blinfo.regexp.RegExpException;
import se.blinfo.regexp.sample.AbstractValidator;

/**
 * Validate phone numbers.
 *
 * The valid formats are:
 * <ul>
 * <li>+46 70 4235734</li>
 * <li>073 1239574</li>
 * <li>0650 541490</li>
 * <li>+46 650 541490</li>
 * <li>060 5411490</li>
 * <li>+46 60 541490</li>
 * <li>08 54114290</li>
 * <li>+46 8 54114290</li>
 * </ul>
 * I.e. optional country number (one through three digits with + as suffix),
 * region (one through three digits with no leading zero if country code is
 * provided, otherwise with a required leading zero) and the actual number (five
 * through eight digits). The different parts should be separated by one space.
 * <p>
 * <b>Extra:</b>
 * Implement a method to get the different parts of the number with an default
 * country code if it's missing (default value: "+46").
 *
 * @author hl
 */
public class PhoneNumberValidator extends AbstractValidator {

    private static final String REGEXP = "";

    public PhoneNumberValidator(String input) {
        super(input, REGEXP);
    }

    public Optional<PhoneNumber> getPhoneNumber() {
        throw new UnsupportedOperationException("This method should be implemented as a part of the exercise.");
    }

    public class PhoneNumber {

        private final String countryCode;
        private final String regionalCode;
        private final String number;
        private static final String DEFAULT_COUNTRY_CODE = "+46";

        public PhoneNumber(String regionCode, String number) {
            this(null, regionCode, number);
        }

        public PhoneNumber(String countryCode, String regionCode, String number) {
            if (regionCode == null) {
                throw new RegExpException("Regional Code must not be null", new NullPointerException());
            }
            this.countryCode = countryCode;
            this.regionalCode = regionCode.startsWith("0") ? regionCode.substring(1) : regionCode;
            this.number = number;
        }

        public String getCountryCode() {
            return Optional.ofNullable(countryCode).orElse(DEFAULT_COUNTRY_CODE);
        }

        public String getRegionalCode() {
            return regionalCode;
        }

        public String getNumber() {
            return number;
        }

        @Override
        public String toString() {
            return getCountryCode() + " " + getRegionalCode() + " " + getNumber();
        }
    }
}
