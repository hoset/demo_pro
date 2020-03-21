package com.school.message.message.emial;

import com.school.message.message.ISendMessage;
import com.school.message.message.Message;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.MimeMessageHelper;
import org.springframework.stereotype.Component;

import javax.mail.*;
import javax.mail.internet.MimeMessage;
import java.util.Date;
import java.util.Properties;

@Component
public class SendEmail implements ISendMessage {

    private JavaMailSender javaMailSender;

    @Autowired
    public SendEmail(JavaMailSender javaMailSender) {
        this.javaMailSender = javaMailSender;
    }

    @Override
    public void send(Message message) {
        try {
            MimeMessage mimeMessage = createMessage(message);
            javaMailSender.send(mimeMessage);
        } catch (MessagingException e) {
            e.printStackTrace();
        }
    }

    private MimeMessage createMessage(Message message) throws MessagingException {

        MimeMessage mimeMessage = javaMailSender.createMimeMessage();
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
