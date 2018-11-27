package se.blinfo.regexp;

/**
 *
 * @author hl
 */
public class RegExpTryOut {

    private final String regexp;
    private final String input;

    public RegExpTryOut(String regexp, String input) {
        this.regexp = regexp;
        this.input = input;
    }

    public boolean isMatch() {
        return input.matches(regexp);
    }

    public static void main(String[] args) {
        String input = "#IB\t-1\t1030\t1503.04";
//        input = "#IB\t-1\t1030\t1503";
        String regexp = "#([A-Z]{2})\\s+([-\\d]+)\\s+(\\d{4})\\s+([-+]?\\d*\\.?\\d+)";
        System.out.println(new RegExpTryOut(regexp, input).isMatch());
    }
}
