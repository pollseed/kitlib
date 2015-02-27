package pollseed.tools.helper;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileOutputStream;
import java.io.FileReader;
import java.io.IOException;
import java.io.OutputStreamWriter;

import org.apache.commons.io.IOUtils;
import org.junit.Test;

public class FileParserTest {
    private final String FORMAT_LOGGER = "UNIT_TEST [%s] %s";

    // TODO test method
    public void test_FileParser() {
        System.out.println(String.format(FORMAT_LOGGER, FileReader.class, "start"));
        BufferedReader in = null;
        BufferedWriter out = null;
        String uploadPath = "/src/test/resources/pollseed/tools/helper/output/test_FileParser.txt";
        File file = new File(uploadPath);
        try {
            in = new BufferedReader(new FileReader(new File("/src/test/resources/pollseed/tools/helper/test_FileParser.txt")));

            out = new BufferedWriter(new OutputStreamWriter(new FileOutputStream(file), "UTF-8"));

            String line;
            while ((line = in.readLine()) != null) {
                out.write(line);
                out.newLine();
            }
            out.flush();

        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            IOUtils.closeQuietly(in);
            IOUtils.closeQuietly(out);
            file.delete();
        }
        System.out.println(String.format(FORMAT_LOGGER, FileReader.class, "end"));
    }
}
