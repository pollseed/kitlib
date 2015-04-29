package pollseed.tools.util;

import org.apache.commons.codec.binary.Base64;

import java.security.InvalidKeyException;
import java.security.Key;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.security.SecureRandom;
import java.util.UUID;

import javax.crypto.BadPaddingException;
import javax.crypto.Cipher;
import javax.crypto.IllegalBlockSizeException;
import javax.crypto.KeyGenerator;
import javax.crypto.NoSuchPaddingException;

/**
 * ハッシュ生成用ヘルパー
 */
public class HashUtils {
    static HashUtils self = new HashUtils();

    interface Algorithm {
        @Override
        String toString();

        String toHyphen();

        String toSlash();
    }

    /**
     * Message Digestのアルゴリズム
     */
    public static enum MessageDigestAlgorithm implements Algorithm {
        MD2,
        MD5,
        SHA_1,
        SHA_256,
        SHA_384,
        SHA_512;

        @Override
        public String toString() {
            return toHyphen();
        }

        @Override
        public String toHyphen() {
            return self.toHyphen(this.name());
        }

        @Override
        public String toSlash() {
            return self.toSlash(this.name());
        }
    }

    /**
     * Cipherのアルゴリズム
     */
    public static enum CipherAlgorithm implements Algorithm {
        AES,
        AES_CBC_PKCS5Padding,
        AES_ECB_PKCS5Padding,
        BLOWFISH,
        DES,
        DESede,
        DESedeWrap,
        ECIES,
        PBEWithMD5AndDES,
        PBEWithHmacSHA1AndDESede,
        RC2,
        RC4,
        RC5,
        RSA;

        @Override
        public String toString() {
            return toSlash();
        }

        @Override
        public String toHyphen() {
            return self.toHyphen(this.name());
        }

        @Override
        public String toSlash() {
            return self.toSlash(this.name());
        }
    }

    /**
     * Key Generatorのアルゴリズム
     */
    public static enum KeyGeneratorAlgorithm implements Algorithm {
        AES,
        ARCFOUR,
        BLOWFISH,
        DES,
        DESede,
        HmacMD5,
        HmacSHA1,
        HmacSHA256,
        HmacSHA384,
        HmacSHA512,
        RC2;

        @Override
        public String toString() {
            return toHyphen();
        }

        @Override
        public String toHyphen() {
            return self.toHyphen(this.name());
        }

        @Override
        public String toSlash() {
            return self.toSlash(this.name());
        }
    }

    public static enum SecureRandomAlgorithm implements Algorithm {
        SHA1PRNG;

        @Override
        public String toString() {
            return toHyphen();
        }

        @Override
        public String toHyphen() {
            return self.toHyphen(this.name());
        }

        @Override
        public String toSlash() {
            return self.toSlash(this.name());
        }
    }

    private String toHyphen(String name) {
        return name.replaceAll("_", "-");
    }

    private String toSlash(String name) {
        return name.replaceAll("_", "/");
    }

    /**
     * ハッシュクラス
     */
    public static class Hash {
        Key secretKey = null;
        UUID uuid = null;
        String encrypting = null;

        /**
         * UUIDを生成
         */
        public void create() {
            uuid = UUID.randomUUID();
        }

        /**
         * シークレットキーを生成
         * @param algorithm
         * @param length
         */
        public void createSecretKey(KeyGeneratorAlgorithm algorithm, int length) {
            try {
                KeyGenerator generator = KeyGenerator.getInstance(algorithm.toString());
                generator.init(length, SecureRandom.getInstance(SecureRandomAlgorithm.SHA1PRNG.toString()));
                secretKey = generator.generateKey();
            } catch (NoSuchAlgorithmException e) {
                throw new RuntimeException(e);
            }
        }

        /**
         * 指定されたアルゴリズムで暗号化
         * @param algorithm
         */
        public void encrypt(MessageDigestAlgorithm algorithm) {
            if (uuid == null)
                create();
            try {
                StringBuilder sb = new StringBuilder();
                for (byte b : digest(createDigest(algorithm)))
                    sb.append(toHex(b));
                encrypting = sb.toString();
            } catch (NoSuchAlgorithmException e) {
                throw new RuntimeException(e);
            }
        }

        /**
         * 二進数に変換します
         * @param b
         * @return
         */
        private String toHex(byte b) {
            return String.format("%02x", b);
        }

        private MessageDigest createDigest(MessageDigestAlgorithm algorithm) throws NoSuchAlgorithmException {
            MessageDigest md = MessageDigest.getInstance(algorithm.toString());
            md.update(uuid.toString().getBytes());
            return md;
        }

        private byte[] digest(MessageDigest md) {
            return md.digest();
        }

        /**
         * 指定されたアルゴリズムで秘密鍵を生成し、それを使って暗号化
         * @param algorithmC
         * @param algorithmK
         * @param length
         */
        public void strongerEncrypt(CipherAlgorithm algorithmC, KeyGeneratorAlgorithm algorithmK, int length) {
            if (uuid == null)
                create();
            createSecretKey(algorithmK, length);
            try {
                Cipher c = Cipher.getInstance(algorithmC.toString());
                c.init(Cipher.ENCRYPT_MODE, secretKey);
                encrypting = new String(Base64.encodeBase64(c.doFinal(uuid.toString().getBytes())));
            } catch (NoSuchAlgorithmException | NoSuchPaddingException | InvalidKeyException | IllegalBlockSizeException | BadPaddingException e) {
                throw new RuntimeException(e);
            }
        }
    }
}
