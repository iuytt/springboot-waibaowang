package com.chy.service;

import com.chy.mapper.UserMapper;
import com.chy.pojo.User;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;

@Service
public class UserService {

    @Resource
    UserMapper userMapper;

    // 参与/创建/退出 project 时 user 表 projectID 更新
    public int putUserProjectID(long projectID, long pn, boolean flag) { // flag == true 增
        User user = userMapper.queryUserByPn(pn);
        if (user.getUserStatus() == 1) return 0; // 需求方不更新

        String uProjectId = null;
        String userName = user.getUserName();

        if (flag) { // 增
            uProjectId = user.getProjectId() + projectID + ";";
        } else { // 删
            StringBuffer sbf = new StringBuffer(user.getProjectId());
            int i = sbf.indexOf(Long.toString(projectID));
            uProjectId = sbf.delete(i, i + Long.toString(projectID).length() + 1).toString();
        }

        userMapper.putUserProjectID(uProjectId, userName);
        return 1;
    }


    // 获取 user
    public User queryUser(long pn) {
        User user = userMapper.queryUserByPn(pn);
        return user;
    }
}
