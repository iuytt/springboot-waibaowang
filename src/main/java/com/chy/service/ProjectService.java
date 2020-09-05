package com.chy.service;

import com.chy.mapper.ProjectMapper;
import com.chy.pojo.Project;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.sql.Timestamp;
import java.util.Date;
import java.util.List;

@Service
public class ProjectService {

    @Resource
    ProjectMapper projectMapper;

    // 需求方新增 project
    public int addProject(Project project) {
        Date date = new Date();
        Timestamp time = new Timestamp(date.getTime());
        project.setProjectState(0); // 招募中
        project.setEmployee(""); // 新建时无雇员
        project.setTime(time);

        int i = projectMapper.addProject(project); // project 表插入数据

        return i;
    }

    // 查看项目列表时统计符合数目
    public int countProjects(int projectType, int projectState, int recruit, String projectName) {
        int i = projectMapper.countProjects(projectType, projectState, recruit, projectName);
        return i;
    }

    // 查看项目列表时 分页
    public List<Project> queryProjects(int projectType, int projectState, int recruit
            , String projectName, int sort, int page, int pSize) {
        int limit = (page - 1) * pSize;
        List<Project> projects = projectMapper.queryProjects(projectType, projectState, recruit
                , projectName, sort, limit, pSize);
        return projects;
    }

    // 通过 projectId 查询 project
    public Project queryProjectsByID(long projectId) {
        Project project = projectMapper.queryProjectsByID(projectId);
        return project;
    }

    // 开发者 参与/退出 项目时更新 project 表 employee
    public int putEmployee(long projectID, long pn, boolean flag) { // flag == true 增
        String employee = null;
        Project project = projectMapper.queryProjectsByID(projectID);

        if (flag) { // 增
            employee = project.getEmployee() + pn + ";";
        } else { // 删
            StringBuffer sbf = new StringBuffer(project.getEmployee());
            int i = sbf.indexOf(Long.toString(pn));
            employee = sbf.delete(i, i + 12).toString();
        }

        int i = projectMapper.putEmployee(projectID, employee);
        return i;
    }

    // 查看自己的项目
    public List<Project> queryMyProjects(int projectState, long pn, int userStatus, String projectName) {
        List<Project> projects = null;
        if (userStatus == 1) { // 需求方
            projects = projectMapper.queryProjectsByIssue(pn, projectState, projectName);
        } else { // 开发方
            projects = projectMapper.queryProjectsByEmployee(pn + ";", projectState, projectName);
        }
        return projects;
    }

    // 项目完成 更新项目状态
    public void complete(long projectId) {
        projectMapper.putProjectState(projectId, 2);
    }

    // 提交人选结束招募
    public int endRecruit(long projectId, List<String> pn) {
        StringBuffer employee = new StringBuffer();
        for (int i = 0; i < pn.size(); i++) {
            employee.append(pn.get(i) + ";");
        }
        int i = projectMapper.putEmployee(projectId, employee.toString());
        projectMapper.putProjectState(projectId, 1);
        return i;
    }
}
