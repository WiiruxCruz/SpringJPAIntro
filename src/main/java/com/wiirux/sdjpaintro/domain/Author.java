package com.wiirux.sdjpaintro.domain;

import java.util.Objects;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;

@Entity
public class Author {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	
	private String first_name;
	private String last_name;
	
	public Author() {
		
	}

	public Author(String first_name, String last_name) {
		this.first_name = first_name;
		this.last_name = last_name;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj) return true;
		if (obj == null || getClass() != obj.getClass()) return false;
		
		Author author = (Author) obj;
		
		//return id != null ? id.equals(book.id) : book.id == null;
		return Objects.equals(id, author.id);
	}
	
	@Override
	public int hashCode() {
		//return Objects.hash(id);
		return id != null ? id.hashCode() : 0;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getFirst_name() {
		return first_name;
	}

	public void setFirst_name(String first_name) {
		this.first_name = first_name;
	}

	public String getLast_name() {
		return last_name;
	}

	public void setLast_name(String last_name) {
		this.last_name = last_name;
	}
	
	
}
