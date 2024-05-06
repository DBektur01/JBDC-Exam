package java13.dao.daoImpl;

import java13.config.DatabaseConfig;
import java13.dao.ProjectDao;
import java13.entity.Product;
import java13.entity.Project;

import java.sql.*;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

/**
 * Author: Bektur Duyshenbek uulu
 */
public class ProjectDaoImpl implements ProjectDao {

    private final Connection connection = DatabaseConfig.getConnection();

    @Override
    public String createProject(Project project) {
        String sql = """
                create table projects(
                id serial primary key,
                name varchar,
                startDate date,
                endDate date);
                """;

        try (PreparedStatement preparedStatement = connection.prepareStatement(sql)) {
            preparedStatement.executeUpdate();
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
        return "Table Projects Successfully created!";
    }

    @Override
    public Project getProjectById(Long id) {
        Project product = new Project();
        String sql = "select * from projects where id = ?";
        try (PreparedStatement preparedStatement = connection.prepareStatement(sql)) {
            ResultSet resultSet = preparedStatement.executeQuery();
            if (!resultSet.next()) {
                throw new RuntimeException("Projects with id " + id + "not found");
            }
            product.setId(resultSet.getLong(1));
            product.setName(resultSet.getString(2));
            product.setStartDate(LocalDate.parse(resultSet.getString(3)));
            product.setEndDate(LocalDate.parse(resultSet.getString(4)));
            preparedStatement.executeUpdate();
            return product;
        } catch (SQLException e) {
            throw new RuntimeException(e.getMessage());
        }
    }

    @Override
    public String updateProjectById(Long projectId, Project newProject) {
        String sql = "update projects set ame = ?, startDate = ?, endDate = ? where id = ?";
        try (PreparedStatement preparedStatement = connection.prepareStatement(sql)) {
            preparedStatement.setString(1, newProject.getName());
            preparedStatement.setDate(2, Date.valueOf(newProject.getStartDate()));
            preparedStatement.setDate(2, Date.valueOf(newProject.getEndDate()));
            preparedStatement.executeUpdate();
            return "Project Successfully updated!";
        } catch (SQLException e) {
            return e.getMessage();
        }
    }

    @Override
    public String deleteProjectById(Long id) {
        String sql = "delete from projects  where id = ?";
        try (PreparedStatement preparedStatement = connection.prepareStatement(sql)) {
            preparedStatement.setLong(1, id);
            preparedStatement.executeUpdate();
            return "Projects with Id " + id + " Successfully deleted!";
        } catch (SQLException e) {
            return e.getMessage();
        }
    }

    @Override
    public List<Project> getAllProjects() {
        List<Project> projects = new ArrayList<>();
        String sql = "select * from projects";
        try (PreparedStatement preparedStatement = connection.prepareStatement(sql)) {
            ResultSet resultSet = preparedStatement.executeQuery();
            while (resultSet.next()) {
                Project project = new Project();
                project.setId(resultSet.getLong(1));
                project.setName(resultSet.getString(2));
                project.setStartDate(resultSet.getDate(3).toLocalDate());
                project.setEndDate(resultSet.getDate(3).toLocalDate());
                projects.add(project);
            }
            return projects;
        } catch (SQLException e) {
            throw new RuntimeException(e.getMessage());
        }

    }

    @Override
    public List<Project> getProjectsByDateRange(LocalDate startDate, LocalDate endDate) {
        List<Project> projects = new ArrayList<>();
        String sql = "select * from projects where startDate = ? and endDate = ?";
        try (PreparedStatement preparedStatement = connection.prepareStatement(sql)) {
            ResultSet resultSet = preparedStatement.executeQuery();
            while (resultSet.next()) {

            }
            return projects;
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
        return List.of();
    }
}
