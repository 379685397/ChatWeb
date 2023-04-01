package com.chatweb.service;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.io.File;
import java.util.List;


@RunWith(SpringRunner.class)
@SpringBootTest
public class StorageServiceTest {

	@Autowired
  private StorageService storageService;

	@Value("${web.upload}")
	private String webUpload;

	@Test
	public void testGetAssets() throws Exception {

		String path = webUpload+"upload/logo";
		//"D:\\work\\my\\webtap\\code\\webtap\\src\\main\\resources\\static\\upload\\logo"
		List<File> fileList = storageService.GetAssets(path);
		System.out.println("logo 数量==================================="+fileList.size());
	}

}