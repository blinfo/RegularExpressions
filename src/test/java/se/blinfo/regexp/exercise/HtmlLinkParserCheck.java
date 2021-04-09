package se.blinfo.regexp.exercise;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;
import org.junit.Test;

/**
 *
 * @author Håkan Lidén
 */
public class HtmlLinkParserCheck {

    @Test
    public void check_HtmlLink_parse() {
        String input;
        input = "<a href=\"http://www.bjornlunden.se/\">Björn Lundén AB</a>";
        HtmlLinkParser parser = new HtmlLinkParser(input);
        assertTrue("Parser should have an HtmlLink", parser.getLink().isPresent());
        parser.getLink().ifPresent(htmlLink -> {
            String expectedText = "Björn Lundén AB";
            assertEquals("Expected link text should be " + expectedText, expectedText, htmlLink.getText());
            String expectedUrl = "http://www.bjornlunden.se/";
            assertEquals("Expected link URL should be " + expectedUrl, expectedUrl, htmlLink.getUrl());
            assertEquals("The toHtml method should produce the same html string as the input", input, htmlLink.toHtml());
        });
    }

}
