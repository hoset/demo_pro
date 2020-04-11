package com.school.message.web.service.impl;

import com.school.message.message.ISendMessage;
import com.school.message.message.emun.MessageType;
import com.school.message.message.message.EMailMessage;
import com.school.message.web.mapper.MessageMapper;
import com.school.message.web.mapper.SendServiceMapper;
import com.school.message.web.pojo.*;
import com.school.message.web.service.ISendService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.function.Function;
import java.util.stream.Collectors;

@Service
public class SendServiceImpl implements ISendService {

    private SendServiceMapper sendServiceMapper;
    private MessageMapper messageMapper;
//    private MessageHandler messageHandler;

    private ISendMessage sendEmail;

    @Autowired
    public SendServiceImpl(ISendMessage sendEmail, SendServiceMapper sendServiceMapper, MessageMapper messageMapper) {
        this.sendEmail = sendEmail;
        this.sendServiceMapper = sendServiceMapper;
        this.messageMapper = messageMapper;
    }

    @Override
    public Result getUser() {
        Result result = new Result();
        List<SendUser> user = sendServiceMapper.getUser();
        if (user != null) {
            result.setData(user);
        } else {
            result.setData(new ArrayList<>());
        }
        return result;
    }

    @Override
    public Result getMessage(long from, long to) {
        Result result = new Result();
        List<MessageInfo> message = sendServiceMapper.getMessage(from, to);
        if (message != null) {
            result.setData(message);
        } else {
            result.setData(new ArrayList<>());
        }
        return result;
    }

    @Override
    public Result sendMessage(SendMessage message) {
        UserMessage userMessage = new UserMessage(message.getContent(), message.getType());
        int insert = messageMapper.insert(userMessage);
        Result result = new Result(0, "成功");
        if (insert == 1 && message.getTo() != null && message.getTo().size() > 0) {

            sendServiceMapper.send(message.getTo(), message.getFrom(), userMessage.getId());
            if (message.getType() == MessageType.EMAIL.value() ||message.getType() ==  MessageType.ALL.value()) {

                synchronized (this) {
                    new Thread(() -> {
                        this.sendEmail(message);

                    }).start();


                }

            }


        } else {
            result = new Result(500, "失败");
        }


        return result;
    }

    private void sendEmail(SendMessage message) {

        List<EmailInfo> email = sendServiceMapper.email();
        Map<Long, EmailInfo> collect = email.stream().collect(Collectors.toMap(EmailInfo::getUserId, Function.identity()));
        Long from = message.getFrom();
        EmailInfo emailInfo = collect.get(from);

        List<Long> tos = message.getTo();

        String[] to = tos.stream().map(item -> collect.get(item)).map(EmailInfo::getUsername).toArray(String[]::new);

        EMailMessage msg = new EMailMessage();
        msg.setUsername(emailInfo.getUsername());
        msg.setPassword(emailInfo.getPassword());
        msg.setHost(emailInfo.getHost());
        msg.setProtocol(emailInfo.getProtocol());
        msg.setFrom(emailInfo.getUsername());
        msg.setTo(to);
        msg.setContent(message.getContent());
        msg.setSubject("消息");
        sendEmail.send(msg);


    }
}
