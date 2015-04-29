package pollseed.tools.pre_work;

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

public class Craps {
    private static final int BIT_7 = 128;
    static Craps self = new Craps();

    public static void main(String[] args) {
        exec_Hash();

    }

    private static void exec_Hash() {
        Hash hash = new Hash();
        do_md(hash);
        do_cipher(hash);
    }

    private static void do_cipher(Hash hash) {
        ln("hash", "秘密鍵", "暗号化");
        hash.strongerEncrypt(CipherAlgorithm.AES, KeyGeneratorAlgorithm.AES, BIT_7);
        ln(CipherAlgorithm.AES.name(), KeyGeneratorAlgorithm.AES.name(), hash.encrypting);
        hash.strongerEncrypt(CipherAlgorithm.AES_CBC_PKCS5Padding, KeyGeneratorAlgorithm.AES, BIT_7);
        ln(CipherAlgorithm.AES_CBC_PKCS5Padding.name(), KeyGeneratorAlgorithm.AES.name(), hash.encrypting);
        hash.strongerEncrypt(CipherAlgorithm.AES_ECB_PKCS5Padding, KeyGeneratorAlgorithm.AES, BIT_7);
        ln(CipherAlgorithm.AES_ECB_PKCS5Padding.name(), KeyGeneratorAlgorithm.AES.name(), hash.encrypting);
        hash.strongerEncrypt(CipherAlgorithm.BLOWFISH, KeyGeneratorAlgorithm.BLOWFISH, BIT_7);
        ln(CipherAlgorithm.BLOWFISH.name(), KeyGeneratorAlgorithm.BLOWFISH.name(), hash.encrypting);
    }

    private static void do_md(Hash hash) {
        ln("秘密鍵", "暗号化");
        hash.encrypt(MessageDigestAlgorithm.MD2);
        ln(MessageDigestAlgorithm.MD2.name(), hash.encrypting);
        hash.encrypt(MessageDigestAlgorithm.MD5);
        ln(MessageDigestAlgorithm.MD5.name(), hash.encrypting);
        hash.encrypt(MessageDigestAlgorithm.SHA_1);
        ln(MessageDigestAlgorithm.SHA_1.name(), hash.encrypting);
        hash.encrypt(MessageDigestAlgorithm.SHA_256);
        ln(MessageDigestAlgorithm.SHA_256.name(), hash.encrypting);
        hash.encrypt(MessageDigestAlgorithm.SHA_384);
        ln(MessageDigestAlgorithm.SHA_384.name(), hash.encrypting);
        hash.encrypt(MessageDigestAlgorithm.SHA_512);
        ln(MessageDigestAlgorithm.SHA_512.name(), hash.encrypting);
    }

    private static void ln(String... logger) {
        StringBuilder sb = new StringBuilder();
        int i = 0;
        for (String l : logger) {
            if (i != 0)
                sb.append("\t");
            sb.append(l);
            i++;
        }
        System.out.println(new String(sb.toString()));
    }

    interface Algorithm {
        @Override
        String toString();

        String toHyphen();

        String toSlash();
    }

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

    public static class Hash {
        Key secretKey = null;
        UUID uuid = null;
        String encrypting = null;

        public void create() {
            uuid = UUID.randomUUID();
        }

        public void createSecretKey(KeyGeneratorAlgorithm algorithm, int length) {
            try {
                KeyGenerator generator = KeyGenerator.getInstance(algorithm.toString());
                generator.init(length, SecureRandom.getInstance(SecureRandomAlgorithm.SHA1PRNG.toString()));
                secretKey = generator.generateKey();
            } catch (NoSuchAlgorithmException e) {
                throw new RuntimeException(e);
            }
        }

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
