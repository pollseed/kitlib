package pollseed.tools.helper;

import java.io.UnsupportedEncodingException;

public class Encoder extends AbstEncoder {
    public Encoder(String str) {
        word = str;
    }

    @Override
    public String encode(Charset cs) throws UnsupportedEncodingException {
        return new String(toByte(cs), cs.value());
    }

    @Override
    public byte[] toByte(Charset cs) throws UnsupportedEncodingException {
        return word.getBytes(cs.value());
    }
}
