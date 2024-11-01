package com.BAITAP28_10.__10;

import com.BAITAP28_10.__10.entity.Category;
import com.BAITAP28_10.__10.service.ICategoryService;
import com.BAITAP28_10.__10.service.Impl.CategoryService;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
class ApplicationTests {

    @Test
	void contextLoads() {

	}

	@Test
	void save(){
		Category category = new Category();
		category.setStatus(1);
		category.setId(1);
		category.setImage("def");
		category.setName("abc");

	}

}
