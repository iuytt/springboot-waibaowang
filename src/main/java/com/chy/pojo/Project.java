package com.chy.pojo;

import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import java.sql.Timestamp;
import java.util.Objects;

@Entity
public class Project {
    private long projectId;
    private String projectName;
    private long issue;
    private int projectType;
    private String projectDetails;
    private int pay;
    private int date;
    private int projectState;
    private String employee;
    private int recruit;
    private Timestamp time;



    @Id
    @Column(name = "projectID")
    public long getProjectId() {
        return projectId;
    }

    public void setProjectId(long projectId) {
        this.projectId = projectId;
    }

    @Basic
    @Column(name = "projectName")
    public String getProjectName() {
        return projectName;
    }

    public void setProjectName(String projectName) {
        this.projectName = projectName;
    }

    @Basic
    @Column(name = "issue")
    public long getIssue() {
        return issue;
    }

    public void setIssue(long issue) {
        this.issue = issue;
    }

    @Basic
    @Column(name = "projectType")
    public int getProjectType() {
        return projectType;
    }

    public void setProjectType(int projectType) {
        this.projectType = projectType;
    }

    @Basic
    @Column(name = "projectDetails")
    public String getProjectDetails() {
        return projectDetails;
    }

    public void setProjectDetails(String projectDetails) {
        this.projectDetails = projectDetails;
    }

    @Basic
    @Column(name = "pay")
    public int getPay() {
        return pay;
    }

    public void setPay(int pay) {
        this.pay = pay;
    }

    @Basic
    @Column(name = "date")
    public int getDate() {
        return date;
    }

    public void setDate(int date) {
        this.date = date;
    }

    @Basic
    @Column(name = "projectState")
    public int getProjectState() {
        return projectState;
    }

    public void setProjectState(int projectState) {
        this.projectState = projectState;
    }

    @Basic
    @Column(name = "employee")
    public String getEmployee() {
        return employee;
    }

    public void setEmployee(String employee) {
        this.employee = employee;
    }

    @Basic
    @Column(name = "recruit")
    public int getRecruit() {
        return recruit;
    }

    public void setRecruit(int recruit) {
        this.recruit = recruit;
    }

    @Basic
    @Column(name = "time")
    public Timestamp getTime() {
        return time;
    }

    public void setTime(Timestamp time) {
        this.time = time;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Project project = (Project) o;
        return projectId == project.projectId &&
                issue == project.issue &&
                projectType == project.projectType &&
                pay == project.pay &&
                date == project.date &&
                projectState == project.projectState &&
                recruit == project.recruit &&
                Objects.equals(projectName, project.projectName) &&
                Objects.equals(projectDetails, project.projectDetails) &&
                Objects.equals(employee, project.employee) &&
                Objects.equals(time, project.time);
    }

    @Override
    public int hashCode() {
        return Objects.hash(projectId, projectName, issue, projectType, projectDetails, pay, date, projectState, employee, recruit, time);
    }
}
