package myapp.util;


import org.springframework.web.bind.annotation.RequestMethod;

import java.io.*;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.Map;

public class HttpRequest {
    HttpURLConnection con;
    URL url;

    public HttpRequest(String url) {
        try {
            this.url = new URL(url);
            con = (HttpURLConnection) this.url.openConnection();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public String request(String requestMethod) throws Exception {
        con.setRequestMethod(requestMethod);
        con.setDoOutput(true);
        con.setRequestProperty("Content-Type", "application/json");
        con.setConnectTimeout(5000);

        //response
        int status = con.getResponseCode();
        Reader streamReader = null;

        if (status > 299) {
            streamReader = new InputStreamReader(con.getErrorStream());
            throw new Exception(streamReader.toString());
        } else {
            BufferedReader in = new BufferedReader(new InputStreamReader(con.getInputStream()));
            String inputLine;
            StringBuffer content = new StringBuffer();
            while ((inputLine = in.readLine()) != null) {
                content.append(inputLine);
            }
            in.close();
            return content.toString();
        }
    }
}
