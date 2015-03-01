package pollseed.tools.helper.abst;

import java.net.MalformedURLException;
import java.net.URL;

import org.jsoup.nodes.Document;

public abstract class AbstractJsoupWrapper {

    protected URL url;

    protected Document doc;

    protected String cssQuery;

    protected String tagName;

    protected abstract AbstractJsoupWrapper set(String arg1, String arg2, String arg3) throws MalformedURLException;

    protected abstract AbstractJsoupWrapper execute() throws Exception;

}
