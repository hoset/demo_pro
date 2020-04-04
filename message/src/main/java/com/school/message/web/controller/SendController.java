package com.school.message.web.controller;

import com.school.message.web.pojo.Result;
import com.school.message.web.pojo.SendMessage;
import com.school.message.web.pojo.SendUser;
import com.school.message.web.service.ISendService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("send")
public class SendController {

    private ISendService sendServiceImpl;

    @Autowired
    public SendController(ISendService sendServiceImpl) {
        this.sendServiceImpl = sendServiceImpl;
    }

    @GetMapping("/userInfo")
    public Result getUser(){

        return sendServiceImpl.getUser();
    }
    @GetMapping("message")
    public Result getMessage(long from,long to){
        return sendServiceImpl.getMessage(from,to);
    }
    @PostMapping("send")
    public Result sendMessage(SendMessage message){
        return sendServiceImpl.sendMessage(message);
    }


}
