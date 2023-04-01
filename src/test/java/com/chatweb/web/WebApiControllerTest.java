package com.chatweb.web;

import com.chatweb.WebtapApplication;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.web.client.TestRestTemplate;
import org.springframework.boot.web.server.LocalServerPort;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.test.context.junit4.SpringRunner;


@RunWith(SpringRunner.class)

@SpringBootTest(classes = WebtapApplication.class, webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)

public class WebApiControllerTest {

    @Autowired
    private AppService appService;


    @Autowired
    private TestRestTemplate restTemplate;
    @LocalServerPort
    private int port;

    private String getRootUrl() {
        return "http://localhost:" + port;
    }

    @Test
    public void contextLoads() {
    }


    @Test
    public void testGetAppsAndCats() {
        HttpHeaders headers = new HttpHeaders();
        HttpEntity<String> entity = new HttpEntity<String>(null, headers);
        ResponseEntity<String> response = restTemplate.exchange(getRootUrl() + "/api/apps",
                HttpMethod.GET, entity, String.class);
        System.out.println(response.getBody());
        Assert.assertNotNull(response.getBody());
    }


    @Test
    public void testGetAppsByShortUrl() {
        HttpHeaders headers = new HttpHeaders();
        HttpEntity<String> entity = new HttpEntity<String>(null, headers);
        ResponseEntity<String> response = restTemplate.exchange(getRootUrl() + "/api/apps/utry",
                HttpMethod.GET, entity, String.class);
        System.out.println(response.getBody());
        Assert.assertNotNull(response.getBody());
    }

    @Test
    public void testGetGroupById() {
        HttpHeaders headers = new HttpHeaders();
        HttpEntity<String> entity = new HttpEntity<String>(null, headers);
        ResponseEntity<String> response = restTemplate.exchange(getRootUrl() + "/api/group/1",
                HttpMethod.GET, entity, String.class);
        System.out.println(response.getBody());
        Assert.assertNotNull(response.getBody());

    }

    @Test
    public void testGetAppCategories() {
        HttpHeaders headers = new HttpHeaders();
        HttpEntity<String> entity = new HttpEntity<String>(null, headers);
        ResponseEntity<String> response = restTemplate.exchange(getRootUrl() + "/api/app/categories",
                HttpMethod.GET, entity, String.class);
        System.out.println(response.getBody());
        Assert.assertNotNull(response.getBody());

    }
}