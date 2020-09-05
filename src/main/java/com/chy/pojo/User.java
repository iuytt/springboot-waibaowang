package com.chy.pojo;

import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import java.util.Objects;

@Entity
public class User {
    private String userName;
    private long pn;
    private String pwd;
    private String email;
    private int userStatus;
    private String projectId;

    @Basic
    @Column(name = "userName")
    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    @Id
    @Column(name = "PN")
    public long getPn() {
        return pn;
    }

    public void setPn(long pn) {
        this.pn = pn;
    }

    @Basic
    @Column(name = "pwd")
    public String getPwd() {
        return pwd;
    }

    public void setPwd(String pwd) {
        this.pwd = pwd;
    }

    @Basic
    @Column(name = "email")
    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    @Basic
    @Column(name = "userStatus")
    public int getUserStatus() {
        return userStatus;
    }

    public void setUserStatus(int userStatus) {
        this.userStatus = userStatus;
    }

    @Basic
    @Column(name = "projectID")
    public String getProjectId() {
        return projectId;
    }

    public void setProjectId(String projectId) {
        this.projectId = projectId;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        User user = (User) o;
        return pn == user.pn &&
                userStatus == user.userStatus &&
                Objects.equals(userName, user.userName) &&
                Objects.equals(pwd, user.pwd) &&
                Objects.equals(email, user.email) &&
                Objects.equals(projectId, user.projectId);
    }

    @Override
    public int hashCode() {
        return Objects.hash(userName, pn, pwd, email, userStatus, projectId);
    }
}
