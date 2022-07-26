package com.wiirux.sdjpaintro;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.MethodOrderer;
import org.junit.jupiter.api.Order;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestMethodOrder;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.test.annotation.Commit;
import org.springframework.test.annotation.Rollback;

import com.wiirux.sdjpaintro.domain.Book;
import com.wiirux.sdjpaintro.repositories.BookRepository;

@TestMethodOrder(MethodOrderer.OrderAnnotation.class)
@DataJpaTest
@ComponentScan( basePackages = {"com.wiirux.sdjpaintro.bootstrap"})
@AutoConfigureTestDatabase( replace = AutoConfigureTestDatabase.Replace.NONE)
class SpringBootJpaTestSlice {
	
	@Autowired
	BookRepository br;
	
	//@Rollback( value = false )
	@Commit
	@Order(1)
	@Test
	void testJPATestSplice() {
		long countBefore = br.count();
		
		assertThat(countBefore).isEqualTo(2);
		
		br.save(new Book("My Book", "1235555", "Self"));
		
		long countAfter = br.count();
		
		assertThat(countBefore).isLessThan(countAfter);
	}
	
	@Order(2)
	@Test
	void testJpaTestSpliceTransaction() {
		long countBefore = br.count();
		
		assertThat(countBefore).isEqualTo(3);
	}

}
