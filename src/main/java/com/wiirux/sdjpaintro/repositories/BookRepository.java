package com.wiirux.sdjpaintro.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.wiirux.sdjpaintro.domain.Book;

public interface BookRepository extends JpaRepository<Book, Long> {

}
