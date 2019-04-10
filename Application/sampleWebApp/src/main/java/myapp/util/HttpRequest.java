package myapp.util;

import myapp.dto.ProductDTO;

import java.io.*;
import java.net.HttpURLConnection;
import java.net.URL;

public abstract class HttpRequest {
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

    public ProductDTO request(String requestMethod) throws Exception {
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
            return convert(content.toString());
        }
    }

    protected abstract ProductDTO convert(String toString) throws Exception;

}
