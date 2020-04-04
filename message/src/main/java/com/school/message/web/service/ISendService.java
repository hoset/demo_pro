package com.school.message.web.service;

import com.school.message.web.pojo.Result;
import com.school.message.web.pojo.SendMessage;

public interface ISendService {
    Result getUser();

    Result getMessage(long from, long to);

    Result sendMessage(SendMessage message);
}
