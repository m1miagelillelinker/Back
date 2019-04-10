package myapp.dto;

import myapp.model.Tag;

import java.util.Date;

public class ProductDTO {

    Integer id;
    String title;
    String description;
    String country;
    String director;
    String year;
    Tag genre;
    String image;
    Date duration;

    public ProductDTO(Integer id, String title, String description, String country, String director, String year, Tag genre, String image, Date duration) {
        this.id = id;
        this.title = title;
        this.description = description;
        this.country = country;
        this.director = director;
        this.year = year;
        this.genre = genre;
        this.image = image;
        this.duration = duration;
    }

    public ProductDTO(){}


    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getCountry() {
        return country;
    }

    public void setCountry(String country) {
        this.country = country;
    }

    public String getDirector() {
        return director;
    }

    public void setDirector(String director) {
        this.director = director;
    }

    public String getYear() {
        return year;
    }

    public void setYear(String year) {
        this.year = year;
    }

    public Tag getGenre() {
        return genre;
    }

    public void setGenre(Tag genre) {
        this.genre = genre;
    }

    public String getImage() {
        return image;
    }

    public void setImage(String image) {
        this.image = image;
    }

    public Date getDuration() {
        return duration;
    }

    public void setDuration(Date duration) {
        this.duration = duration;
    }

    @Override
    public String toString() {
        return "ProductDTO{" +
                "id=" + id +
                ", title='" + title + '\'' +
                ", description='" + description + '\'' +
                ", country='" + country + '\'' +
                ", director='" + director + '\'' +
                ", year='" + year + '\'' +
                ", genre=" + genre +
                ", image='" + image + '\'' +
                ", duration=" + duration +
                '}';
    }

    public ProductDTO convertOmdbToProduct(OmdbDTO omdbDTO){
        ProductDTO productDTO = new ProductDTO();
        productDTO.setId(omdbDTO.getId());
        productDTO.setTitle(omdbDTO.getTitle());
        productDTO.setDescription(omdbDTO.getDescription());
        productDTO.setCountry(omdbDTO.getCountry());
        productDTO.setDirector(omdbDTO.getDirector());
        productDTO.setYear(omdbDTO.getYear());
        productDTO.setGenre(omdbDTO.getGenre());
        productDTO.setImage(omdbDTO.getImage());
        productDTO.setDuration(new Date());
        return productDTO;
    }

    public ProductDTO convertBooksToProduct(GoogleBooksDTO googleBooksDTO){
        ProductDTO productDTO = new ProductDTO();
        productDTO.setId(googleBooksDTO.getId());
        productDTO.setTitle(googleBooksDTO.getTitle());
        productDTO.setDescription(googleBooksDTO.getDescription());
        productDTO.setCountry("");
        productDTO.setDirector(googleBooksDTO.getAuthor());
        productDTO.setYear(googleBooksDTO.getYear());
        productDTO.setGenre(googleBooksDTO.getGenre());
        productDTO.setImage(googleBooksDTO.getImage());
        productDTO.setDuration(new Date());
        return productDTO;
    }

    public ProductDTO convertGamesToProduct(){return new ProductDTO();}
}
