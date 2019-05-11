package com.hicouch.back.core.dto;

import com.hicouch.back.core.model.Association;
import com.hicouch.back.core.model.Tag;

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
    List<Tag> tags;
    String image;
    String duration;
    String type;

    public ProductDTO(String id, String title, String description, String country, String director, String year, List<String> genre, List<Association> listProduits, String image, String duration, String type) {
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
        this.type = type;
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

	/**
	 * @return the type
	 */
	public String getType() {
		return type;
	}

	/**
	 * @param type the type to set
	 */
	public void setType(String type) {
		this.type = type;
	}

	public List<Tag> getTags() {
		return tags;
	}

	public void setTags(List<Tag> tags) {
		this.tags = tags;
	}

}
