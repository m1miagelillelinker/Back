package myapp.util;

import com.fasterxml.jackson.databind.ObjectMapper;
import myapp.dto.OmdbDTO;
import myapp.dto.ProductDTO;

import java.io.IOException;

public class HttpFilmRequest extends HttpRequest{

    public HttpFilmRequest(String url){
        super(url);
    }

    @Override
    protected ProductDTO convert(String toString) throws Exception {
        ProductDTO productDTO = new ProductDTO();
        ObjectMapper mapper = new ObjectMapper();
        try {
            OmdbDTO omdbDTO = mapper.readValue(toString, OmdbDTO.class);
            return productDTO.convertOmdbToProduct(omdbDTO);
        } catch (IOException e) {
            e.printStackTrace();
            throw new Exception();
        }
    }

}
