package pollseed.tools.util;

import java.io.BufferedReader;
import java.io.DataOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.UnsupportedEncodingException;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.ProtocolException;
import java.net.URL;

import org.apache.commons.io.IOUtils;

public class PostRequest {

    public static void main(String[] args) {
        post();
    }

    public final static void post() {
        HttpURLConnection con = null;
        DataOutputStream os = null;
        InputStream is = null;
        BufferedReader br = null;
        try {
            String json = "{\"id\":00000, \"name\":\"Tom\"}";
            con = createConnection(json,
                    "jfoa;[]@}_>.plfe;jiovfnglahng;lzijef;][>{FKFEK<*;ofjzeilk;l}]0fp3w");
            os = new DataOutputStream(con.getOutputStream());
            os.writeBytes(json);

            String line = "";
            br = new BufferedReader(new InputStreamReader(getInputStream(con)));
            while ((line = br.readLine()) != null) {
                System.out.println(line);
            }
        } catch (MalformedURLException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            IOUtils.closeQuietly(br);
            IOUtils.closeQuietly(is);
            IOUtils.closeQuietly(os);
            con.disconnect();
        }
    }

    private static InputStream getInputStream(HttpURLConnection con)
            throws IOException {
        InputStream is;
        if (HttpURLConnection.HTTP_OK == con.getResponseCode()) {
            is = con.getInputStream();
        } else {
            is = con.getErrorStream();
        }
        return is;
    }

    private static HttpURLConnection createConnection(String json, String authorization)
            throws MalformedURLException, IOException, ProtocolException, UnsupportedEncodingException {
        URL url = new URL("https://hogehoge");
        HttpURLConnection con = (HttpURLConnection) url.openConnection();
        con.setDoInput(true);
        con.setDoOutput(true);
        con.setRequestMethod("POST");
        con.setUseCaches(false);
        con.setRequestProperty("Content-Type", "application/json");
        con.setRequestProperty("Content-Length",
                String.valueOf(json.getBytes("UTF-8").length));
        con.setRequestProperty("Authorization", authorization);
        return con;
    }
}
