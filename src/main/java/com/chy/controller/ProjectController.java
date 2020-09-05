package com.chy.controller;

import com.chy.pojo.Project;
import com.chy.pojo.User;
import com.chy.service.ProjectService;
import com.chy.service.UserService;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import java.util.List;
import java.util.Map;

@RestController
public class ProjectController {

    @Resource
    ProjectService projectService;
    @Resource
    UserService userService;

    @RequestMapping(value = "/publish", method = RequestMethod.POST)
    public int addProject(@RequestBody Project project) {
        int i = projectService.addProject(project);
        userService.putUserProjectID(project.getProjectId(), project.getIssue(), true);
        return i;
    }

    @RequestMapping(value = {"/count/{projectType}/{projectState}/{recruit}/{projectName}",
            "/count/{projectType}/{projectState}/{recruit}/"}, method = RequestMethod.GET)
    public int countProjects(@PathVariable(value = "projectType", required = false) int projectType,
                             @PathVariable(value = "projectState", required = false) int projectState,
                             @PathVariable(value = "recruit", required = false) int recruit,
                             @PathVariable(value = "projectName", required = false) String projectName) {
        int i = projectService.countProjects(projectType, projectState, recruit, projectName);
        return i;
    }

    @RequestMapping(value = {"/getProjects/{projectType}/{projectState}/{recruit}/{sort}/{page}/{pSize}/{projectName}",
            "/getProjects/{projectType}/{projectState}/{recruit}/{sort}/{page}/{pSize}/"}, method = RequestMethod.GET)
    public List<Project> getProjects(@PathVariable(value = "projectType", required = false) int projectType,
                                     @PathVariable(value = "projectState", required = false) int projectState,
                                     @PathVariable(value = "recruit", required = false) int recruit,
                                     @PathVariable(value = "projectName", required = false) String projectName,
                                     @PathVariable("sort") int sort,
                                     @PathVariable("page") int page,
                                     @PathVariable("pSize") int pSize) {
        List<Project> projects = projectService.queryProjects(projectType, projectState, recruit
                , projectName, sort, page, pSize);
        return projects;
    }

    @RequestMapping(value = "/getProject/{projectId}", method = RequestMethod.GET)
    public Project getProject(@PathVariable("projectId") long projectId) {
        Project project = projectService.queryProjectsByID(projectId);
        return project;
    }

    @RequestMapping(value = "/inProject", method = RequestMethod.PUT)
    public User inProject(@RequestBody Map map) {
        projectService.putEmployee(Long.parseLong(map.get("projectId").toString())
                , Long.parseLong(map.get("pn").toString()), true);
        userService.putUserProjectID(Long.parseLong(map.get("projectId").toString())
                , Long.parseLong(map.get("pn").toString()), true);
        User loginInfo = userService.queryUser(Long.parseLong(map.get("pn").toString()));
        return loginInfo;
    }

    @RequestMapping(value = "/outProject", method = RequestMethod.PUT)
    public User outProject(@RequestBody Map map) {
        projectService.putEmployee(Long.parseLong(map.get("projectId").toString())
                , Long.parseLong(map.get("pn").toString()), false);
        userService.putUserProjectID(Long.parseLong(map.get("projectId").toString())
                , Long.parseLong(map.get("pn").toString()), false);
        User loginInfo = userService.queryUser(Long.parseLong(map.get("pn").toString()));
        return loginInfo;
    }

    @RequestMapping(value = {"/getMyProjects/{projectState}/{pn}/{userStatus}/{projectName}",
            "/getMyProjects/{projectState}/{pn}/{userStatus}/"}, method = RequestMethod.GET)
    public List<Project> getMyProjects(@PathVariable("projectState") int projectState,
                                       @PathVariable("pn") long pn,
                                       @PathVariable("userStatus") int userStatus,
                                       @PathVariable(value = "projectName", required = false) String projectName) {
        List<Project> projects = projectService.queryMyProjects(projectState, pn, userStatus, projectName);
        return projects;
    }

    @RequestMapping(value = "/complete", method = RequestMethod.PUT)
    public void complete(@RequestBody Map map) {
        projectService.complete(Long.parseLong(map.get("projectId").toString()));
    }

    @RequestMapping(value = "/endRecruit", method = RequestMethod.PUT)
    public void endRecruit(@RequestBody Map map) {
        projectService.endRecruit(Long.parseLong(map.get("projectId").toString()),
                (List<String>) map.get("pn"));
    }
}
