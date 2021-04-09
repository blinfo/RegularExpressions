package se.blinfo.regexp.exercise;

import java.util.Optional;

/**
 * Create a regexp to extract the URL and the link text from an ordinary link.
 * The link should be an ordinary HTML-link, i. e.
 * <code>&lt;a href="http://bjornlunden.se/"&gt;Björn Lundén AB&lt;/a&gt;</code>.
 * <p>
 * Also, create a method that checks if the input matches your regexp and in
 * that case returns an optional HtmlLink. The link above should produce:<br>
 * <code>Björn Lundén AB : http://bjornlunden.se/</code> <br/>
 * by the <b>toString</b> method.
 *
 *
 *
 * @author hl
 */
public class HtmlLinkParser {

    private final String input;
    private static final String REGEXP = "";

    public HtmlLinkParser(String input) {
        this.input = input;
    }

    public Optional<HtmlLink> getLink() {
        throw new UnsupportedOperationException("This method should be implemented as a part of the exercise.");
    }

    /**
     * A simple object holding the url and the link text.
     *
     */
    public static class HtmlLink {

        private final String url;
        private final String text;

        public HtmlLink(String url, String text) {
            this.url = url;
            this.text = text;
        }

        public String getUrl() {
            return url;
        }

        public String getText() {
            return text;
        }

        @Override
        public String toString() {
            return text + " : " + url;
        }

        public String toHtml() {
            return "<a href=\"" + url + "\">" + text + "</a>";
        }
    }
}
