package pollseed.tools.pre_work;

import junit.framework.Assert;
import org.junit.Test;

public class CrapsTest {

    private static final int BIT_7 = 128;

    @Test
    public void test_Hash_cipher() {
        Craps.Hash hash = new Craps.Hash();
        hash.strongerEncrypt(Craps.CipherAlgorithm.AES, Craps.KeyGeneratorAlgorithm.AES, BIT_7);
        Assert.assertNotNull(hash.encrypting);
        hash.strongerEncrypt(Craps.CipherAlgorithm.AES_CBC_PKCS5Padding, Craps.KeyGeneratorAlgorithm.AES, BIT_7);
        Assert.assertNotNull(hash.encrypting);
        hash.strongerEncrypt(Craps.CipherAlgorithm.AES_ECB_PKCS5Padding, Craps.KeyGeneratorAlgorithm.AES, BIT_7);
        Assert.assertNotNull(hash.encrypting);
        hash.strongerEncrypt(Craps.CipherAlgorithm.BLOWFISH, Craps.KeyGeneratorAlgorithm.BLOWFISH, BIT_7);
        Assert.assertNotNull(hash.encrypting);
    }

    @Test
    public void test_Hash_md() {
        Craps.Hash hash = new Craps.Hash();
        hash.encrypt(Craps.MessageDigestAlgorithm.MD2);
        Assert.assertNotNull(hash.encrypting);
        hash.encrypt(Craps.MessageDigestAlgorithm.MD5);
        Assert.assertNotNull(hash.encrypting);
        hash.encrypt(Craps.MessageDigestAlgorithm.SHA_1);
        Assert.assertNotNull(hash.encrypting);
        hash.encrypt(Craps.MessageDigestAlgorithm.SHA_256);
        Assert.assertNotNull(hash.encrypting);
        hash.encrypt(Craps.MessageDigestAlgorithm.SHA_384);
        Assert.assertNotNull(hash.encrypting);
        hash.encrypt(Craps.MessageDigestAlgorithm.SHA_512);
        Assert.assertNotNull(hash.encrypting);
    }
}
