package com.school.message.web.mapper;

import com.school.message.web.pojo.RegisterOrLogin;
import com.school.message.web.pojo.User;
import org.springframework.stereotype.Component;

@Component
public interface RegisterOrLoginMapper {
    int register(RegisterOrLogin register);

    User login(RegisterOrLogin login);
}
