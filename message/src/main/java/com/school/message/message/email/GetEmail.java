package com.school.message.message.email;

import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.stereotype.Component;

import javax.mail.*;
import javax.mail.search.OrTerm;
import javax.mail.search.SearchTerm;
import javax.mail.search.SubjectTerm;
import java.util.Properties;
import java.util.stream.Collectors;
import java.util.stream.Stream;

@Component
@ConfigurationProperties("spring.mail")
public class GetEmail {
    private String host;
    private String username;
    private String password;

    public void setHost(String host) {
        this.host = host;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public void handler(){
        Message[] message = this.getMessage();
//        this.getReceipt(message);
    }


    private javax.mail.Message[] getMessage() {
        javax.mail.Message[] messages = new javax.mail.Message[0];
        try {

            Properties p = new Properties();

            Session session = Session.getDefaultInstance(p, null);
            Store store = session.getStore("pop3");
            store.connect("smtp.qq.com", "164991810@qq.com", "xmxgiekmhtrubjjb");
            Folder inbox = store.getFolder("INBOX");
            inbox.open(Folder.READ_ONLY);

            SearchTerm st = new OrTerm(
                    new SearchTerm[]{
                            new SubjectTerm("read:lalala")

                    }
//                    new FromStringTerm(fromTerm),
            );
            Message[] search = inbox.search(st);

            Message message =   search[0];
            Address[] from = message.getFrom();

//            messages = inbox.getMessages();
//            System.out.println(messages.length);
//            Message message = messages[17749];
//            Address[] from = message.getFrom();
            System.out.println(String.valueOf(from[0]));
            System.out.println(message.getSubject());

        } catch (MessagingException e) {
            e.printStackTrace();
        }


        return messages;
    }

    private void getReceipt(javax.mail.Message[] messages) {
        if (messages != null && messages.length > 0) {
            Stream.of(messages).filter(message -> {
                boolean bool = false;
                try {
                    bool = message.getSubject().toString().startsWith("messageId:");
                } catch (MessagingException e) {
                    e.printStackTrace();
                }
                return bool;

            }).map(message -> {
                try {
                    Address[] from = message.getFrom();
                    String subject = message.getSubject();

                    String type = from[0].getType();
                    String s = from[0].toString();
                    System.out.println(subject + "subject");
                    System.out.println(s + "s");
                    System.out.println(type + "type");

                } catch (MessagingException e) {
                    e.printStackTrace();
                }
                return null;
            }).collect(Collectors.toList());


        }

    }
}
