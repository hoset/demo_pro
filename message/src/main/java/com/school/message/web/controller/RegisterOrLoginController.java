package com.school.message.web.controller;

import com.school.message.web.pojo.RegisterOrLogin;
import com.school.message.web.pojo.Result;
import com.school.message.web.pojo.UpdateUserInfo;
import com.school.message.web.service.IRegisterOrLoginService;
import org.apache.commons.codec.digest.DigestUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.*;

import java.util.Arrays;
import java.util.Map;

@RestController
@RequestMapping("registerAndLogin")
public class RegisterOrLoginController {

    private IRegisterOrLoginService registerOrLoginServiceImpl;

    @Autowired
    public RegisterOrLoginController(IRegisterOrLoginService registerOrLoginServiceImpl) {
        this.registerOrLoginServiceImpl = registerOrLoginServiceImpl;
    }

    @PostMapping("register")
    public Result register(@RequestBody RegisterOrLogin register) {

        return registerOrLoginServiceImpl.register(register);
    }

    @PostMapping("login")
    public Result login(@RequestBody RegisterOrLogin login) {

        return registerOrLoginServiceImpl.login(login);
    }

    @PostMapping("update")
    public Result updateInfo(@RequestBody UpdateUserInfo userInfo) { // 完善个人信息
        return registerOrLoginServiceImpl.update(userInfo);
    }


    @GetMapping("/handler")
    public String handler(@RequestParam Map<String, String> map) {
        String[] array = {"test123", map.get("timestamp"), map.get("nonce")};
        Arrays.sort(array);
        String s = StringUtils.arrayToDelimitedString(array, "");
        String signature = DigestUtils.sha1Hex(s);
        if (!map.get("signature").equals(signature)) {
            return "fail";
        }
        return map.get("echostr");
    }


}
