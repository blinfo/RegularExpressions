package se.blinfo.regexp;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.Reader;
import java.util.List;

/**
 *
 * @author hl
 */
public class RegExpProvider {

    private final Gson gson;

    public RegExpProvider() {
        this.gson = new GsonBuilder().create();
    }

    public List<RegExp> getExpressions() {
        Reader reader = new BufferedReader(new InputStreamReader(getClass().getResourceAsStream("/regular-expressions.json")));
        return gson.fromJson(reader, RegularExpressions.class).getRegularExpressions();
    }

    private class RegularExpressions {

        List<RegExp> regularExpressions;

        public List<RegExp> getRegularExpressions() {
            return regularExpressions;
        }

        public void setRegularExpressions(List<RegExp> regularExpressions) {
            this.regularExpressions = regularExpressions;
        }

    }

    public static class RegExp {

        private String title;
        private String description;
        private String regexp;
        private String alternativeRegexp;
        private List<String> matches;
        private List<String> nonMatches;

        public String getTitle() {
            return title;
        }

        public void setTitle(String title) {
            this.title = title;
        }

        public String getDescription() {
            return description;
        }

        public void setDescription(String description) {
            this.description = description;
        }

        public String getRegexp() {
            return regexp;
        }

        public void setRegexp(String regexp) {
            this.regexp = regexp;
        }

        public String getAlternativeRegexp() {
            return alternativeRegexp;
        }

        public void setAlternativeRegexp(String alternativeRegexp) {
            this.alternativeRegexp = alternativeRegexp;
        }

        public List<String> getMatches() {
            return matches;
        }

        public void setMatches(List<String> matches) {
            this.matches = matches;
        }

        public List<String> getNonMatches() {
            return nonMatches;
        }

        public void setNonMatches(List<String> nonMatches) {
            this.nonMatches = nonMatches;
        }

    }
}
