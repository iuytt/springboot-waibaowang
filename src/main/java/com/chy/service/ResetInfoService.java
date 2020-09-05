package com.chy.service;

import com.chy.mapper.UserMapper;
import com.chy.pojo.User;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;

@Service
public class ResetInfoService {
    @Resource
    private UserMapper userMapper;

    // 改用户名业务
    public int resetName(String oldName, String newName) {
        // 检查新名字是否存在
        User checkUser = userMapper.queryUserByName(newName);
        if (checkUser == null) {
            userMapper.putUserName(oldName, newName);
            return 1;
        }
        return 0;
    }

    // 改手机号业务
    public int resetPn(long oldPn, long newPn) {
        // 检查新手机号是否存在
        User checkUser = userMapper.queryUserByPn(newPn);
        if (checkUser == null) {
            userMapper.putUserPn(oldPn, newPn);
            return 1;
        }
        return 0;
    }

    // 改邮箱业务
    public int resetEmail(String oldEmail, String newEmail) {
        // 检查新邮箱是否存在
        User checkUser = userMapper.queryEmail(newEmail);
        if (checkUser == null) {
            userMapper.putUserEmail(oldEmail, newEmail);
            return 1;
        }
        return 0;
    }

    // 改密码业务
    public int resetPwd(String userName, String oldPwd, String newPwd) {
        // 检查密码是否正确
        User checkUser = userMapper.queryUserByName(userName);
        if (checkUser.getPwd().equals(oldPwd)) {
            userMapper.putUserPwd(userName, newPwd);
            return 1;
        }
        return 0;
    }
}
