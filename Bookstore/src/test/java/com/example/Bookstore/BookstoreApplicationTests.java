package com.example.Bookstore;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;
import static org.assertj.core.api.Assertions.assertThat;
import com.example.Bookstore.web.BookstoreController;
import org.junit.runner.RunWith;


@RunWith(SpringRunner.class)
@SpringBootTest
class BookstoreApplicationTests {

	@Autowired
	private BookstoreController controller;
	
	@Test
	void contextLoads() {
		assertThat(controller).isNotNull();
	}

}
