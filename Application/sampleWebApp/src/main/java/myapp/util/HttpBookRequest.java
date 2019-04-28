package myapp.util;

import com.fasterxml.jackson.databind.ObjectMapper;
import myapp.dto.GoogleBooksDTO;
import myapp.dto.ProductDTO;

import java.io.IOException;
import java.util.List;

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
            //return productDTO.convertBooksToProduct(googleBooksDTO);
            return null;
        } catch (IOException e) {
            e.printStackTrace();
            throw new Exception();
        }
    }

    @Override
    protected List<ProductDTO> convertMultiple(String toString) throws Exception {
        while(true){
            System.out.println(toString);
        }
    }

}
