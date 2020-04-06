package com.school.message.web.service;

import com.school.message.web.pojo.Result;
import com.school.message.web.pojo.UpdateUserInfo;
import com.school.message.web.pojo.User;

public interface IUserService extends IBaseService<User> {
    Result update(UpdateUserInfo userInfo);
}
