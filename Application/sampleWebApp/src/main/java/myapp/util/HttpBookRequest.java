package myapp.util;

import com.fasterxml.jackson.databind.ObjectMapper;
import myapp.dto.GoogleBooksDTO;
import myapp.dto.OmdbDTO;
import myapp.dto.ProductDTO;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.Reader;

public class HttpBookRequest extends HttpRequest {

    public HttpBookRequest(String url) {
        super(url);
    }

    @Override
    protected ProductDTO convert(String toString) throws Exception {
        ProductDTO productDTO = new ProductDTO();
        ObjectMapper mapper = new ObjectMapper();
        try {
            GoogleBooksDTO googleBooksDTO = mapper.readValue(toString, GoogleBooksDTO.class);
            return productDTO.convertBooksToProduct(googleBooksDTO);
        } catch (IOException e) {
            e.printStackTrace();
            throw new Exception();
        }
    }

}
