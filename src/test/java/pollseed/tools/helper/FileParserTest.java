package pollseed.tools.helper;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;

import junit.framework.Assert;

import org.junit.Test;

public class FileParserTest {

    private final String WORK_DIR = String.format("%s%s", System.getProperty("user.dir"), "/src/test/resources/pollseed/tools/helper/");
    private final String OUTPUT_DIR = String.format("%s%s", WORK_DIR, "output/test_FileParser.txt");
    private final String INPUT_DIR = String.format("%s%s", WORK_DIR, "test_FileParser.txt");
    private final String INPUT_OK_DIR = String.format("%s%s", WORK_DIR, "test_FileParser_OK.txt");

    @Test
    public void test_FileParser() throws IOException {
        FileParser parser = new FileParser(OUTPUT_DIR, 0);
        parser.parse(new File(INPUT_DIR));

        try (BufferedReader in = new BufferedReader(new FileReader(new File(OUTPUT_DIR)));
                BufferedReader in_ok = new BufferedReader(new FileReader(new File(INPUT_OK_DIR)))) {

            String line;
            while ((line = in.readLine()) != null)
                Assert.assertEquals(line, in_ok.readLine());

        } catch (IOException e) {
            throw e;
        }
    }
}
