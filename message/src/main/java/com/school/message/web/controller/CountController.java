package com.school.message.web.controller;

import com.github.pagehelper.PageInfo;
import com.school.message.web.param.BaseParam;
import com.school.message.web.pojo.MessageCount;
import com.school.message.web.service.ICountService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("count")
public class CountController {

    private ICountService countServiceImpl;

    @Autowired
    public CountController(ICountService countServiceImpl) {
        this.countServiceImpl = countServiceImpl;
    }
    @RequestMapping("query")
    public PageInfo<MessageCount> query(BaseParam params){

        return countServiceImpl.query(params);
    }
}
