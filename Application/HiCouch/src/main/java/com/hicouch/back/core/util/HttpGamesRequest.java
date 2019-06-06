package com.hicouch.back.core.util;

import com.hicouch.back.core.dto.ProductDTO;
import com.hicouch.back.core.enumeration.ProductTypeEnum;
import com.hicouch.back.core.exception.ReferentielRequestException;
import com.hicouch.back.core.model.Association;
import com.hicouch.back.core.model.Tag;
import com.mashape.unirest.http.HttpResponse;
import com.mashape.unirest.http.JsonNode;
import com.mashape.unirest.http.Unirest;
import com.mashape.unirest.http.exceptions.UnirestException;
import org.json.JSONArray;
import org.json.JSONObject;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class HttpGamesRequest {

    public HttpGamesRequest() {

    }

    public ProductDTO request(String gameId) throws UnirestException, ReferentielRequestException {

        HttpResponse<JsonNode> jsonResponse = Unirest.post("https://api-v3.igdb.com/games")
                .header("user-key", "830955496b4f26e3eba871f4b951ecea")
                .header("Accept", "application/json")
                .body("fields *; where id = " + gameId + ";")
                .asJson();

        if (jsonResponse.getStatus() > 299) {
            throw new ReferentielRequestException();
        } else {
            return convert(jsonResponse.getBody());
        }


    }

    public List<ProductDTO> requestMultiple(String keyword) throws UnirestException, ReferentielRequestException {

        HttpResponse<JsonNode> jsonResponse = Unirest.post("https://api-v3.igdb.com/games")
                .header("user-key", "830955496b4f26e3eba871f4b951ecea")
                .header("Accept", "application/json")
                .body("search \"" + keyword + "\"; fields *;")
                .asJson();
        if (jsonResponse.getStatus() > 299) {
            throw new ReferentielRequestException();
        } else {
            return convertMultiple(jsonResponse.getBody());
        }


    }

    private List<ProductDTO> convertMultiple(JsonNode body) throws UnirestException {
        JSONArray jsonArray = body.getArray();
        List<ProductDTO> listProduct = new ArrayList<>();

        for( Object jo : jsonArray) {
            JSONObject games = new JSONObject(jo.toString());
            listProduct.add(convert( new JsonNode(games.toString())));
        }

        return  listProduct;
    }

    private ProductDTO convert(JsonNode body) throws UnirestException {
        JSONObject jsonObject = body.getArray().getJSONObject(0);

        String id = null;
        String title = null;
        String description = null;
        String country = "FR";
        String director = null;
        String lg = null;
        String year = null;
        String image = null;


        try{
            id = jsonObject.get("id").toString();
        } catch (Exception ignored){}

        try{
            title = jsonObject.get("name").toString();
        }catch (Exception ignored){}

        try{
            description = jsonObject.get("summary").toString();
        }catch (Exception ignored){}

        try{
            director = jsonObject.get("rating").toString();
        }catch (Exception ignored){}

        try{
            lg = jsonObject.get("created_at").toString();
        }catch (Exception ignored){}

        try{
            year =new Date(Long.parseLong(lg) * 1000).toString();
        }catch (Exception ignored){}



        List<String> genre = new ArrayList<>();
        List<Association> listProduits = new ArrayList<>();

        HttpResponse<JsonNode> jsonResponse2 = Unirest.post("https://api-v3.igdb.com/covers")
                .header("user-key", "830955496b4f26e3eba871f4b951ecea")
                .header("Accept", "application/json")
                .body("fields * ; where game = "+id+";")
                .asJson();

        try{
            image = jsonResponse2.getBody().getArray().getJSONObject(0).get("url").toString();
            if(image.contains("cover_small") || image.contains("screenshot_med") || image.contains("cover_big") ||
                    image.contains("logo_med") || image.contains("screenshot_big") || image.contains("screenshot_huge")
                    ||image.contains("thumb") || image.contains("micro") || image.contains("720p")){

                image = image.replaceFirst("/t_(.*)/","/t_1080p/");
            }
        }catch (Exception e){
            image = null;
        }

        String duration = "null";
        String type = ProductTypeEnum.BOOK;

        return new ProductDTO(id, title, description, country, director, year, genre, listProduits, image, duration, type);
    }
}