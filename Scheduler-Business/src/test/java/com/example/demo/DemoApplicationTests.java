package com.example.demo;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.test.context.junit4.SpringRunner;

@RunWith(SpringRunner.class)
@SpringBootTest(classes = DemoApplicationTests.class)
public  class DemoApplicationTests {

	@Autowired
	private JavaMailSender mailSender;

	@Test
	public	void testSendSimpleMai() {
		SimpleMailMessage message = new SimpleMailMessage();
		message.setFrom("飞机");
		message.setTo("1007026577@qq.com");
		message.setSubject("主题：简单邮件");
		message.setText("测试邮件内容");

		mailSender.send(message);
	}

}
