package com.wiirux.sdjpaintro;

import static org.assertj.core.api.Assertions.assertThat;

import org.junit.jupiter.api.Order;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase.Replace;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.test.context.ActiveProfiles;

import com.wiirux.sdjpaintro.domain.AuthorUuid;
import com.wiirux.sdjpaintro.domain.BookUuid;
import com.wiirux.sdjpaintro.repositories.AuthorUuidRepository;
import com.wiirux.sdjpaintro.repositories.BookRepository;
import com.wiirux.sdjpaintro.repositories.BookUuidRepository;

@ActiveProfiles("local")
@DataJpaTest
@ComponentScan( basePackages = {"com.wiirux.sdjpaintro.bootstrap"})
@AutoConfigureTestDatabase( replace = AutoConfigureTestDatabase.Replace.NONE)
public class MySQLIntegrationTest {
	
	@Autowired
	BookRepository br;
	
	@Autowired
	AuthorUuidRepository aur;
	
	@Autowired
	BookUuidRepository bur;
	
	@Test
	void testBookUuid() {
		BookUuid bookUuid = bur.save(new BookUuid());
		assertThat(bookUuid).isNotNull();
		assertThat(bookUuid.getId());
		
		BookUuid fetched = bur.getById(bookUuid.getId());
		assertThat(fetched).isNotNull();
		
		
	}
	
	@Test
	void testAuthorId() {
		AuthorUuid authorUuid = aur.save(new AuthorUuid());
		assertThat(authorUuid).isNotNull();
		assertThat(authorUuid.getId()).isNotNull();
		
		AuthorUuid fetched = aur.getById(authorUuid.getId());
		assertThat(fetched).isNotNull();
	}
	
	@Test
	void tetsMySQL() {
		long countBefore = br.count();
		assertThat(countBefore).isEqualTo(2);
	}
}
