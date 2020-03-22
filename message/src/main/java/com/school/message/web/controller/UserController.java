package com.school.message.web.controller;

import com.github.pagehelper.PageInfo;
import com.school.message.web.param.BaseParam;
import com.school.message.web.pojo.Result;
import com.school.message.web.pojo.User;
import com.school.message.web.service.IUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("user")
public class UserController {

    private IUserService userServiceIml;

    @Autowired
    public UserController(IUserService userServiceIml) {
        this.userServiceIml = userServiceIml;
    }

    @RequestMapping("insert")
    public Result insert(@RequestBody User user) {
        return userServiceIml.insert(user);
    }

    @RequestMapping("update")
    public Result update(@RequestBody User user) {
        return userServiceIml.update(user);
    }

    @RequestMapping("delete")
    public Result delete(long id) {
        return userServiceIml.delete(id);
    }

    @RequestMapping("query")
    public PageInfo<User> query(BaseParam param) {
        return userServiceIml.query(param);
    }

}
