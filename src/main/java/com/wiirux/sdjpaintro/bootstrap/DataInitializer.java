package com.wiirux.sdjpaintro.bootstrap;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Profile;
import org.springframework.stereotype.Component;

import com.wiirux.sdjpaintro.domain.Book;
import com.wiirux.sdjpaintro.repositories.BookRepository;


@Profile({"local", "default"})
@Component
public class DataInitializer implements CommandLineRunner {
	
	private final BookRepository br;
	
	public DataInitializer(BookRepository br) {
		this.br = br;
	}

	@Override
	public void run(String... args) throws Exception {
		
		br.deleteAll();
		
		Book bookDDD = new Book("Domain Driven Design", "123", "RandomHouse");
		
		System.out.println("ID:" + bookDDD.getId());
		
		Book savedDDD = br.save(bookDDD);
		
		Book bookSIA = new Book("Spring in Action", "234234", "Oreily");
		Book savedSIA = br.save(bookSIA);
		
		br.findAll().forEach( book -> {
			System.out.println("Book id:" + book.getId());
			System.out.println("Book title:" + book.getTitle());
			System.out.println("Book ISBN:" + book.getIsbn());
		} );
	}

}
