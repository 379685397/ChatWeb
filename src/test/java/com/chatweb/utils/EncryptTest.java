package com.chatweb.utils;

import com.chatweb.comm.Const;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;


@RunWith(SpringRunner.class)
@SpringBootTest
public class EncryptTest {


	@Test
	public void testMD5() throws Exception {
		String password ="123456";
		String pwd = MD5Util.encrypt(password+ Const.PASSWORD_KEY);
		System.out.println("pwd======================="+pwd);
	}

}