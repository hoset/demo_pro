package com.school.message.web.service;

import com.school.message.web.pojo.RegisterOrLogin;
import com.school.message.web.pojo.Result;

/**
 * 注册登录
 */
public interface IRegisterOrLoginService {
    Result register(RegisterOrLogin register); // 注册

    Result login(RegisterOrLogin login); // 登录
}
