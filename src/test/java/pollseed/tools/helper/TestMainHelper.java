package pollseed.tools.helper;

import junit.framework.Assert;

import org.apache.commons.lang3.StringUtils;
import org.junit.Test;

import pollseed.tools.helper.abst.AbstractMainHelper;

import java.io.BufferedOutputStream;
import java.io.ByteArrayOutputStream;
import java.io.PrintStream;
import java.util.ArrayList;
import java.util.List;

public final class TestMainHelper extends AbstractMainHelper {
    private static final String LINE_STR = "-------------";
    private static final String TEST_MESSAGE = "hoge";
    private static final String TEST_MESSAGE_FORMAT = "hoge%s";
    private static final String TEST1_MESSAGE = "hoge1";
    private static final String TEST2_MESSAGE = "hoge2";
    private static final String TEST3_MESSAGE = "hogehoge";
    private static ByteArrayOutputStream byteArrayOutputStream;

    @Test
    public void 標準出力のテスト_改行なし() {
        byteArrayOutputStream = new ByteArrayOutputStream();
        System.setOut(new PrintStream(new BufferedOutputStream(byteArrayOutputStream)));
        l(TEST_MESSAGE);
        System.out.flush();
        Assert.assertEquals(byteArrayOutputStream.toString(), TEST_MESSAGE);
    }

    @Test
    public void 標準出力のテスト_改行あり() {
        byteArrayOutputStream = new ByteArrayOutputStream();
        System.setOut(new PrintStream(new BufferedOutputStream(byteArrayOutputStream)));

        ln(TEST_MESSAGE);
        System.out.flush();
        Assert.assertEquals(byteArrayOutputStream.toString(), TEST_MESSAGE + System.lineSeparator());
        System.out.close();
    }

    @Test
    public void 標準出力のテスト_ライン_中身なし() {
        byteArrayOutputStream = new ByteArrayOutputStream();
        System.setOut(new PrintStream(new BufferedOutputStream(byteArrayOutputStream)));
        lnLine();
        System.out.flush();
        Assert.assertEquals(byteArrayOutputStream.toString(), LINE_STR + System.lineSeparator());
    }

    @Test
    public void 標準出力のテスト_ライン_中身あり() {
        byteArrayOutputStream = new ByteArrayOutputStream();
        System.setOut(new PrintStream(new BufferedOutputStream(byteArrayOutputStream)));
        lnLine(TEST_MESSAGE);
        System.out.flush();
        Assert.assertEquals(byteArrayOutputStream.toString(), LINE_STR + System.lineSeparator() + TEST_MESSAGE + System.lineSeparator() + LINE_STR
                + System.lineSeparator());
    }

    @Test
    public void 標準出力のテスト_リスト() {
        byteArrayOutputStream = new ByteArrayOutputStream();
        System.setOut(new PrintStream(new BufferedOutputStream(byteArrayOutputStream)));
        @SuppressWarnings("serial")
        List<Object> list = new ArrayList<Object>() {
            {
                add(TEST1_MESSAGE);
                add(TEST2_MESSAGE);
            }
        };
        lnList(list);
        System.out.flush();
        Assert.assertEquals(byteArrayOutputStream.toString(), TEST1_MESSAGE + System.lineSeparator() + TEST2_MESSAGE + System.lineSeparator());
    }

    @Test
    public void 標準出力のテスト_埋め込み文字() {
        String word = printf(TEST_MESSAGE_FORMAT, TEST_MESSAGE);
        Assert.assertEquals(word, TEST3_MESSAGE);
    }

    @Test
    public void メイン実行処理() {
        boolean _isTestCaseValue = true;

        // メソッド内で判定をさせる。
        // よって、真偽値をメソッドの引数に持たせる必要がある。
        final String status = testCase(_isTestCaseValue);
        if (StringUtils.isBlank(status))
            ln(status);

        // 真偽判定を行った後にメソッドを呼び出す。
        // よって、余計な引数を持たせる必要はない。
        if (_isTestCaseValue) {
            ln(testCase("case2"));
        }

        // 面倒だからここまでエラーなく来たらOKとする
        Assert.assertTrue(_isTestCaseValue);
    }

    public static void main(String[] args) {
        new TestMainHelper().run();
    }

    @Override
    protected void run() {
    }

    private String testCase(String value) {
        lnLine(printf("test %s true", value));
        return "success";
    }

    private String testCase(boolean isTestCase) {
        if (isTestCase) {
            return testCase("case1");
        }
        return null;
    }

}
