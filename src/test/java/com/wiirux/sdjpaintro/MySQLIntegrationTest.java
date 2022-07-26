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

import com.wiirux.sdjpaintro.repositories.BookRepository;

@ActiveProfiles("local")
@DataJpaTest
@ComponentScan( basePackages = {"com.wiirux.sdjpaintro.bootstrap"})
@AutoConfigureTestDatabase( replace = AutoConfigureTestDatabase.Replace.NONE)
public class MySQLIntegrationTest {
	
	@Autowired
	BookRepository br;
	
	@Test
	void tetsMySQL() {
		long countBefore = br.count();
		
		assertThat(countBefore).isEqualTo(2);
	}
}
