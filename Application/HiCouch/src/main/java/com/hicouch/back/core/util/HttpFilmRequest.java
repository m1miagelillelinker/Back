package com.hicouch.back.core.util;

import com.hicouch.back.core.dto.OmdbDTO;
import com.hicouch.back.core.dto.ProductDTO;
import com.hicouch.back.core.enumeration.ProductTypeEnum;
import org.json.JSONArray;
import org.json.JSONObject;

import java.util.ArrayList;
import java.util.List;

public class HttpFilmRequest extends HttpRequest {

    public HttpFilmRequest(String url) {
        super(url);
    }

    @Override
    protected ProductDTO convert(String toString) throws Exception {
        OmdbDTO omdbDTO = new OmdbDTO();
        JSONObject jsonObject = new JSONObject(toString);
        // movie par défaut
        omdbDTO.setType(ProductTypeEnum.MOVIE);
        try {
            omdbDTO.setTitle(jsonObject.getString("Title"));
        } catch (Exception e) {
            omdbDTO.setTitle(null);
        }
        
        try {
            omdbDTO.setId(jsonObject.getString("imdbID"));
        } catch (Exception e) {
            omdbDTO.setId(null);
        }

        try {
            if(jsonObject.getString("Type").equals("series")) {
                omdbDTO.setType(ProductTypeEnum.SERIE);
            }
        } catch (Exception e) {
            omdbDTO.setType(null);
        }

        try {
            omdbDTO.setDescription(jsonObject.getString("Plot"));
        } catch (Exception e) {
            omdbDTO.setDescription(null);
        }

        try {
            omdbDTO.setCountry(jsonObject.getString("Country"));
        } catch (Exception e) {
            omdbDTO.setCountry(null);
        }

        try {
            omdbDTO.setDirector(jsonObject.getString("Director"));
        } catch (Exception e) {
            omdbDTO.setDirector(null);
        }

        try {
            omdbDTO.setYear(jsonObject.getString("Year"));
        } catch (Exception e) {
            omdbDTO.setYear(null);
        }

        try {
            omdbDTO.setGenre(jsonObject.getString("Genre"));
        } catch (Exception e) {
            omdbDTO.setGenre(null);
        }

        try {
            omdbDTO.setImage(jsonObject.getString("Poster"));
        } catch (Exception e) {
            omdbDTO.setImage(null);
        }

        try {
            omdbDTO.setDuration(jsonObject.getString("Runtime"));
        } catch (Exception e) {
            omdbDTO.setDuration(null);
        }
        

        return omdbDTO.toProductDTO();
    }

    @Override
    protected List<ProductDTO> convertMultiple(String toString) throws Exception {
        List<ProductDTO> productDTOS = new ArrayList<>();
        try {
            JSONObject jsonObject = new JSONObject(toString);
            JSONArray jsonArray = jsonObject.getJSONArray("Search");

            for (Object jo : jsonArray) {
                productDTOS.add(convert(jo.toString()));
            }
            return productDTOS;
        } catch (Exception e) {
            e.printStackTrace();
            throw new Exception();
        }
    }

}
