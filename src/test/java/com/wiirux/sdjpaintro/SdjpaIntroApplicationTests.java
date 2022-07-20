package com.wiirux.sdjpaintro;

import static org.assertj.core.api.Assertions.assertThat;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import com.wiirux.sdjpaintro.repositories.BookRepository;

@SpringBootTest
class SdjpaIntroApplicationTests {
	
	@Autowired
	BookRepository br;
	
	@Test
	void testBookRepository() {
		long count = br.count();
		assertThat(count).isGreaterThan(0);
	}

	@Test
	void contextLoads() {
	}

}
