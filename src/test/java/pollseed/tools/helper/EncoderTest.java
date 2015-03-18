package pollseed.tools.helper;

import java.io.UnsupportedEncodingException;

import org.junit.Assert;
import org.junit.Test;

import pollseed.tools.helper.abst.AbstractEncoder.Charset;

public class EncoderTest {

    @Test
    public void test_encode() throws UnsupportedEncodingException {
        final String sjis = new String("鶏肉食べたいよ。お父さん犬。".getBytes("SJIS"), "SJIS");
        Encoder encoder = new Encoder("鶏肉食べたいよ。お父さん犬。");
        Assert.assertEquals(encoder.encode(Charset.SJIS), sjis);
    }
}
