package com.hicouch.back.core.dto;

public class OmdbDTO {

    String id;
    String title;
    String description;
    String country;
    String director;
    String year;
    String genre;
    String image;
    String duration;
    String nbSeasons;
    String type;


    public OmdbDTO(String id, String title, String description, String country, String director, String year, String genre, String image, String duration, String nbSeasons) {
        this.id = id;
        this.title = title;
        this.description = description;
        this.country = country;
        this.director = director;
        this.year = year;
        this.genre = genre;
        this.image = image;
        this.duration = duration;
        this.nbSeasons = nbSeasons;
    }

    public OmdbDTO() {
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

    public String getDuration() {
        return duration;
    }

    public void setDuration(String duration) {
        this.duration = duration;
    }

    public String getNbSeasons() {
        return nbSeasons;
    }

    public void setNbSeasons(String nbSeasons) {
        this.nbSeasons = nbSeasons;
    }

    @Override
    public String toString() {
        return "OmdbDTO{" +
                "id=" + id +
                ", title='" + title + '\'' +
                ", description='" + description + '\'' +
                ", country='" + country + '\'' +
                ", director='" + director + '\'' +
                ", year='" + year + '\'' +
                ", genre=" + genre +
                ", image='" + image + '\'' +
                ", duration='" + duration + '\'' +
                ", nbSeasons='" + nbSeasons + '\'' +
                '}';
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
}
