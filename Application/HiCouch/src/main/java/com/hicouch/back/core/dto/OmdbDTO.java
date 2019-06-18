package com.hicouch.back.core.dto;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.hicouch.back.core.enumeration.ProductTypeEnum;

public class OmdbDTO extends ProductDTOFromReferentiel {

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
	private final Logger logger = LoggerFactory.getLogger(this.getClass());

	public OmdbDTO(String id, String title, String description, String country, String director, String year,
			String genre, String image, String duration, String nbSeasons) {
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

	@Override
	public ProductDTO toProductDTO() {
		ProductDTO productDTO = new ProductDTO();
		productDTO.setId(this.getId());
		productDTO.setTitle(this.getTitle());
		productDTO.setDescription(this.getDescription());
		productDTO.setCountry(this.getCountry());
		productDTO.setDirector(this.getDirector());
		productDTO.setYear(this.getYear());
		productDTO.setType(this.getType());

		/**
		 * TODO : gestion des tags + liste produit associé
		 */
		// List<Tag> listTag = new ArrayList<>();
		// listTag.add(omdbDTO.getGenre());
		productDTO.setImage(this.getImage());
		productDTO.setDuration(this.getDuration());
		return productDTO;
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
		return "OmdbDTO{" + "id=" + id + ", title='" + title + '\'' + ", description='" + description + '\''
				+ ", country='" + country + '\'' + ", director='" + director + '\'' + ", year='" + year + '\''
				+ ", genre=" + genre + ", image='" + image + '\'' + ", duration='" + duration + '\'' + ", nbSeasons='"
				+ nbSeasons + '\'' + '}';
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
