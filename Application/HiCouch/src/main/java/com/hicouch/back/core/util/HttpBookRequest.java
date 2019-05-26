package com.hicouch.back.core.util;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.hicouch.back.core.dto.GoogleBooksDTO;
import com.hicouch.back.core.dto.ProductDTO;
import org.json.JSONArray;
import org.json.JSONObject;

import java.util.ArrayList;
import java.util.List;

public class HttpBookRequest extends HttpRequest {

    public HttpBookRequest(String url) {
        super(url);
    }

    @Override
    protected ProductDTO convert(String toString) throws Exception {
        GoogleBooksDTO googleBooksDTO = new GoogleBooksDTO();
        try {
            JSONObject jsonObject = new JSONObject(toString);
            JSONArray item = jsonObject.getJSONArray("items");
            JSONObject json = item.getJSONObject(0);
            JSONObject volumeInfo = json.getJSONObject("volumeInfo");

            googleBooksDTO.setTitle(volumeInfo.get("title").toString());
            googleBooksDTO.setDescription(volumeInfo.get("description").toString());
            googleBooksDTO.setAuthor(volumeInfo.getJSONArray("authors").getString(0));
            googleBooksDTO.setYear( volumeInfo.get("publishedDate").toString());
            googleBooksDTO.setGenre(volumeInfo.getJSONArray("categories").get(0).toString());
            googleBooksDTO.setImage(volumeInfo.getJSONObject("imageLinks").get("thumbnail").toString());
            googleBooksDTO.setId(volumeInfo.getJSONArray("industryIdentifiers").getJSONObject(0).get("identifier").toString());
            return googleBooksDTO.toProductDTO();
        } catch (Exception e) {
            throw new Exception();
        }

    }
    
    @Override
    protected List<ProductDTO> convertMultiple(String toString) throws Exception {
        List<ProductDTO> productDTOList = new ArrayList<>();
        JSONArray jsonArray = new JSONObject(toString).getJSONArray("items");

        GoogleBooksDTO googleBooksDTO = new GoogleBooksDTO();

        for (int i =0; i < jsonArray.length();i++){
            JSONObject jsonObject =jsonArray.getJSONObject(i);
            JSONObject volumeInfo = jsonObject.getJSONObject("volumeInfo");

            googleBooksDTO.setTitle(volumeInfo.get("title").toString());
            googleBooksDTO.setDescription(volumeInfo.get("subtitle").toString());
            googleBooksDTO.setAuthor(volumeInfo.getJSONArray("authors").getString(0));
            googleBooksDTO.setYear( volumeInfo.get("publishedDate").toString());
            googleBooksDTO.setGenre(volumeInfo.getJSONArray("categories").get(0).toString());
            googleBooksDTO.setImage(volumeInfo.getJSONObject("imageLinks").get("thumbnail").toString());
            googleBooksDTO.setId(volumeInfo.getJSONArray("industryIdentifiers").getJSONObject(0).get("identifier").toString());
            productDTOList.add(googleBooksDTO.toProductDTO());
        }
        return productDTOList;
    }

}
