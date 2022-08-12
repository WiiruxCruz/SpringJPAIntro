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
import com.wiirux.sdjpaintro.domain.BookNatural;
import com.wiirux.sdjpaintro.domain.BookUuid;
import com.wiirux.sdjpaintro.domain.composite.AuthorComposite;
import com.wiirux.sdjpaintro.domain.composite.AuthorEmbedded;
import com.wiirux.sdjpaintro.domain.composite.NameId;
import com.wiirux.sdjpaintro.repositories.AuthorCompositeRepository;
import com.wiirux.sdjpaintro.repositories.AuthorEmbeddedRepository;
import com.wiirux.sdjpaintro.repositories.AuthorUuidRepository;
import com.wiirux.sdjpaintro.repositories.BookNaturalRepository;
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
	
	@Autowired
	BookNaturalRepository bnr;

	@Autowired
	AuthorCompositeRepository acr;
	
	@Autowired
	AuthorEmbeddedRepository aer;
	@Test
	void authorEmbeddedTest() {
		NameId nameId = new NameId("John", "E");
		AuthorEmbedded ae =  new AuthorEmbedded(nameId);
		
		AuthorEmbedded saved = aer.save(ae);
		assertThat(saved).isNotNull();
		
		AuthorEmbedded fetched = aer.getById(nameId);
		assertThat(fetched).isNotNull();
	}
	
	@Test
	void authorCompositeTest() {
		NameId nameId = new NameId("John", "T");
		AuthorComposite authorComposite = new AuthorComposite();
		authorComposite.setFirstName(nameId.getFirstName());
		authorComposite.setLastName(nameId.getLastName());
		authorComposite.setCountry("US");
		
		AuthorComposite saved =  acr.save(authorComposite);
		assertThat(saved).isNotNull();
		System.out.println(saved.getFirstName());
		System.out.println(saved.getLastName());
		
		AuthorComposite fetched = acr.getById(nameId);
		assertThat(fetched).isNotNull();
	}
	
	@Test
	void bookNaturalTest() {
		BookNatural bookNatural = new BookNatural();
		bookNatural.setTitle("My Book");
		BookNatural saved = bnr.save(bookNatural);
		
		BookNatural fetched = bnr.getById(saved.getTitle());
		assertThat(fetched).isNotNull();
	}
	
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
