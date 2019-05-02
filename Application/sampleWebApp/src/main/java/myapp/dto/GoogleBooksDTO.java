package myapp.dto;

import myapp.model.Tag;

public class GoogleBooksDTO{

    String id;
    String title;
    String description;
    String author;
    String year;
    String genre;
    String image;

    public GoogleBooksDTO(String id, String title, String description, String author, String year, String genre, String image) {
        this.id = id;
        this.title = title;
        this.description = description;
        this.author = author;
        this.year = year;
        this.genre = genre;
        this.image = image;
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
