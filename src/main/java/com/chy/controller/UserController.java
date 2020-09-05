package com.chy.controller;

import com.chy.pojo.User;
import com.chy.service.LoginService;
import com.chy.service.ResetInfoService;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;
import java.util.Map;

@RestController
public class UserController {

    @Resource
    private LoginService loginService;
    @Resource
    private ResetInfoService resetInfoService;

    @PostMapping("/doLogin") // 登录
    public User doLogin(@RequestBody User user) {
        User loginInfo = loginService.login(user.getPn(), user.getPwd());
        return loginInfo;
    }

    @PostMapping("/doRegister") // 注册
    public int doRegister(@RequestBody User user) {
            int message = loginService.register(user);
            return message;
    }

    @PostMapping("/resetName") // 改名
    public int resetName(@RequestBody Map map) {
        int i = resetInfoService.resetName((String) map.get("oldName"), (String) map.get("newName"));
        return i;
    }

    @PostMapping("/resetPn") // 改手机号
    public int resetPn(@RequestBody Map map) {
        int i = resetInfoService.resetPn(Long.parseLong((String) map.get("oldPn")),
                Long.parseLong((String) map.get("newPn")));
        return i;
    }

    @PostMapping("/resetEmail") // 改邮箱
    public int resetEmail(@RequestBody Map map) {
        int i = resetInfoService.resetEmail((String) map.get("oldEmail"), (String) map.get("newEmail"));
        return i;
    }

    @PostMapping("/resetPwd") // 改密码
    public int resetPwd(@RequestBody Map map) {
        int i = resetInfoService.resetPwd((String) map.get("userName"), (String) map.get("oldPwd"), (String) map.get("newPwd"));
        return i;
    }
}