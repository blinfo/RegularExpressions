package se.blinfo.regexp.sample;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import java.util.stream.Collectors;
import java.util.stream.Stream;

/**
 * 
 * Search for lines containing (or not containing) one and/or more words.
 * <p>
 * Find lines that matches the regexp and return them as a list of strings.
 * 
 * @author hl
 */
public class TextLineSearch {

    private final String sourceString;
    private static final String REGEXP_WORDS_OR = "^.*\\bWORD_TO_MATCH\\b.*$";
    private static final String REGEXP_WORDS_AND = "^(?=.*?\\bWORD_TO_MATCH\\b).*$";
    private static final String REGEXP_NOT_WORDS_OR = "^((?!.*\\bWORD_TO_MATCH\\b.*).)*$";

    public TextLineSearch(String sourcString) {
        this.sourceString = sourcString;
    }

    public List<String> findAllLinesContainingOneOrMoreOf(String... words) {
        System.out.println(Stream.of(words).collect(Collectors.joining(" ")));
        System.out.println();
        List<String> result = new ArrayList<>();
        String word = Stream.of(words).collect(Collectors.joining("|"));
        String regexp = REGEXP_WORDS_OR.replaceAll("WORD_TO_MATCH", "(" + word + ")");
        System.out.println("RegExp: " + regexp);
        Matcher matcher = Pattern.compile(regexp, Pattern.MULTILINE).matcher(sourceString);
        while (matcher.find()) {
            result.add(matcher.group());
        }
        return result;
    }

    public List<String> findAllLinesContainingAllOf(String... words) {
        System.out.println(Stream.of(words).collect(Collectors.joining(" ")));
        System.out.println();
        List<String> result = new ArrayList<>();
        String word = Stream.of(words).collect(Collectors.joining("\\\\b)(?=.*?\\\\b"));
        String regexp = REGEXP_WORDS_AND.replaceAll("WORD_TO_MATCH", word);
        System.out.println("RegExp: " + regexp);
        Matcher matcher = Pattern.compile(regexp, Pattern.MULTILINE).matcher(sourceString);
        while (matcher.find()) {
            result.add(matcher.group());
        }
        return result;
    }

    public Optional<String> findFirstLineContainingOneOrMoreOf(String... words) {
        System.out.println(Stream.of(words).collect(Collectors.joining(" ")));
        System.out.println();
        String word = Stream.of(words).collect(Collectors.joining("|"));
        String regexp = REGEXP_WORDS_OR.replaceAll("WORD_TO_MATCH", "(" + word + ")");
        System.out.println("RegExp: " + regexp);
        Matcher matcher = Pattern.compile(regexp, Pattern.MULTILINE).matcher(sourceString);
        while (matcher.find()) {
            return Optional.of(matcher.group());
        }
        return Optional.empty();
    }

    /**
     * Observe that this method is case sensitive.
     *
     * @param words
     * @return
     */
    public List<String> findAllLinesNotContainingOneOrMoreOf(String... words) {
        System.out.println(Stream.of(words).collect(Collectors.joining(" ")));
        System.out.println();
        List<String> result = new ArrayList<>();
        String word = Stream.of(words).collect(Collectors.joining("|"));
        String regexp = REGEXP_NOT_WORDS_OR.replaceAll("WORD_TO_MATCH", "(" + word + ")");
        System.out.println("RegExp: " + regexp);
        Matcher matcher = Pattern.compile(regexp, Pattern.MULTILINE).matcher(sourceString);
        while (matcher.find()) {
            result.add(matcher.group());
        }
        return result;
    }

    public static void main(String[] args) {
        String sourceString = new BufferedReader(new InputStreamReader(TextLineSearch.class.getResourceAsStream("/Abelus.txt")))
                .lines().collect(Collectors.joining("\n"));
        System.out.println("All lines containing one or more of:");
        new TextLineSearch(sourceString).findAllLinesContainingOneOrMoreOf("viverra", "leo", "cras").forEach(System.out::println);

        System.out.println("");
        System.out.println("############");
        System.out.println("All lines containing all of:");
        new TextLineSearch(sourceString).findAllLinesContainingAllOf("viverra", "cursus").forEach(System.out::println);

        System.out.println("");
        System.out.println("############");
        System.out.println("First line containing one or more of:");
        new TextLineSearch(sourceString).findFirstLineContainingOneOrMoreOf("viverra", "leo", "cras").ifPresent(System.out::println);

        System.out.println("");
        System.out.println("############");
        System.out.println("All lines NOT containing one or more of:");
        new TextLineSearch(sourceString).findAllLinesNotContainingOneOrMoreOf("viverra", "leo", "cras").forEach(System.out::println);
    }

}
