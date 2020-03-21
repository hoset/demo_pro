package com.school.message;

import com.school.message.message.ISendMessage;
import com.school.message.message.Message;
import com.school.message.message.MessageHandler;
import com.school.message.message.emial.GetEmail;
import com.school.message.web.service.ICountService;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import javax.mail.Folder;
import javax.mail.MessagingException;
import javax.mail.Session;
import javax.mail.Store;
import java.util.Properties;

@SpringBootTest
class MessageApplicationTests {

	private MessageHandler messageHandler;
	private ISendMessage sendEmail;

	GetEmail getEmail;

	@Autowired
	public MessageApplicationTests(GetEmail getEmail,MessageHandler messageHandler,ISendMessage sendEmail) {
		this.messageHandler = messageHandler;
		this.sendEmail = sendEmail;
		this.getEmail = getEmail;
	}

	@Test
	void contextLoads() throws MessagingException {
//		Message message = new Message();
//		message.setFrom("164991810@qq.com");
//		message.setTo(new String[]{"wan.guangming@heitao.com"});
//		message.setContent("测试");
//		message.setSubject("lalala");
//		messageHandler.init(sendEmail);
//		messageHandler.send(message);

		getEmail.handler();
	}

	public void test() throws MessagingException {

		Properties p = new Properties();

		Session session = Session.getDefaultInstance(p, null);
		Store smtp = session.getStore("pop3");
		smtp.connect("smtp.qq.com","164991810@qq.com","xmxgiekmhtrubjjb");
		Folder inbox = smtp.getFolder("INBOX");
		inbox.open(Folder.READ_ONLY);
		javax.mail.Message[] messages = inbox.getMessages();
		System.out.println(messages.length);




	}

}
