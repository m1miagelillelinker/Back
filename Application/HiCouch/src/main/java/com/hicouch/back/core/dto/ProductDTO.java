package com.hicouch.back.core.dto;

import com.hicouch.back.core.model.Association;

import java.util.ArrayList;
import java.util.List;

public class ProductDTO {

    //TODO: ajouter un type
    String id;
    String title;
    String description;
    String country;
    String director;
    String year;
    List<String> genre;
    List<Association> listProduits;
    String image;
    String duration;

    public ProductDTO(String id, String title, String description, String country, String director, String year, List<String> genre, List<Association> listProduits, String image, String duration) {
        this.id = id;
        this.title = title;
        this.description = description;
        this.country = country;
        this.director = director;
        this.year = year;
        this.genre = genre;
        this.listProduits = listProduits;
        this.image = image;
        this.duration = duration;
    }

    public ProductDTO() {};

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

    public List<String> getGenre() {
        return genre;
    }

    public void setGenre(List<String> genre) {
        this.genre = genre;
    }

    public List<Association> getListProduits() {
        return listProduits;
    }

    public void setListProduits(List<Association> listProduits) {
        this.listProduits = listProduits;
    }

    public String getImage() {
        return image;
    }

    public void setImage(String image) {
        this.image = image;
    }

    public String getDuration() {
        return duration;
    }

    public void setDuration(String duration) {
        this.duration = duration;
    }






    public ProductDTO convertOmdbToProduct(OmdbDTO omdbDTO){
        ProductDTO productDTO = new ProductDTO();
        productDTO.setId(omdbDTO.getId());
        productDTO.setTitle(omdbDTO.getTitle());
        productDTO.setDescription(omdbDTO.getDescription());
        productDTO.setCountry(omdbDTO.getCountry());
        productDTO.setDirector(omdbDTO.getDirector());
        productDTO.setYear(omdbDTO.getYear());

        /**
         * TODO : gestion des tags + liste produit associé
         */
        //List<Tag> listTag = new ArrayList<>();
        //listTag.add(omdbDTO.getGenre());
        productDTO.setImage(omdbDTO.getImage());
        productDTO.setDuration(omdbDTO.getDuration());
            return productDTO;
    }


    public ProductDTO convertBooksToProduct(GoogleBooksDTO googleBooksDTO){
        ProductDTO productDTO = new ProductDTO();
        productDTO.setId(googleBooksDTO.getId());
        productDTO.setTitle(googleBooksDTO.getTitle());
        productDTO.setDescription(googleBooksDTO.getDescription());
        productDTO.setCountry("FR");
        productDTO.setDirector(googleBooksDTO.getAuthor());
        productDTO.setYear(googleBooksDTO.getYear());
        /**
         * TODO : gestion des tags + liste produit associé
         */
        List<String> listTag = new ArrayList<>();
        listTag.add(googleBooksDTO.getGenre());
        productDTO.setGenre(listTag);
        productDTO.setImage(googleBooksDTO.getImage());
        //productDTO.setDuration(new Date());
        return productDTO;
    }

    public ProductDTO convertGamesToProduct(){return new ProductDTO();}
}
