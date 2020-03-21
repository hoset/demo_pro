package com.school.message.web.service.impl;

import com.school.message.web.mapper.CountMapper;
import com.school.message.web.pojo.MessageCount;
import com.school.message.web.service.ICountService;
import org.springframework.stereotype.Service;

@Service
public class CountServiceImpl extends BaseServiceImpl<MessageCount> implements ICountService {

    public CountServiceImpl(CountMapper countMapper) {
        super(countMapper);
    }
}
