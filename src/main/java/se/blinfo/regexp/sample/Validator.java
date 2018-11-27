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
        private final Boolean matches;

        public Result(String input, String regExp, Boolean matches) {
            this.input = input;
            this.regExp = regExp;
            this.matches = matches;
        }

        public String getInput() {
            return input;
        }

        public String getRegExp() {
            return regExp;
        }

        public Boolean isMatch() {
            return matches;
        }

        @Override
        public String toString() {
            return "Result: \"" + input + "\" - \"" + regExp + "\" - match = " + matches.toString();
        }
    }
}
