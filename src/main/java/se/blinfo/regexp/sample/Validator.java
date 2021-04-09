package se.blinfo.regexp.sample;

/**
 *
 * @author hl
 */
public interface Validator {
    
    Result validate();

    public class Result {

        private final String input;
        private final String regExp;
        private final Boolean valid;

        protected Result(String input, String regExp, Boolean valid) {
            this.input = input;
            this.regExp = regExp;
            this.valid = valid;
        }

        public String getInput() {
            return input;
        }

        public String getRegExp() {
            return regExp;
        }

        public Boolean isValid() {
            return valid;
        }

        @Override
        public String toString() {
            return "Result: \"" + input + "\" - \"" + regExp + "\" - valid = " + valid.toString();
        }
    }
}
