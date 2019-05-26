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

        System.out.println("cc");

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

        String id = jsonObject.get("id") != null ? jsonObject.get("id").toString() : "null";
        String title = jsonObject.get("name") != null ? jsonObject.get("name").toString() : "null";
        String description = jsonObject.get("summary") != null ? jsonObject.get("summary").toString() : "null";
        String country = "FR";
        String director = jsonObject.get("rating") != null ? jsonObject.get("rating").toString() : "null";

        String lg = jsonObject.get("created_at") != null ? jsonObject.get("created_at").toString() : "null";
        String year = lg.equals("null") ? lg : new Date(Long.parseLong(lg) * 1000).toString();

        List<String> genre = new ArrayList<>();
        List<Association> listProduits = new ArrayList<>();

        HttpResponse<JsonNode> jsonResponse2 = Unirest.post("https://api-v3.igdb.com/covers")
                .header("user-key", "830955496b4f26e3eba871f4b951ecea")
                .header("Accept", "application/json")
                .body("fields * ; where game = "+id+";")
                .asJson();

        String image = jsonResponse2.getBody().getArray().getJSONObject(0).get("url") != null ? jsonResponse2.getBody().getArray().getJSONObject(0).get("url").toString() : "null";
        if(image.contains("cover_small") || image.contains("screenshot_med") || image.contains("cover_big") ||
                image.contains("logo_med") || image.contains("screenshot_big") || image.contains("screenshot_huge")
                ||image.contains("thumb") || image.contains("micro") || image.contains("720p")){

            image = image.replaceFirst("/t_(.*)/","/t_1080p/");
        }
        String duration = "null";
        String type = ProductTypeEnum.BOOK;

        return new ProductDTO(id, title, description, country, director, year, genre, listProduits, image, duration, type);
    }
}