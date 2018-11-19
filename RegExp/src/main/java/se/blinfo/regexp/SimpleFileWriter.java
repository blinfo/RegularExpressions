package se.blinfo.regexp;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStreamWriter;
import java.io.Writer;
import java.util.logging.Level;
import java.util.logging.Logger;
import java.nio.charset.Charset;

/**
 *
 * @author hl
 */
public class SimpleFileWriter {

    private String content;
    private final File file;

    public SimpleFileWriter(String content, String filename) {
        this(content, new File(filename));
    }

    public SimpleFileWriter(String content, File file) {
        this.content = content;
        this.file = file;
    }

    public File write() throws IOException {
        try (Writer writer = new OutputStreamWriter(new FileOutputStream(file), Charset.defaultCharset())) {
            writer.append(content);
            Logger.getLogger(SimpleFileWriter.class.getName()).log(Level.INFO, "Written to file: {0}", file.getPath());
            return file;
        }
    }
}
