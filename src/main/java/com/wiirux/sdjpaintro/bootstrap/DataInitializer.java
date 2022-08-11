package com.wiirux.sdjpaintro.bootstrap;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Profile;
import org.springframework.stereotype.Component;

import com.wiirux.sdjpaintro.domain.AuthorUuid;
import com.wiirux.sdjpaintro.domain.Book;
import com.wiirux.sdjpaintro.domain.BookUuid;
import com.wiirux.sdjpaintro.repositories.AuthorUuidRepository;
import com.wiirux.sdjpaintro.repositories.BookRepository;
import com.wiirux.sdjpaintro.repositories.BookUuidRepository;


@Profile({"local", "default"})
@Component
public class DataInitializer implements CommandLineRunner {
	
	private final BookRepository br;
	private final AuthorUuidRepository aur;
	private final BookUuidRepository bur;
	
	public DataInitializer(
			BookRepository br,
			AuthorUuidRepository aur,
			BookUuidRepository bur
	) {
		this.br = br;
		this.aur = aur;
		this.bur = bur;
	}

	@Override
	public void run(String... args) throws Exception {
		
		br.deleteAll();
		
		Book bookDDD = new Book("Domain Driven Design", "123", "RandomHouse", null);
		
		System.out.println("ID:" + bookDDD.getId());
		
		Book savedDDD = br.save(bookDDD);
		
		Book bookSIA = new Book("Spring in Action", "234234", "Oreily", null);
		Book savedSIA = br.save(bookSIA);
		
		br.findAll().forEach( book -> {
			System.out.println("Book id:" + book.getId());
			System.out.println("Book title:" + book.getTitle());
			System.out.println("Book ISBN:" + book.getIsbn());
		} );
		
		AuthorUuid authorUuid = new AuthorUuid();
		authorUuid.setFirstName("Joe");
		authorUuid.setLastName("Black");
		
		AuthorUuid savedAuthor = aur.save(authorUuid);
		System.out.println("Saved Author UUID: " + savedAuthor.getId());
		
		BookUuid bookUuid = new BookUuid();
		bookUuid.setTitle("All about UUIDs");
		BookUuid savedBookUuid = bur.save(bookUuid);
		System.out.println("Saved Book UUID: " + savedBookUuid.getId());
	}

}
