package com.hicouch.back.core.util;

import com.hicouch.back.core.dto.GoogleBooksDTO;
import com.hicouch.back.core.dto.ProductDTO;
import org.json.JSONArray;
import org.json.JSONObject;

import java.util.List;

public class HttpBookRequest extends HttpRequest {

    public HttpBookRequest(String url) {
        super(url);
    }

    @Override
    protected ProductDTO convert(String toString) throws Exception {
        ProductDTO productDTO = new ProductDTO();
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
            return productDTO.convertBooksToProduct(googleBooksDTO);
        } catch (Exception e) {
            throw new Exception();
        }

    }

    @Override
    protected List<ProductDTO> convertMultiple(String toString) throws Exception {
        while (true) {
            System.out.println(toString);
        }
    }

}
