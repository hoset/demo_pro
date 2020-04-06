package com.school.message.web.service.impl;

import com.school.message.web.mapper.RegisterOrLoginMapper;
import com.school.message.web.mapper.UserMapper;
import com.school.message.web.pojo.*;
import com.school.message.web.service.IRegisterOrLoginService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.servlet.http.HttpServletRequest;

@Service
public class RegisterOrLoginServiceImpl implements IRegisterOrLoginService {

    private RegisterOrLoginMapper registerOrLoginMapper;
    private HttpServletRequest httpServletRequest;
    private UserMapper userMapper;

    @Autowired
    public RegisterOrLoginServiceImpl(UserMapper userMapper,RegisterOrLoginMapper registerOrLoginMapper,HttpServletRequest httpServletRequest) {
        this.userMapper = userMapper;
        this.registerOrLoginMapper = registerOrLoginMapper;
        this.httpServletRequest =httpServletRequest;
    }

    @Override
    public Result register(RegisterOrLogin register) {
        int register1 = registerOrLoginMapper.register(register);
        Result result = new Result(0, "注册成功");

        if (register1 != 1) {
            result = new Result(500, "注册失败");
        }else{
            result =  this.login(register);
        }

        return result;
    }

    @Override
    public Result login(RegisterOrLogin login) {
        UserInfo info = registerOrLoginMapper.login(login);

        Result result = new Result(0, "登录成功");
        if (info == null) {
            result = new Result(500, "登录失败");
        } else {
            result.setData(info);
            httpServletRequest.getSession().setAttribute("ttt", info);
        }

        return result;

    }

    @Override
    public Result update(UpdateUserInfo userInfo) {
       int updateEmail =  registerOrLoginMapper.update(userInfo.getEmailInfo());

        User user = userInfo.toUser();

        int updateUser = userMapper.update(user);

        Result result = new Result(0, "成功");

        if (updateUser != 1) {
            result = new Result(500, "失败");
        }

        return result;
    }
}
