package com.hicouch.back.core.util;

import com.hicouch.back.core.dto.ProductDTO;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.Reader;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.List;

public abstract class HttpRequest {
    HttpURLConnection connection;
    URL url;

    public HttpRequest(String url) {
        try {
            this.url = new URL(url);
            connection = (HttpURLConnection) this.url.openConnection();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public ProductDTO request(String requestMethod) throws Exception {
        connection.setRequestMethod(requestMethod);
        connection.setDoOutput(true);
        connection.setRequestProperty("Content-Type", "application/json");
        connection.setConnectTimeout(5000);

        //response
        int status = connection.getResponseCode();
        Reader streamReader = null;

        if (status > 299) {
            streamReader = new InputStreamReader(connection.getErrorStream());
            throw new Exception(streamReader.toString());
        } else {
            BufferedReader in = new BufferedReader(new InputStreamReader(connection.getInputStream()));
            String inputLine;
            StringBuffer content = new StringBuffer();
            while ((inputLine = in.readLine()) != null) {
                content.append(inputLine);
            }
            in.close();
            return convert(content.toString());
        }
    }

    public List<ProductDTO> requestMultiple(String requestMethod) throws Exception {
        connection.setRequestMethod(requestMethod);
        connection.setDoOutput(true);
        connection.setRequestProperty("Content-Type", "application/json");
        connection.setConnectTimeout(5000);

        //response
        int status = connection.getResponseCode();
        Reader streamReader = null;

        if (status > 299) {
            streamReader = new InputStreamReader(connection.getErrorStream());
            throw new Exception(streamReader.toString());
        } else {
            BufferedReader in = new BufferedReader(new InputStreamReader(connection.getInputStream()));
            String inputLine;
            StringBuffer content = new StringBuffer();
            while ((inputLine = in.readLine()) != null) {
                content.append(inputLine);
            }
            in.close();
            return convertMultiple(content.toString());
        }
    }

    protected abstract ProductDTO convert(String toString) throws Exception;

    protected abstract List<ProductDTO> convertMultiple(String toString) throws Exception;

}
