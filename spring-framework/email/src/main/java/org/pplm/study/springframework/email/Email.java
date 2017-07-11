package org.pplm.study.springframework.email;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.mail.MailSender;
import org.springframework.mail.SimpleMailMessage;

public class Email {
	private static ApplicationContext context = new ClassPathXmlApplicationContext("email.xml");

	public static void main(String[] args) {
		MailSender mailSender = context.getBean("mailSender", MailSender.class);
		SimpleMailMessage simpleMailMessage = context.getBean("templateMessage", SimpleMailMessage.class);
		simpleMailMessage.setTo("gaojingzhe@bjfxtx.cn");
		simpleMailMessage.setText("helloworld");
		mailSender.send(simpleMailMessage);
		
	}
}
