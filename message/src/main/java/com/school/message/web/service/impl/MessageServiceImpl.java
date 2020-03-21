package com.school.message.web.service.impl;

import com.school.message.web.mapper.MessageMapper;
import com.school.message.web.pojo.UserMessage;
import com.school.message.web.service.IMessageService;
import org.springframework.stereotype.Service;

@Service
public class MessageServiceImpl extends BaseServiceImpl<UserMessage> implements IMessageService {

    public MessageServiceImpl(MessageMapper messageMapper) {
        super(messageMapper);
    }
}
