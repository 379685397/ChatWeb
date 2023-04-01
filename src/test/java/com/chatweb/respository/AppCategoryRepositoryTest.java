package com.chatweb.respository;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;


@RunWith(SpringRunner.class)
@SpringBootTest
public class AppCategoryRepositoryTest {

	@Autowired
  private AppCategoryRepository appCategoryRepository;

	@Test
	public void testUpdateAppAmount() throws Exception {
           //appCategoryRepository.updateAppAmount(1L,-2L);
	}

}