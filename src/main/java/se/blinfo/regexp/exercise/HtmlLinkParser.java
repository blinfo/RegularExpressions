package se.blinfo.regexp.exercise;

/**
 *
 * @author hl
 */
public class HtmlLinkParser {

    private final String input;
    private static final String REGEXP = "";

    public HtmlLinkParser(String input) {
        this.input = input;
    }

    public HtmlLink getLink() {
        throw new UnsupportedOperationException("This method should be implemented as a part of the exercise.");
    }

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
    }

    public static void main(String[] args) {
        System.out.println(new HtmlLinkParser("<a href=\"http://www.blinfo.se/\">Björn Lundén information AB</a>").getLink());
    }
}
