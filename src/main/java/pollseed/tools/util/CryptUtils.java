package main.post;

import java.io.UnsupportedEncodingException;
import java.net.URLEncoder;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.util.Locale;

import javax.crypto.Mac;
import javax.crypto.spec.SecretKeySpec;

public class CryptUtils {

    /**
     * 指定されたデータを「SHA-256」のアルゴリズムでハッシュ化して返却します.
     *
     * @param data
     *            データ
     * @return ハッシュデータ
     * @throws NoSuchAlgorithmException
     *             ハッシュ化が失敗した時
     */
    public static byte[] hash(final byte[] data)
            throws NoSuchAlgorithmException {
        MessageDigest md = MessageDigest.getInstance("SHA-256");
        md.update(data);
        return md.digest();
    }

    /**
     * 指定されたデータをHEXに変換して返却します.
     *
     * @param data
     *            byte array
     * @return HEX
     */
    public static String toHex(final byte[] data) {
        StringBuilder sb = new StringBuilder(data.length * 2);
        for (int i = 0; i < data.length; i++) {
            String hex = Integer.toHexString(data[i]);
            if (hex.length() == 1) {
                sb.append("0");
            } else if (hex.length() == 8) {
                hex = hex.substring(6);
            }
            sb.append(hex);
        }
        return sb.toString().toLowerCase(Locale.ENGLISH);
    }

    /**
     * 指定されたデータを「HmacSHA256」のアルゴリズムで指定されたキーで暗号化.
     *
     * @param data
     *            データ
     * @param key
     *            秘密鍵
     * @return 暗号化されたデータ
     * @throws Exception
     *             暗号化失敗時
     */
    public static byte[] hmac(final String data, final String key)
            throws Exception {
        String algorithm = "HmacSHA256";
        Mac mac = Mac.getInstance(algorithm);
        mac.init(new SecretKeySpec(key.getBytes("UTF8"), algorithm));
        return mac.doFinal(data.getBytes("UTF8"));
    }

    /**
     * カノニカルURIとして返却.
     *
     * @param path
     *            URLパス
     * @return 標準URI
     * @throws UnsupportedEncodingException
     *             処理に失敗した場合
     */
    public static String buildCanonicalURI(final String path)
            throws UnsupportedEncodingException {
        StringBuilder sb = new StringBuilder();
        if (path.length() == 0) {
            sb.append("/");
        } else {
            sb.append(encodeURI(path, false));
        }
        return sb.toString();
    }

    /**
     * パスをエンコードして返却する.
     *
     * @param input
     *            URIパス
     * @param encodeSlash
     *            スラッシュをエンコード変換するかどうか
     * @return エンコード済みURI
     * @throws UnsupportedEncodingException
     *             処理に失敗した場合
     */
    public static String encodeURI(
            final CharSequence input, final boolean encodeSlash)
            throws UnsupportedEncodingException {
        StringBuilder result = new StringBuilder();
        for (int i = 0; i < input.length(); i++) {
            char ch = input.charAt(i);
            if ((ch >= 'A' && ch <= 'Z')
                    || (ch >= 'a' && ch <= 'z')
                    || (ch >= '0' && ch <= '9')
                    || ch == '_'
                    || ch == '-'
                    || ch == '~'
                    || ch == '.') {
                result.append(ch);
            } else if (ch == '/') {
                result.append(encodeSlash ? "%2F" : ch);
            } else {
                String hex = encodingUrlString(String.valueOf(ch));
                result.append(hex);
            }
        }
        return result.toString();
    }

    /**
     * 文字列をエンコードして返却する.
     *
     * @param path
     *            パス
     * @return エンコード済みパス
     * @throws UnsupportedEncodingException
     *             処理に失敗した場合
     */
    public static String encodingUrlString(final String path)
            throws UnsupportedEncodingException {
        String encodingPath = URLEncoder.encode(path, "UTF-8");
        return encodingPath.replaceAll("\\+", "%20").replaceAll("%40", "@");
    }

}
