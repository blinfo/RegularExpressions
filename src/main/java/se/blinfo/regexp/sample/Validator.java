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
        private final Boolean result;

        public Result(String input, String regExp, Boolean result) {
            this.input = input;
            this.regExp = regExp;
            this.result = result;
        }

        @Override
        public String toString() {
            return "Result: \"" + input + "\" - \"" + regExp + "\" - match = " + result.toString();
        }
    }
}
