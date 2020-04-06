package com.school.message.web.mapper;

import com.school.message.web.pojo.RegisterOrLogin;
import com.school.message.web.pojo.UserEmailInfo;
import com.school.message.web.pojo.UserInfo;
import org.springframework.stereotype.Component;

@Component
public interface RegisterOrLoginMapper {
    int register(RegisterOrLogin register);

    UserInfo login(RegisterOrLogin login);

    int update(UserEmailInfo userInfo);
}
