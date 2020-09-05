package com.chy.mapper;

import com.chy.pojo.User;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

@Mapper
@Repository
public interface UserMapper {

    User queryUserByPn(long pn);

    User queryUserByName(String userName);

    User queryEmail(String email);

    int putUserProjectID(@Param("projectID") String projectID, @Param("userName") String userName);

    int putUserName(@Param("oldName") String oldName, @Param("newName") String newName);

    int putUserPn(@Param("oldPn") long oldPn, @Param("newPn") long newPn);

    int putUserEmail(@Param("oldEmail") String oldEmail, @Param("newEmail") String newEmail);

    int putUserPwd(@Param("userName") String userName, @Param("newPwd") String newPwd);

    int addUser(User user);
}
