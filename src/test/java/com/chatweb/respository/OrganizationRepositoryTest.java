package com.chatweb.respository;

import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;


@RunWith(SpringRunner.class)
@SpringBootTest
public class OrganizationRepositoryTest {

	@Autowired
  private OrganizationRepository organizationRepository;

	@Test
	public void testApps() throws Exception {
		String url = organizationRepository.findByShortUrl("utry").getShortUrl();
		Assert.assertEquals(url,"utry");
	}

}