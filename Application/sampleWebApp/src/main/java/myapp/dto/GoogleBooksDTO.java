package myapp.dto;

import myapp.model.Tag;

import java.util.Date;
import java.util.List;

public class GoogleBooksDTO {

    Integer id;
    String title;
    String description;
    String author;
    String year;
    Tag genre;
    String image;

    public GoogleBooksDTO(Integer id, String title, String description, String author, String year, Tag genre, String image) {
        this.id = id;
        this.title = title;
        this.description = description;
        this.author = author;
        this.year = year;
        this.genre = genre;
        this.image = image;
    }

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