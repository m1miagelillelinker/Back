package com.hicouch.back.core.util;

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

            try{
                googleBooksDTO.setTitle(volumeInfo.get("title").toString());
            }catch (Exception e){
                googleBooksDTO.setTitle(null);
            }

            try{
                googleBooksDTO.setDescription(volumeInfo.get("description").toString());
            }catch (Exception e){
                googleBooksDTO.setDescription(null);
            }

            try{
                googleBooksDTO.setAuthor(volumeInfo.getJSONArray("authors").getString(0));
            }catch (Exception e){
                googleBooksDTO.setAuthor(null);
            }

            try{
                googleBooksDTO.setYear( volumeInfo.get("publishedDate").toString());
            }catch (Exception e){
                googleBooksDTO.setYear(null);
            }

            try{
                googleBooksDTO.setGenre(volumeInfo.getJSONArray("categories").get(0).toString());
            }catch (Exception e){
                googleBooksDTO.setGenre(null);
            }

            try{
                googleBooksDTO.setImage(volumeInfo.getJSONObject("imageLinks").get("thumbnail").toString());
            }catch (Exception e){
                googleBooksDTO.setImage(null);
            }

            try{
                googleBooksDTO.setId(volumeInfo.getJSONArray("industryIdentifiers").getJSONObject(0).get("identifier").toString());
            }catch (Exception e){
                googleBooksDTO.setId(null);
            }
            return googleBooksDTO.toProductDTO();
        } catch (Exception e) {
            e.printStackTrace();
            return null;
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

            try{
                googleBooksDTO.setTitle(volumeInfo.get("title").toString());
            }catch (Exception e){
                googleBooksDTO.setTitle(null);
            }

            try{
                googleBooksDTO.setDescription(volumeInfo.get("subtitle").toString());
            }catch (Exception e){
                googleBooksDTO.setDescription(null);
            }

            try{
                googleBooksDTO.setAuthor(volumeInfo.getJSONArray("authors").getString(0));
            }catch (Exception e){
                googleBooksDTO.setAuthor(null);
            }

            try{
                googleBooksDTO.setYear( volumeInfo.get("publishedDate").toString());
            }catch (Exception e){
                googleBooksDTO.setYear(null);
            }

            try{
                googleBooksDTO.setGenre(volumeInfo.getJSONArray("categories").get(0).toString());
            }catch (Exception e){
                googleBooksDTO.setGenre(null);
            }

            try{
                googleBooksDTO.setImage(volumeInfo.getJSONObject("imageLinks").get("thumbnail").toString());
            }catch (Exception e){
                googleBooksDTO.setImage(null);
            }

            try{
                googleBooksDTO.setId(volumeInfo.getJSONArray("industryIdentifiers").getJSONObject(0).get("identifier").toString());
            }catch (Exception e){
                googleBooksDTO.setId(null);
            }

            productDTOList.add(googleBooksDTO.toProductDTO());

        }
        return productDTOList;
    }

}
