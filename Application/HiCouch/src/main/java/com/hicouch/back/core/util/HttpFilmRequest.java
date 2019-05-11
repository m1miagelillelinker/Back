package com.hicouch.back.core.util;

import com.hicouch.back.core.dto.ProductDTO;
import com.hicouch.back.core.dto.OmdbDTO;
import org.json.JSONArray;
import org.json.JSONObject;

import java.util.ArrayList;
import java.util.List;

public class HttpFilmRequest extends HttpRequest{

    public HttpFilmRequest(String url){
        super(url);
    }

    @Override
    protected ProductDTO convert(String toString) throws Exception {
        OmdbDTO omdbDTO = new OmdbDTO();
        
        try {
            JSONObject jsonObject = new JSONObject(toString);
            omdbDTO.setId(jsonObject.getString("imdbID"));
            omdbDTO.setTitle(jsonObject.getString("Title"));
            omdbDTO.setDescription(jsonObject.getString("Plot"));
            omdbDTO.setCountry(jsonObject.getString("Country"));
            omdbDTO.setDirector(jsonObject.getString("Director"));
            omdbDTO.setYear(jsonObject.getString("Year"));
            omdbDTO.setGenre(jsonObject.getString("Genre"));
            omdbDTO.setImage(jsonObject.getString("Poster"));
            omdbDTO.setDuration(jsonObject.getString("Runtime"));
            omdbDTO.setType(jsonObject.getString("Type"));
        } catch (Exception e) {
            e.printStackTrace();
        }

        return omdbDTO.toProductDTO();
    }

}
