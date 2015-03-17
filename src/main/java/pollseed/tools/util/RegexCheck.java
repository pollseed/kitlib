package pollseed.tools.util;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

import org.apache.commons.lang3.StringUtils;

import pollseed.tools.util.RegexCheck.RegexFormat.RegexType;

/**
 * UN-SAFE Regex-Check-Class
 * 
 * @author pollseed
 */
public class RegexCheck {

    /**
     * UN-SAFE
     * 
     * @param regex
     *            Regular expression
     * @param target
     *            Character you want to evaluate
     * @return true or false
     */
    public static boolean regex(String regex, String target) {
        validation(regex, target);
        return Pattern.matches(regex, target);
    }

    /**
     * UN-SAFE
     * 
     * get from regex to group
     * 
     * @param group
     *            get regex point
     * @param target
     *            check String
     * @param regexes
     *            check regex String
     * @return group
     */
    public static String regex(int group, String target, String... regexes) {
        validation(target, regexes);
        StringBuilder regex = new StringBuilder();
        for (String _regex : regexes) {
            regex.append("(");
            regex.append(_regex);
            regex.append(")");
        }
        require(regex);

        Matcher matcher = Pattern.compile(regex.toString()).matcher(target);
        if (matcher.find())
            return matcher.group(group);
        return null;
    }

    /**
     * UN-SAFE
     * 
     * @param type
     *            {@link RegexType}
     * @param target
     *            Character you want to evaluate
     * @return true or false
     */
    public static boolean regex(RegexType type, String target) {
        validation(type, target);
        return Pattern.matches(type.regex, target);
    }

    private static void validation(String regex, String target) {
        require(regex);
        require(target);
    }

    private static void validation(String target, String... regexes) {
        require(target);
        require(regexes);
    }

    private static void validation(RegexType type, String target) {
        require(type);
        require(target);
    }

    private static void require(String str) {
        if (StringUtils.isBlank(str))
            throw new NullPointerException("string is blank.");
    }

    private static void require(String... strs) {
        if (strs == null || strs.length == 0)
            throw new NullPointerException("string array is blank.");
        for (String str : strs)
            require(str);
    }

    private static void require(StringBuilder sb) {
        if (sb == null || sb.length() == 0)
            throw new NullPointerException("StringBuilder is blank.");
        require(sb.toString());
    }

    private static void require(RegexType type) {
        if (type == null)
            throw new NullPointerException("type is nullptr.");
    }

    /**
     * Regex-Check-Class Format Type
     */
    public static class RegexFormat {
        /**
         * Regex-Check-Class Format Type
         */
        public enum RegexType {
            /**
             * numbers
             */
            NUM(1, "^[0-9]+$"),
            /**
             * Lower case
             */
            LOWERCASE(2, "^[a-z]+$"),
            /**
             * Upper case
             */
            UPPERCASE(3, "^[A-Z]+$"),
            /**
             * Alphanumeric characters
             */
            ALPHANUMERIC(4, "^[0-9a-zA-Z]+$"),
            /**
             * Em numbers
             */
            EM_NUM(11, "^[０-９]+$"),
            /**
             * Em lowercase
             */
            EM_LOWERCASE(12, "^[ａ-ｚ]+$"),
            /**
             * Em uppercase
             */
            EM_UPPERCASE(13, "^[Ａ-Ｚ]+$"),
            /**
             * Em Alphanumeric characters
             */
            EM_ALPHANUMERIC(14, "^[０-９ａ-ｚＡ-Ｚ]+$"),
            /**
             * Kanji
             */
            KANJI(21, "^[一-龥豈-鶴]+$"),
            /**
             * Hiragana
             */
            HIRAGANA(22, "^[ぁ-ん]+$"),
            /**
             * Katakana
             */
            KATAKANA(23, "^[ァ-ヶ]+$"),
            /**
             * Japanese Languages
             */
            JAPANESE(24, "^[一-龥豈-鶴ぁ-んァ-ヶ]+$")

            ;

            int value;
            String regex;

            RegexType(int v, String r) {
                value = v;
                regex = r;
            }

            int suffix() {
                return value;
            }

            String regex() {
                return regex;
            }
        }
    }
}
