package com.school.message.web.service.impl;

import com.school.message.web.mapper.UserMapper;
import com.school.message.web.pojo.User;
import com.school.message.web.service.IUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserServiceImpl extends BaseServiceImpl<User> implements IUserService {
    @Autowired
    public UserServiceImpl(UserMapper userMapper) {
        super(userMapper);
    }
}
