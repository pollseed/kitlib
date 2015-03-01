package pollseed.tools.helper;

import java.net.MalformedURLException;

import org.junit.Assert;
import org.junit.Test;

public class JsoupWrapperTest {
    /**
     * available from execute() to doc() by one time.
     * {@code new JsoupWrapper().set("http://pollseed.hatenablog.jp/feed").execute().doc();}
     */
    @Test
    public void test_JsoupWrapper() {
        JsoupWrapper wrapper = null;
        try {
            wrapper = new JsoupWrapper("http://pollseed.hatenablog.jp/feed");
        } catch (MalformedURLException e) {
            Assert.fail(e.getMessage());
        }
        try {
            wrapper.execute();
        } catch (Exception e) {
            Assert.fail(e.getMessage());
        }
        Assert.assertNotNull(wrapper.doc());
    }
}
