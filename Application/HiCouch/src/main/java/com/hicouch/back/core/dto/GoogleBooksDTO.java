package com.hicouch.back.core.dto;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.ArrayList;
import java.util.List;

public class GoogleBooksDTO extends ProductDTOFromReferentiel {

    String id;
    String title;
    String description;
    String author;
    String year;
    String genre;
    String image;
    private final Logger logger = LoggerFactory.getLogger(this.getClass());

    public GoogleBooksDTO(String id, String title, String description, String author, String year, String genre, String image) {
        this.id = id;
        this.title = title;
        this.description = description;
        this.author = author;
        this.year = year;
        this.genre = genre;
        this.image = image;
    }
    
    @Override
    public ProductDTO toProductDTO(){
        ProductDTO productDTO = new ProductDTO();
        productDTO.setId(this.getId());
        productDTO.setTitle(this.getTitle());
        productDTO.setDescription(this.getDescription());
        productDTO.setCountry("FR");
        productDTO.setDirector(this.getAuthor());
        productDTO.setYear(this.getYear());
        productDTO.setType("book");
        List<String> listTag = new ArrayList<>();
        listTag.add(this.getGenre());
        productDTO.setGenre(listTag);
        productDTO.setImage(this.getImage());
        //productDTO.setDuration(LocalDateTime.now());
        return productDTO;
    }

    public GoogleBooksDTO() {
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
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

    public String getAuthor() {
        return author;
    }

    public void setAuthor(String author) {
        this.author = author;
    }

    public String getYear() {
        return year;
    }

    public void setYear(String year) {
        this.year = year;
    }

    public String getGenre() {
        return genre;
    }

    public void setGenre(String genre) {
        this.genre = genre;
    }

    public String getImage() {
        return image;
    }

    public void setImage(String image) {
        this.image = image;
    }

    @Override
    public String toString() {
        return "GoogleBooksDTO{" +
                "id=" + id +
                ", title='" + title + '\'' +
                ", description='" + description + '\'' +
                ", author='" + author + '\'' +
                ", year='" + year + '\'' +
                ", genre=" + genre +
                ", image='" + image + '\'' +
                '}';
    }
}
