package java13.dao;

import java13.entity.Project;

import java.time.LocalDate;
import java.util.List;

/**
 * Author: Bektur Duyshenbek uulu
 */
public interface ProjectDao {
    String createProject(Project project);
    Project getProjectById(Long id);
    String updateProjectById(Long projectId,
                             Project newProject);
    String deleteProjectById(Long id);

    //Unique Methods
    List<Project> getAllProjects();
    List<Project>getProjectsByDateRange(LocalDate startDate,LocalDate endDate);
}
