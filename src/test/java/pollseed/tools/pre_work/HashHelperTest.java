package pollseed.tools.pre_work;

import junit.framework.Assert;
import org.junit.Test;

public class HashHelperTest {

    private static final int BIT_7 = 128;

    @Test
    public void test_Hash_cipher() {
        HashHelper.Hash hash = new HashHelper.Hash();
        hash.strongerEncrypt(HashHelper.CipherAlgorithm.AES, HashHelper.KeyGeneratorAlgorithm.AES, BIT_7);
        Assert.assertNotNull(hash.encrypting);
        hash.strongerEncrypt(HashHelper.CipherAlgorithm.AES_CBC_PKCS5Padding, HashHelper.KeyGeneratorAlgorithm.AES, BIT_7);
        Assert.assertNotNull(hash.encrypting);
        hash.strongerEncrypt(HashHelper.CipherAlgorithm.AES_ECB_PKCS5Padding, HashHelper.KeyGeneratorAlgorithm.AES, BIT_7);
        Assert.assertNotNull(hash.encrypting);
        hash.strongerEncrypt(HashHelper.CipherAlgorithm.BLOWFISH, HashHelper.KeyGeneratorAlgorithm.BLOWFISH, BIT_7);
        Assert.assertNotNull(hash.encrypting);
    }

    @Test
    public void test_Hash_md() {
        HashHelper.Hash hash = new HashHelper.Hash();
        hash.encrypt(HashHelper.MessageDigestAlgorithm.MD2);
        Assert.assertNotNull(hash.encrypting);
        hash.encrypt(HashHelper.MessageDigestAlgorithm.MD5);
        Assert.assertNotNull(hash.encrypting);
        hash.encrypt(HashHelper.MessageDigestAlgorithm.SHA_1);
        Assert.assertNotNull(hash.encrypting);
        hash.encrypt(HashHelper.MessageDigestAlgorithm.SHA_256);
        Assert.assertNotNull(hash.encrypting);
        hash.encrypt(HashHelper.MessageDigestAlgorithm.SHA_384);
        Assert.assertNotNull(hash.encrypting);
        hash.encrypt(HashHelper.MessageDigestAlgorithm.SHA_512);
        Assert.assertNotNull(hash.encrypting);
    }
}
