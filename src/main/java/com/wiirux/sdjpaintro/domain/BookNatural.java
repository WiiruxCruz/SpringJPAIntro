package com.wiirux.sdjpaintro.domain;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;

@Entity
public class BookNatural {
	
	@Id
	public String title;
	public String isbn;
	public String publisher;
	
	public String getTitle() {
		return title;
	}
	public void setTitle(String title) {
		this.title = title;
	}
	public String getIsbn() {
		return isbn;
	}
	public void setIsbn(String isbn) {
		this.isbn = isbn;
	}
	public String getPublisher() {
		return publisher;
	}
	public void setPublisher(String publisher) {
		this.publisher = publisher;
	}
}
