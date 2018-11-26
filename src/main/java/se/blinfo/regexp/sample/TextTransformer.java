package se.blinfo.regexp.sample;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 *
 * Parse text to or from camel case or hyphen.
 * <p>
 * Parse a CamelCased string like a class name (TextTransformer) to separate
 * lower case words concatenated with hyphyens (text-transformer) or the other
 * way around.
 *
 * @author hl
 */
public class TextTransformer {

    private final String sourceString;
    private static final String REGEXP_CAMEL_CASE = "(([A-Z])([a-z])*)";
    private static final String REGEXP_HYPHEN = "(([a-z])([a-z]*))";

    public TextTransformer(String sourceString) {
        this.sourceString = sourceString;
    }

    public String camelCaseToHyphen() {
        Matcher matcher = Pattern.compile(REGEXP_CAMEL_CASE).matcher(sourceString);
        StringBuilder builder = new StringBuilder();
        while (matcher.find()) {
            if (!builder.toString().isEmpty()) {
                builder.append("-");
            }
            builder.append(matcher.group().toLowerCase());
        }
        return builder.toString();
    }

    public String hyphenToCamelCase() {
        Matcher matcher = Pattern.compile(REGEXP_HYPHEN).matcher(sourceString);
        matcher.reset();
        StringBuilder builder = new StringBuilder();
        while (matcher.find()) {
            builder.append(matcher.group(2).toUpperCase());
            builder.append(matcher.group(3).toLowerCase());
        }
        return builder.toString();
    }

    public static void main(String[] args) {
        String string;
        string = "TheInputStringToTransform";
//        string = "AStringToTransform";
//        string = TextTransformer.class.getSimpleName();
        System.out.println(string);
        string = new TextTransformer(string).camelCaseToHyphen();
        System.out.println(string);
        string = new TextTransformer(string).hyphenToCamelCase();
        System.out.println(string);

    }
}
