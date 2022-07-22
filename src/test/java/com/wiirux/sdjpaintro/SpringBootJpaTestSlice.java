package com.wiirux.sdjpaintro;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;

import com.wiirux.sdjpaintro.domain.Book;
import com.wiirux.sdjpaintro.repositories.BookRepository;

@DataJpaTest
class SpringBootJpaTestSlice {
	
	@Autowired
	BookRepository br;

	@Test
	void test() {
		long countBefore = br.count();
		
		br.save(new Book("My Book", "1235555", "Self"));
		
		long countAfter = br.count();
		
		assertThat(countBefore).isLessThan(countAfter);
	}

}
