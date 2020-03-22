package com.school.message.web.controller;

import com.github.pagehelper.PageInfo;
import com.school.message.web.param.BaseParam;
import com.school.message.web.pojo.Result;
import com.school.message.web.pojo.UserMessage;
import com.school.message.web.service.IMessageService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("message")
public class MessageController {

    private IMessageService messageServiceImpl;

    @Autowired
    public MessageController(IMessageService messageServiceImpl) {
        this.messageServiceImpl = messageServiceImpl;
    }

    @RequestMapping("insert")
    public Result insert(UserMessage userMessage) {

        return messageServiceImpl.insert(userMessage);
    }

    @RequestMapping("update")
    public Result update(UserMessage userMessage) {
        return messageServiceImpl.update(userMessage);
    }

    @RequestMapping("delete")
    public Result delete(long id) {

        return messageServiceImpl.delete(id);
    }

    @RequestMapping("query")
    public PageInfo<UserMessage> query(BaseParam param) {

        return messageServiceImpl.query(param);

    }

}
