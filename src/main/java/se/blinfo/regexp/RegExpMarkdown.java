package se.blinfo.regexp;

import java.io.File;
import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author hl
 */
public class RegExpMarkdown {

    private final SourceProvider provider = new SourceProvider();
    private final File file;

    public RegExpMarkdown(File file) {
        this.file = file;
    }

    public File write() throws RegExpException {
        return write(true);
    }

    public File write(boolean incluedAlternative) throws RegExpException {
        try {
            return new SimpleFileWriter(getMarkDown(incluedAlternative), file).write();
        } catch (IOException ex) {
            throw new RegExpException("Could not create Markdown File", ex);
        }
    }

    public String getMarkDown() {
        return getMarkDown(true);
    }

    public String getMarkDown(boolean includeAlternative) {
        StringBuilder builder = new StringBuilder("<p>\n<i>This file is auto generated. Any changes made to it will disappear with next build.</i>\n</p>\n");
        builder.append("<p>\n<a href=\"https://github.com/blinfo/RegularExpressions/wiki\"><b>Wiki page</b></a>\n</p>\n");
        builder.append("<a name=\"toc\"> </a>\n# Regular Expressions \n\n");
        provider.getExpressions().forEach(re -> {
            builder.append("  * <a href=\"#").append(re.getTitle().toLowerCase().replaceAll(" ", "-")).append("\">")
                    .append(re.getTitle()).append("</a>\n");
        });
        builder.append("\n\n");
        provider.getExpressions().forEach(re -> {
            builder.append("---\n\n").append("<a name=\"").append(re.getTitle().toLowerCase().replaceAll(" ", "-")).append("\"> </a>")
                    .append("\n### ").append(re.getTitle()).append("\n\n");
            builder.append("**Expression**: `").append(re.getRegexp().replaceAll("\\\\", "\\\\\\\\")).append("`\n\n");
            if (re.getAlternativeRegexp() != null) {
                builder.append("**Alternative**: `").append(re.getAlternativeRegexp().replaceAll("\\\\", "\\\\\\\\")).append("`\n\n");
            }
            builder.append(re.getDescription().replaceAll("\\\\", "\\\\\\\\").replaceAll("\n", "  \n")).append("\n\n");
            builder.append("  _Matches:_").append("\n\n");
            re.getMatches().forEach(string -> {
                if (!string.matches(re.getRegexp())) {
                    Logger.getLogger(RegExpMarkdown.class.getName())
                            .log(Level.WARNING, "Failed match", new RegExpException(re.getRegexp(), string, true));
                }

                builder.append("  * ").append(string.matches(re.getRegexp()))
                        .append("\t\"").append(string).append("\"\n");
            });
            builder.append("\n  _Non Matches:_").append("\n\n");
            re.getNonMatches().forEach(string -> {
                if (string.matches(re.getRegexp())) {
                    Logger.getLogger(RegExpMarkdown.class.getName())
                            .log(Level.WARNING, "Failed match", new RegExpException(re.getRegexp(), string, false));
                }
                builder.append("  * ").append(string.matches(re.getRegexp()))
                        .append("\t\"").append(string).append("\"\n");
            });
            builder.append("\n");
            if (includeAlternative && re.getAlternativeRegexp() != null) {
                builder.append("With alternative writing:\n\n");
                builder.append("  _Matches:_").append("\n\n");
                re.getMatches().forEach(string -> {
                    if (!string.matches(re.getAlternativeRegexp())) {
                        Logger.getLogger(RegExpMarkdown.class.getName())
                                .log(Level.WARNING, "Failed match", new RegExpException(re.getAlternativeRegexp(), string, true));
                    }
                    builder.append("  * ").append(string.matches(re.getAlternativeRegexp()))
                            .append("\t\"").append(string).append("\"\n");
                });
                builder.append("\n  _Non Matches:_").append("\n\n");
                re.getNonMatches().forEach(string -> {
                    if (string.matches(re.getAlternativeRegexp())) {
                        Logger.getLogger(RegExpMarkdown.class.getName())
                                .log(Level.WARNING, "Failed match", new RegExpException(re.getAlternativeRegexp(), string, false));
                    }
                    builder.append("  * ").append(string.matches(re.getAlternativeRegexp()))
                            .append("\t\"").append(string).append("\"\n");
                });
            }
            builder.append("\n\n<a href=\"#toc\">^</a>").append("\n\n");
        });
        return builder.toString();
    }
}
