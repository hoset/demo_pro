package com.school.message.web.service.impl;

import com.school.message.web.mapper.MessageMapper;
import com.school.message.web.mapper.SendServiceMapper;
import com.school.message.web.pojo.*;
import com.school.message.web.service.IMessageService;
import com.school.message.web.service.ISendService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@Service
public class SendServiceImpl implements ISendService {

    private SendServiceMapper sendServiceMapper;
    private MessageMapper messageMapper;

    @Autowired
    public SendServiceImpl(SendServiceMapper sendServiceMapper, MessageMapper messageMapper) {
        this.sendServiceMapper = sendServiceMapper;
        this.messageMapper = messageMapper;
    }

    @Override
    public Result getUser() {
        Result result = new Result();
        List<SendUser> user = sendServiceMapper.getUser();
        if(user != null){
            result.setData(user);
        }else{
            result.setData(new ArrayList<>());
        }
        return result;
    }

    @Override
    public Result getMessage(long from, long to) {
        Result result = new Result();
        List<MessageInfo> message = sendServiceMapper.getMessage(from,to);
        if(message != null){
            result.setData(message);
        }else{
            result.setData(new ArrayList<>());
        }
        return result;
    }

    @Override
    public Result sendMessage(SendMessage message) {

        UserMessage userMessage = new UserMessage(message.getContent(), message.getType(), new Date().getTime());
        int insert = messageMapper.insert(userMessage);
        Result result = new Result(0,"成功");
        if(insert == 1 && message.getTo() != null && message.getTo().size() > 0){

            sendServiceMapper.send(message.getTo(),message.getFrom(),userMessage.getId());

        }else{
            result = new Result(500,"失败");
        }


        return null;
    }
}
