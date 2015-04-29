package pollseed.tools.util;

import junit.framework.Assert;
import org.junit.Test;
import pollseed.tools.util.HashUtils;

public class HashUtilsTest {

    private static final int BIT_7 = 128;

    @Test
    public void test_Hash_cipher() {
        HashUtils.Hash hash = new HashUtils.Hash();
        hash.strongerEncrypt(HashUtils.CipherAlgorithm.AES, HashUtils.KeyGeneratorAlgorithm.AES, BIT_7);
        Assert.assertNotNull(hash.encrypting);
        hash.strongerEncrypt(HashUtils.CipherAlgorithm.AES_CBC_PKCS5Padding, HashUtils.KeyGeneratorAlgorithm.AES, BIT_7);
        Assert.assertNotNull(hash.encrypting);
        hash.strongerEncrypt(HashUtils.CipherAlgorithm.AES_ECB_PKCS5Padding, HashUtils.KeyGeneratorAlgorithm.AES, BIT_7);
        Assert.assertNotNull(hash.encrypting);
        hash.strongerEncrypt(HashUtils.CipherAlgorithm.BLOWFISH, HashUtils.KeyGeneratorAlgorithm.BLOWFISH, BIT_7);
        Assert.assertNotNull(hash.encrypting);
    }

    @Test
    public void test_Hash_md() {
        HashUtils.Hash hash = new HashUtils.Hash();
        hash.encrypt(HashUtils.MessageDigestAlgorithm.MD2);
        Assert.assertNotNull(hash.encrypting);
        hash.encrypt(HashUtils.MessageDigestAlgorithm.MD5);
        Assert.assertNotNull(hash.encrypting);
        hash.encrypt(HashUtils.MessageDigestAlgorithm.SHA_1);
        Assert.assertNotNull(hash.encrypting);
        hash.encrypt(HashUtils.MessageDigestAlgorithm.SHA_256);
        Assert.assertNotNull(hash.encrypting);
        hash.encrypt(HashUtils.MessageDigestAlgorithm.SHA_384);
        Assert.assertNotNull(hash.encrypting);
        hash.encrypt(HashUtils.MessageDigestAlgorithm.SHA_512);
        Assert.assertNotNull(hash.encrypting);
    }
}
