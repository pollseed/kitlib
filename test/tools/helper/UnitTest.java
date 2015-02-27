package tools;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileOutputStream;
import java.io.FileReader;
import java.io.IOException;
import java.io.OutputStreamWriter;

import org.apache.commons.io.IOUtils;

import tools.RegexCheck.RegexFormat;

public class UnitTest {
    private static final String FORMAT_LOGGER = "UNIT_TEST [%s] %s";

    public static void main(String[] args) {
        test_RegexCheck();
        test_FileParser();
    }

    /**
     * {@link RegexCheck}
     */
    private static void test_RegexCheck() {
        System.out.println(String.format(FORMAT_LOGGER, RegexCheck.class, "start"));
        System.out.println(RegexCheck.regex(RegexFormat.Type.NUM, "09238475"));
        System.out.println(RegexCheck.regex(RegexFormat.Type.LOWERCASE, "jfhuiapefea"));
        System.out.println(RegexCheck.regex(RegexFormat.Type.UPPERCASE, "PUAHIUGPRE"));
        System.out.println(RegexCheck.regex(RegexFormat.Type.ALPHANUMERIC, "0fhuiap384703aaZHIUGP3847REjD3"));
        System.out.println(RegexCheck.regex(RegexFormat.Type.EM_NUM, "０９２９８３７０９４５"));
        System.out.println(RegexCheck.regex(RegexFormat.Type.EM_LOWERCASE, "ｊｊｐｆｓｏｐｅｕ"));
        System.out.println(RegexCheck.regex(RegexFormat.Type.EM_UPPERCASE, "ＵＳＹＥＧＦＢＵＦＢＵＢＹＶ"));
        System.out.println(RegexCheck.regex(RegexFormat.Type.EM_ALPHANUMERIC, "ＵＳｊｊｐｆｓｏｐｅ０９２９８３７０９４５ｕＹＥＧＦＢＵ７０９ＦＢＵｓｏｐＢＹＶ"));
        System.out.println(RegexCheck.regex(RegexFormat.Type.HIRAGANA, "あああふふぇじえせぴこぉあ"));
        System.out.println(RegexCheck.regex(RegexFormat.Type.KATAKANA, "ジエヂヲイエオオッオイ"));
        System.out.println(RegexCheck.regex(RegexFormat.Type.KANJI, "藍上雄夏期区華籠佐志嵩山曽田帙手都何塗音乃葉皮膚経保目見無目藻屋"));
        System.out.println(RegexCheck.regex(RegexFormat.Type.JAPANESE, "藍上雄夏期エヂヲイエオ区華籠佐志嵩山曽オオえせぴ田帙手都何塗音乃あふふ葉皮膚経保目ヲイエ見無目藻屋"));
        System.out.println(String.format(FORMAT_LOGGER, RegexCheck.class, "end"));
    }

    /**
     * {@link FileReader}
     */
    private static void test_FileParser() {
        System.out.println(String.format(FORMAT_LOGGER, FileReader.class, "start"));
        BufferedReader in = null;
        BufferedWriter out = null;
        String uploadPath = "C:\\temp\\test\\test2.txt";
        File file = new File(uploadPath);
        try {
            in = new BufferedReader(new FileReader(new File("../resource/hoge.txt")));

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
