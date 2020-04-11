package com.school.message;

import com.school.message.message.weixin.SendWeixin;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.net.URISyntaxException;

@SpringBootTest
class MessageApplicationTests {


	private SendWeixin sendWeixin;

	@Autowired
	public MessageApplicationTests(SendWeixin sendWeixin) {
		this.sendWeixin = sendWeixin;
	}

	@Test
	public void test() throws URISyntaxException {

		System.out.println(sendWeixin.getOpenId());
	}
	//	private MessageHandler messageHandler;
//	private ISendMessage sendEmail;
//
//	GetEmail getEmail;
//
//	@Autowired
//	public MessageApplicationTests(GetEmail getEmail,MessageHandler messageHandler,ISendMessage sendEmail) {
//		this.messageHandler = messageHandler;
//		this.sendEmail = sendEmail;
//		this.getEmail = getEmail;
//	}
//
//	@Test
//	void contextLoads() throws MessagingException {
//		EMailMessage message = new EMailMessage();
//		message.setFrom("164991810@qq.com");
//		message.setTo(new String[]{"wan.guangming@heitao.com"});
//		message.setContent("测试");
//		message.setSubject("lalala");
//
//		message.setHost("smtp.qq.com");
//		message.setPassword("xmxgiekmhtrubjjb");
//		message.setProtocol("smtp");
//		message.setUsername("164991810@qq.com");
//		messageHandler.init(sendEmail);
//		messageHandler.send(message);
//
////		getEmail.handler();
//	}
//
//	public void test() throws MessagingException {
//
//		Properties p = new Properties();
//
//		Session session = Session.getDefaultInstance(p, null);
//		Store smtp = session.getStore("pop3");
//		smtp.connect("smtp.qq.com","164991810@qq.com","xmxgiekmhtrubjjb");
//		Folder inbox = smtp.getFolder("INBOX");
//		inbox.open(Folder.READ_ONLY);
//		javax.mail.Message[] messages = inbox.getMessages();
//		System.out.println(messages.length);
//
//
//
//
//	}

}
