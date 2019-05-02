package myapp.util;

import myapp.dto.OmdbDTO;
import myapp.dto.ProductDTO;
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
        ProductDTO productDTO = new ProductDTO();
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
            omdbDTO.setNbSeasons(jsonObject.getString("Type"));

            return productDTO.convertOmdbToProduct(omdbDTO);
        } catch (Exception e) {
            e.printStackTrace();
            throw new Exception();
        }
    }

    @Override
    protected List<ProductDTO> convertMultiple(String toString) throws Exception {
        List <ProductDTO> productDTOS = new ArrayList<>();
        OmdbDTO omdbDTO = new OmdbDTO();
        ProductDTO productDTO = new ProductDTO();
        try {
            JSONObject jsonObject = new JSONObject(toString);
            JSONArray jsonArray = jsonObject.getJSONArray("Search");

            for( Object jo : jsonArray){
                JSONObject film = new JSONObject(jo.toString());
                omdbDTO.setTitle(film.getString("Title"));
                omdbDTO.setYear(film.getString("Year"));
                omdbDTO.setId(film.getString("imdbID"));
                omdbDTO.setImage(film.getString("Poster"));
                productDTOS.add(productDTO.convertOmdbToProduct(omdbDTO));
            }
            return productDTOS;
        } catch (Exception e) {
            e.printStackTrace();
            throw new Exception();
        }
    }

}
