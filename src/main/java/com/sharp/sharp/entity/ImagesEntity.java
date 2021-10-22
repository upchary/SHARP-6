package com.sharp.sharp.entity;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Lob;

import org.springframework.web.multipart.MultipartFile;

@Entity

public class ImagesEntity {

	@Id
	@GeneratedValue
	private long id;

	private String name;

	@Lob
	private MultipartFile image;

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public MultipartFile getImage() {
		return image;
	}

	public void setImage(MultipartFile multipartFile) {
		this.image = multipartFile;
	}
}
