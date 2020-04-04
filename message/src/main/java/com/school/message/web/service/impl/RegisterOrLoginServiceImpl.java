package com.school.message.web.service.impl;

import com.school.message.web.mapper.RegisterOrLoginMapper;
import com.school.message.web.pojo.RegisterOrLogin;
import com.school.message.web.pojo.Result;
import com.school.message.web.pojo.User;
import com.school.message.web.service.IRegisterOrLoginService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.servlet.http.HttpServletRequest;

@Service
public class RegisterOrLoginServiceImpl implements IRegisterOrLoginService {

    private RegisterOrLoginMapper registerOrLoginMapper;
    private HttpServletRequest httpServletRequest;

    @Autowired
    public RegisterOrLoginServiceImpl(RegisterOrLoginMapper registerOrLoginMapper,HttpServletRequest httpServletRequest) {
        this.registerOrLoginMapper = registerOrLoginMapper;
        this.httpServletRequest =httpServletRequest;
    }

    @Override
    public Result register(RegisterOrLogin register) {
        int register1 = registerOrLoginMapper.register(register);
        Result result = new Result(0, "注册成功");

        if (register1 != 1) {
            result = new Result(500, "注册失败");
        }

        return result;
    }

    @Override
    public Result login(RegisterOrLogin login) {
        User login1 = registerOrLoginMapper.login(login);

        Result result = new Result(0, "登录成功");
        if (login1 == null) {
            result = new Result(500, "登录失败");
        } else {
            result.setData(login1);
            httpServletRequest.getSession().setAttribute("ttt", login1);
        }

        return result;

    }
}
