package com.chatweb.respository;

import com.chatweb.domain.entity.App;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import org.springframework.data.domain.Example;
import org.springframework.data.domain.ExampleMatcher;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.List;


@RunWith(SpringRunner.class)
@SpringBootTest
public class AppRepositoryTest {

	@Autowired
  private AppRepository appRepository;

	@Autowired
	private AppCategoryRepository appCategoryRepository;

	@Test
	public void testApps() throws Exception {
		long cnt = appRepository.findAllByOrgId(1l).size();
		Assert.assertEquals(cnt,1);
	}

	@Test
	public void testAppsContains() throws Exception {
		long cnt = appRepository.findAllByTitleContains("日报").size();
		Assert.assertEquals(cnt,1);
	}


	@Test
	public void testExampleMatcher() throws Exception {
		App app = new App();
		app.setOrgId(1L);
		app.setCategoryId(5L);

		/*
		* 		ExampleMatcher matcher = ExampleMatcher.matching()
				.withMatcher("username", ExampleMatcher.GenericPropertyMatchers.startsWith())//模糊查询匹配开头，即{username}%
				.withMatcher("address" , ExampleMatcher.GenericPropertyMatchers.contains())//全部模糊查询，即%{address}%
				.withIgnorePaths("password")//忽略字段，即不管password是什么值都不加入查询条件
				.withIgnorePaths("id");  //忽略属性：是否关注。因为是基本类型，需要忽略掉
		* */


		ExampleMatcher matcher = ExampleMatcher.matching()
				.withMatcher("orgId", ExampleMatcher.GenericPropertyMatchers.contains())
				.withMatcher("categoryId" , ExampleMatcher.GenericPropertyMatchers.contains());
		Example<App> example = Example.of(app ,matcher);
		List<App> list = appRepository.findAll(example);
		Assert.assertEquals(list.size(),3);

	}

	@Test
	public void testNativeQuery() throws Exception {
		List<AppCategory> list = appCategoryRepository.findAllByOrgId(1L);
		Assert.assertEquals(list.size(),5);
	}

}