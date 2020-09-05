package com.chy.mapper;

import com.chy.pojo.Project;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.util.List;

@Mapper
public interface ProjectMapper {
    int addProject(Project project);

    int countProjects(@Param("projectType") int projectType,
                      @Param("projectState") int projectState,
                      @Param("recruit") int recruit,
                      @Param("projectName") String projectName);

    List<Project> queryProjects(@Param("projectType") int projectType,
                                @Param("projectState") int projectState,
                                @Param("recruit") int recruit,
                                @Param("projectName") String projectName,
                                @Param("sort") int sort,
                                @Param("limit") int limit,
                                @Param("pSize") int pSize);

    List<Project> queryProjectsByIssue(@Param("issue") long issue,
                                       @Param("projectState") int projectState,
                                       @Param("projectName") String projectName);

    List<Project> queryProjectsByEmployee(@Param("employee") String employee,
                                          @Param("projectState") int projectState,
                                          @Param("projectName") String projectName);

    Project queryProjectsByID(long projectID);

    int putEmployee(@Param("projectID") long projectID, @Param("employee") String employee);

    int putProjectState(@Param("projectID") long projectID, @Param("projectState") int projectState);
}
