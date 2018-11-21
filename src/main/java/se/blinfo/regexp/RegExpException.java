package se.blinfo.regexp;

/**
 *
 * @author hl
 */
public class RegExpException extends RuntimeException {

    public RegExpException(String message, Throwable cause) {
        super(message, cause);
    }

    public RegExpException(String regexp, String string, Boolean expectedResult) {
        super("The string \"" + string + "\" is wrongly matched by the regexp \""
                + regexp + "\". Expected result was matches = " + expectedResult.toString());
    }

}
