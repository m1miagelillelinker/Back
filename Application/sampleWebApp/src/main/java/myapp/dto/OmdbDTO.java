package myapp.dto;

import myapp.model.Tag;

import java.util.Date;
import java.util.List;

public class OmdbDTO {

    String id;
    String title;
    String Description;
    String country;
    String director;
    String year;
    Tag genre;
    String image;
    String duration;
    String nbSeasons;


    public OmdbDTO(String id, String title, String description, String country, String director, String year, Tag genre, String image, String duration, String nbSeasons) {
        this.id = id;
        this.title = title;
        Description = description;
        this.country = country;
        this.director = director;
        this.year = year;
        this.genre = genre;
        this.image = image;
        this.duration = duration;
        this.nbSeasons = nbSeasons;
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
        return Description;
    }

    public void setDescription(String description) {
        Description = description;
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
                ", Description='" + Description + '\'' +
                ", country='" + country + '\'' +
                ", director='" + director + '\'' +
                ", year='" + year + '\'' +
                ", genre=" + genre +
                ", image='" + image + '\'' +
                ", duration='" + duration + '\'' +
                ", nbSeasons='" + nbSeasons + '\'' +
                '}';
    }
}
