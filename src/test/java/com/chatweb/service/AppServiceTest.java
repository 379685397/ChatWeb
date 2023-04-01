package com.chatweb.service;

import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;


@RunWith(SpringRunner.class)
@SpringBootTest
public class AppServiceTest {

	@Autowired
  private AppService appService;

	@Autowired
	private AppCategoryService appCategoryService;

	@Test
	public void testApps() throws Exception {
		long cnt = appService.getAppsByOrgId(1l).size();
		Assert.assertEquals(cnt,1);
	}

	@Test
	public void testCategories() throws Exception {
		long cnt = appCategoryService.getAppCategories(1L).size();

		System.out.print("cnt===================================================="+cnt);
		Assert.assertEquals(cnt,4);
	}
}