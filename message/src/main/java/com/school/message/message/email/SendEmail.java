package com.school.message.message.email;

import com.school.message.message.ISendMessage;
import com.school.message.message.message.EMailMessage;
import com.school.message.message.message.Message;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.JavaMailSenderImpl;
import org.springframework.mail.javamail.MimeMessageHelper;
import org.springframework.stereotype.Component;
import org.springframework.util.Assert;

import javax.mail.MessagingException;
import javax.mail.internet.MimeMessage;
import java.util.Date;
import java.util.Properties;

@Component
public class SendEmail implements ISendMessage {



    @Override
    public void send(Message message) {
        Assert.isInstanceOf(EMailMessage.class,message);
        EMailMessage mesg = (EMailMessage)message;
        try {





            JavaMailSenderImpl javaMailSenderImpl = new JavaMailSenderImpl();

            MimeMessage mimeMessage = createMessage(javaMailSenderImpl,mesg);
            javaMailSenderImpl.send(mimeMessage);
        } catch (MessagingException e) {
            e.printStackTrace();
        }
    }

    private MimeMessage createMessage(JavaMailSenderImpl javaMailSenderImpl,EMailMessage message) throws MessagingException {


        javaMailSenderImpl.setHost(message.getHost());
        javaMailSenderImpl.setUsername(message.getUsername());
        javaMailSenderImpl.setPassword(message.getPassword());
        javaMailSenderImpl.setDefaultEncoding("UTF-8");
        javaMailSenderImpl.setProtocol(message.getProtocol());


        MimeMessage mimeMessage = javaMailSenderImpl.createMimeMessage();

        mimeMessage.addHeader("Disposition-Notification-To", "1");

        MimeMessageHelper helper = new MimeMessageHelper(mimeMessage, "utf-8");

        helper.setFrom(message.getFrom());

        helper.setTo(message.getTo());
        helper.setSentDate(new Date());
        helper.setSubject(message.getSubject());
        helper.setText(message.getContent());


        return mimeMessage;
    }


}
