package com.school.message.web.controller;

import com.github.pagehelper.PageInfo;
import com.school.message.web.param.BaseParam;
import com.school.message.web.pojo.Result;
import com.school.message.web.pojo.User;
import com.school.message.web.service.IUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;

@Controller
public class UserController {

    private IUserService userServiceIml;

    @Autowired
    public UserController(IUserService userServiceIml) {
        this.userServiceIml = userServiceIml;
    }

    public Result insert(User user){
      return  userServiceIml.insert(user);
    }

    public Result update(User user){
        return userServiceIml.update(user);
    }

    public Result delete(long id){

        return userServiceIml.delete(id);
    }

    public PageInfo<User> query(BaseParam param){


        return userServiceIml.query(param);
    }

}
