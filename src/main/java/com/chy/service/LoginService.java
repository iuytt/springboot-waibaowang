package com.chy.service;

import com.chy.mapper.UserMapper;
import com.chy.pojo.User;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;


@Service
public class LoginService {
    @Resource
    private UserMapper userMapper;

    // 登录业务
    public User login(long pn, String pwd) {
        User user = userMapper.queryUserByPn(pn);
        if (user == null) {
            return null;
        }
        if (user.getPwd().equals(pwd)) {
            return user;
        }
        return null;
    }

    // 注册业务
    public int register(User user) {
        // 检查是否已经注册
        User checkPn = userMapper.queryUserByPn(user.getPn());
        User checkEmail = userMapper.queryEmail(user.getEmail());
        User checkUserName = userMapper.queryUserByName(user.getUserName());

        if (checkPn == null && checkEmail == null && checkUserName == null) {
            userMapper.addUser(user);
            return 1;
        }
        if (checkUserName != null) {
            return 2;
        }
        return 0;
    }

}
