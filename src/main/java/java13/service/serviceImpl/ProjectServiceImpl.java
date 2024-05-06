package java13.service.serviceImpl;

import java13.dao.ProjectDao;
import java13.dao.daoImpl.ProjectDaoImpl;
import java13.entity.Project;
import java13.service.ProjectService;

import java.time.LocalDate;
import java.util.List;

/**
 * Author: Bektur Duyshenbek uulu
 */
public class ProjectServiceImpl implements ProjectService {
    private final ProjectDao projectDao = new ProjectDaoImpl();
    @Override
    public String createProject(Project project) {
        return projectDao.createProject(project);
    }

    @Override
    public Project getProjectById(Long id) {
        return projectDao.getProjectById(id);
    }

    @Override
    public String updateProjectById(Long projectId, Project newProject) {
        return projectDao.updateProjectById(projectId,newProject);
    }

    @Override
    public String deleteProjectById(Long id) {
        return projectDao.deleteProjectById(id);
    }

    @Override
    public List<Project> getAllProjects() {
        return projectDao.getAllProjects();
    }

    @Override
    public List<Project> getProjectsByDateRange(LocalDate startDate, LocalDate endDate) {
        return projectDao.getProjectsByDateRange(startDate,endDate);
    }
}
