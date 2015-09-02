package main.test_beautifull;

import main.common.MainHelper;

import org.apache.commons.lang3.StringUtils;

public final class TestMainHelper extends AbstractMainHelper {

    public static void main(String[] args) {
        new TestBeautifull().run();
    }

    @Override
    protected void run() {
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
