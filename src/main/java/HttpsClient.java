import org.json.JSONObject;

import javax.net.ssl.HttpsURLConnection;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.MalformedURLException;
import java.net.URL;

public class HttpsClient {
    String httpsURL = "https://rentalcarassignment.com";
    URL myURL = new URL(httpsURL);
    HttpsURLConnection connection = (HttpsURLConnection)myURL.openConnection();
    InputStream inputStream = connection.getInputStream();
    InputStreamReader inputStreamReader = new InputStreamReader(inputStream);
    BufferedReader bufferedReader = new BufferedReader(inputStreamReader);
    StringBuffer stringBuffer = new StringBuffer();

    public HttpsClient() throws Exception {
    }

    public JSONObject getResponse() throws IOException {
        String input;
        while((input = bufferedReader.readLine()) != null) {
            stringBuffer.append(input);
        }
        bufferedReader.close();
        JSONObject response = new JSONObject(stringBuffer.toString());
        return response;
    }
}
