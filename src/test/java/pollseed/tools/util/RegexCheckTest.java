package pollseed.tools.util;

import org.junit.Test;

import pollseed.tools.util.RegexCheck;
import pollseed.tools.util.RegexCheck.RegexFormat;

public class RegexCheckTest {
    @Test
    public void test_RegexType() {
        test_softUrl();
        test_hardFormat();
    }

    private void test_hardFormat() {
        org.junit.Assert.assertEquals(RegexCheck.regex(RegexFormat.RegexType.NUM, "09238475"), true);
        org.junit.Assert.assertEquals(RegexCheck.regex(RegexFormat.RegexType.NUM, "KAKAKA"), false);
        org.junit.Assert.assertEquals(RegexCheck.regex(RegexFormat.RegexType.LOWERCASE, "jfhuiapefea"), true);
        org.junit.Assert.assertEquals(RegexCheck.regex(RegexFormat.RegexType.LOWERCASE, "PJUDHFO"), false);
        org.junit.Assert.assertEquals(RegexCheck.regex(RegexFormat.RegexType.UPPERCASE, "PUAHIUGPRE"), true);
        org.junit.Assert.assertEquals(RegexCheck.regex(RegexFormat.RegexType.UPPERCASE, "ahguprjsgdu"), false);
        org.junit.Assert.assertEquals(RegexCheck.regex(RegexFormat.RegexType.ALPHANUMERIC, "0fhuiap384703aaZHIUGP3847REjD3"), true);
        org.junit.Assert.assertEquals(RegexCheck.regex(RegexFormat.RegexType.ALPHANUMERIC, "0fhuiap38470９８３７０９GP3847REjD3"), false);
        org.junit.Assert.assertEquals(RegexCheck.regex(RegexFormat.RegexType.EM_NUM, "０９２９８３７０９４５"), true);
        org.junit.Assert.assertEquals(RegexCheck.regex(RegexFormat.RegexType.EM_NUM, "０９２９aaaaa８３７０９４５"), false);
        org.junit.Assert.assertEquals(RegexCheck.regex(RegexFormat.RegexType.EM_LOWERCASE, "ｊｊｐｆｓｏｐｅｕ"), true);
        org.junit.Assert.assertEquals(RegexCheck.regex(RegexFormat.RegexType.EM_LOWERCASE, "ｊｊｐｆJGHPOｓｏｐｅｕ"), false);
        org.junit.Assert.assertEquals(RegexCheck.regex(RegexFormat.RegexType.EM_UPPERCASE, "ＵＳＹＥＧＦＢＵＦＢＵＢＹＶ"), true);
        org.junit.Assert.assertEquals(RegexCheck.regex(RegexFormat.RegexType.EM_UPPERCASE, "ＵＳＹＥＧＦＢagggsdＵＦＢＵＢＹＶ"), false);
        org.junit.Assert.assertEquals(RegexCheck.regex(RegexFormat.RegexType.EM_ALPHANUMERIC, "ＵＳｊｊｐｆｓｏｐｅ０９２９８３７０９４５ｕＹＥＧＦＢＵ７０９ＦＢＵｓｏｐＢＹＶ"), true);
        org.junit.Assert.assertEquals(RegexCheck.regex(RegexFormat.RegexType.EM_ALPHANUMERIC, "ＵＳｊｊｐｆｓｏｐｅ０９２asgj９８３７０９４５ｕＹＥＧＦＢＵ７０９ＦＢＵｓｏｐＢＹＶ"), false);
        org.junit.Assert.assertEquals(RegexCheck.regex(RegexFormat.RegexType.HIRAGANA, "あああふふぇじえせぴこぉあ"), true);
        org.junit.Assert.assertEquals(RegexCheck.regex(RegexFormat.RegexType.HIRAGANA, "あああふふssssぇじえせぴこぉあ"), false);
        org.junit.Assert.assertEquals(RegexCheck.regex(RegexFormat.RegexType.KATAKANA, "ジエヂヲイエオオッオイ"), true);
        org.junit.Assert.assertEquals(RegexCheck.regex(RegexFormat.RegexType.KATAKANA, "ジエヂヲイJHUGH+エオオッオイ"), false);
        org.junit.Assert.assertEquals(RegexCheck.regex(RegexFormat.RegexType.KANJI, "藍上雄夏期区華籠佐志嵩山曽田帙手都何塗音乃葉皮膚経保目見無目藻屋"), true);
        org.junit.Assert.assertEquals(RegexCheck.regex(RegexFormat.RegexType.KANJI, "藍上雄夏期区test華籠佐志嵩山曽田帙手都何塗音乃葉皮膚経保目見無目藻屋"), false);
        org.junit.Assert.assertEquals(RegexCheck.regex(RegexFormat.RegexType.JAPANESE, "藍上雄夏期エヂヲイエオ区華籠佐志嵩山曽オオえせぴ田帙手都何塗音乃あふふ葉皮膚経保目ヲイエ見無目藻屋"), true);
        org.junit.Assert.assertEquals(RegexCheck.regex(RegexFormat.RegexType.JAPANESE, "藍上雄夏期エヂヲイエオ区華籠佐志嵩山曽オオえせぴ田帙d手都何塗音乃あふふ葉皮膚経保目ヲイエ見無目藻屋"), false);
    }

    private void test_softUrl() {
        org.junit.Assert.assertEquals(RegexCheck.regex("^(http|https)://[^/!-=?;:&].+$", "http://pollseed.hatenablog.jp/"), true);
    }
}
