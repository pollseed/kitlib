package tools;

import tools.RegexCheck.RegexFormat;

public class UnitTest {
    public static void main(String[] args) {
        test_RegexCheck();
    }

    private static void test_RegexCheck() {
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
    }
}
