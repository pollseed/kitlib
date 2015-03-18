package pollseed.tools.helper.abst;

import java.io.UnsupportedEncodingException;

public abstract class AbstractEncoder {
    public static enum Charset implements E<Integer, String> {
        CP943(10, "Cp943"),
        MS932(20, "MS932"),
        ISO2022JP(30, "ISO2022JP"),
        JIS0212(40, "JIS0212"),
        SJIS(50, "SJIS"),
        EUC_JP(60, "EUC_JP"),
        UTF_16(70, "UTF-16"),
        UTF_8(80, "UTF-8"), ;
        private Integer value;
        private String name;

        Charset(int v, String n) {
            value = v;
            name = n;
        }

        @Override
        public Integer number() {
            return value;
        }

        @Override
        public String value() {
            return name;
        }
    }

    interface E<N, V> {
        N number();

        V value();
    }

    protected String word;

    protected abstract String encode(Charset cs) throws UnsupportedEncodingException;

    protected abstract byte[] toByte(Charset cs) throws UnsupportedEncodingException;
}
