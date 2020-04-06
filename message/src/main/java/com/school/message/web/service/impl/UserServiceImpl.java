package com.school.message.web.service.impl;

import com.school.message.web.mapper.RegisterOrLoginMapper;
import com.school.message.web.mapper.UserMapper;
import com.school.message.web.pojo.Result;
import com.school.message.web.pojo.UpdateUserInfo;
import com.school.message.web.pojo.User;
import com.school.message.web.pojo.UserEmailInfo;
import com.school.message.web.service.IUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserServiceImpl extends BaseServiceImpl<User> implements IUserService {

    RegisterOrLoginMapper registerOrLoginMapper;

    @Autowired
    public UserServiceImpl(UserMapper userMapper, RegisterOrLoginMapper registerOrLoginMapper) {
        super(userMapper);
        this.registerOrLoginMapper = registerOrLoginMapper;
    }

    @Override
    public Result update(UpdateUserInfo userInfo) {

        UserEmailInfo emailInfo = userInfo.getEmailInfo();
        if (emailInfo != null && emailInfo.getUserId() != null && emailInfo.getUsername() != null && emailInfo.getPassword() != null) {
            registerOrLoginMapper.update(emailInfo);
        }

        User user = userInfo.toUser();
        int update = baseMapper.update(user);
        Result result;
        if (update == 1) {
            result = new Result();
        } else {
            result = new Result(500, "失败");
        }

        return result;

    }
}
