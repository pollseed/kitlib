package pollseed.tools.helper;

import java.net.MalformedURLException;
import java.net.URL;

import org.apache.commons.lang3.StringUtils;
import org.jsoup.Connection;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.select.Elements;

import pollseed.tools.helper.abst.AbstractJsoupWrapper;

/**
 * Jsoup Web Scraping Wrapper
 */
public class JsoupWrapper extends AbstractJsoupWrapper {

    /**
     * Not set to handle by connecting an instance.
     */
    public JsoupWrapper() {
    }

    public JsoupWrapper(String arg) throws MalformedURLException {
        set(arg, null, null);
    }

    /**
     * Set URL that want to web-scraping.
     * 
     * @param arg
     *            URL
     * @return JsoupWrapper
     * @throws MalformedURLException
     */
    @Override
    public JsoupWrapper set(String arg, String css, String tag) throws MalformedURLException {
        url = new URL(arg);
        cssQuery = css;
        tagName = tag;
        return this;
    }

    /**
     * Execute a web-scraping.
     * 
     * @return JsoupWrapper
     * @throws Exception
     */
    @Override
    public JsoupWrapper execute() throws Exception {
        validation();
        Connection connect = Jsoup.connect(url.toString());
        doc = connect.get();
        return this;
    }

    private void validation() throws IllegalAccessError {
        if (url == null)
            throw new IllegalAccessError();
    }

    /**
     * Get Document.
     * 
     * @return Document
     */
    public Document doc() {
        return doc;
    }

    /**
     * Get CSS.
     * 
     * @return Elements
     */
    public Elements css() {
        return getCssQuery();
    }

    private Elements getCssQuery() {
        if (doc == null) {
            return new Elements();
        }
        if (StringUtils.isBlank(cssQuery)) {
            return new Elements();
        } else {
            return doc.select(cssQuery);
        }
    }

    /**
     * Get tag.
     * 
     * @return Elements
     */
    public Elements tag() {
        return css().tagName(tagName);
    }

}
