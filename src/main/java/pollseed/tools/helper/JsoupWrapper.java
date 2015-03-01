package pollseed.tools.helper;

import java.net.MalformedURLException;
import java.net.URL;

import org.jsoup.Connection;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;

/**
 * Jsoup Web Scraping Wrapper
 */
public class JsoupWrapper {

    private URL url;

    private Document doc;

    /**
     * Set URL that want to web-scraping.
     * 
     * @param arg
     *            URL
     * @return JsoupWrapper
     * @throws MalformedURLException
     */
    public JsoupWrapper set(String arg) throws MalformedURLException {
        url = new URL(arg);
        return this;
    }

    /**
     * Not set to handle by connecting an instance.
     */
    public JsoupWrapper() {
    }

    /**
     * Execute a web-scraping.
     * 
     * @return JsoupWrapper
     * @throws Exception
     */
    public JsoupWrapper execute() throws Exception {
        validation();
        Connection connect = Jsoup.connect(url.toString());
        doc = connect.get();
        return this;
    }

    /**
     * Get Document.
     * 
     * @return Document
     */
    public Document doc() {
        return doc;
    }

    private void validation() throws IllegalAccessError {
        if (url == null)
            throw new IllegalAccessError();
    }
}
