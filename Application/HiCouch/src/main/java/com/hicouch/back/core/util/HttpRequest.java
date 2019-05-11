package com.hicouch.back.core.util;

import com.hicouch.back.core.dto.ProductDTO;

import java.io.*;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.ArrayList;
import java.util.List;

import org.json.JSONArray;
import org.json.JSONObject;

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

    protected List<ProductDTO> convertMultiple(String toString) throws Exception {
        List <ProductDTO> productDTOs = new ArrayList<>();
        try {
            JSONObject jsonObject = new JSONObject(toString);
            JSONArray jsonArray = jsonObject.getJSONArray("Search");

            for( Object jo : jsonArray){
                productDTOs.add(convert(jo.toString()));
            }
            return productDTOs;
        } catch (Exception e) {
            e.printStackTrace();
            throw new Exception();
        }
    }

}
