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
    private static final Pattern CAMEL_CASE = Pattern.compile("(([A-Z])([a-z])*)");
    private static final Pattern HYPHEN = Pattern.compile("(([a-z])([a-z]*))");

    public TextTransformer(String sourceString) {
        this.sourceString = sourceString;
    }

    public String camelCaseToHyphen() {
        Matcher matcher = CAMEL_CASE.matcher(sourceString);
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
        Matcher matcher = HYPHEN.matcher(sourceString);
        matcher.reset();
        StringBuilder builder = new StringBuilder();
        while (matcher.find()) {
            builder.append(matcher.group(2).toUpperCase());
            builder.append(matcher.group(3).toLowerCase());
        }
        return builder.toString();
    }
}
