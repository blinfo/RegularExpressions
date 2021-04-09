package se.blinfo.regexp.sample;

import static org.junit.Assert.assertEquals;
import org.junit.Test;

/**
 *
 * @author Håkan Lidén
 */
public class TextTransformerTest {

    @Test
    public void test_hyphenation_from_CamelCase() {
        String input = "TheStringToHyphenate";
        String expectedResult = "the-string-to-hyphenate";
        assertEquals("Result should be " + expectedResult, expectedResult, new TextTransformer(input).camelCaseToHyphen());
    }

    @Test
    public void test_CamelCasing_from_hyphen() {
        String input = "the-string-to-camel-case";
        String expectedResult = "TheStringToCamelCase";
        assertEquals("Result should be " + expectedResult, expectedResult, new TextTransformer(input).hyphenToCamelCase());
    }
}
