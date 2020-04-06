package com.school.message.web.controller;

import com.school.message.web.pojo.RegisterOrLogin;
import com.school.message.web.pojo.Result;
import com.school.message.web.pojo.UpdateUserInfo;
import com.school.message.web.pojo.UserEmailInfo;
import com.school.message.web.service.IRegisterOrLoginService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("registerAndLogin")
public class RegisterOrLoginController {

    private IRegisterOrLoginService registerOrLoginServiceImpl;

    @Autowired
    public RegisterOrLoginController(IRegisterOrLoginService registerOrLoginServiceImpl) {
        this.registerOrLoginServiceImpl = registerOrLoginServiceImpl;
    }

    @PostMapping("register")
    public Result register(@RequestBody RegisterOrLogin register){

        return registerOrLoginServiceImpl.register(register);
    }

    @PostMapping("login")
    public Result login(@RequestBody RegisterOrLogin login){

        return registerOrLoginServiceImpl.login(login);
    }
    @PostMapping("update")
    public Result updateInfo(@RequestBody UpdateUserInfo userInfo){ // 完善个人信息
        return registerOrLoginServiceImpl.update(userInfo);
    }


}
