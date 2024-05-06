package java13.dao.daoImpl;

import java13.config.DatabaseConfig;
import java13.dao.CourseDao;
import java13.entity.Course;
import java13.entity.User;
import java13.enums.Role;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

/**
 * Author: Bektur Duyshenbek uulu
 */
public class CourseDaoImpl implements CourseDao {

    private final Connection connection = DatabaseConfig.getConnection();
    @Override
    public String create(Course course) {
        String sql = """
                create table course(
                id serial primary key,
                name varchar,
                description varchar,
                duration int);
                """;
        String query= """
                insert into course ( name, description, duration)values(?,?,?);
                """;
        try(PreparedStatement preparedStatement = connection.prepareStatement(query)){
            preparedStatement.setString(1, course.getName());
            preparedStatement.setString(2, course.getDescription());
            preparedStatement.setInt(3, course.getDuration());
            preparedStatement.executeUpdate();
            return "Course Table Successfully created!";
        }catch (SQLException e){
           return e.getMessage();
        }
    }

    @Override
    public Course getCourseById(Long id) {
       Course course = new Course();
        String sql = "select * from course where id=?";
        try(PreparedStatement preparedStatement = connection.prepareStatement(sql)){
            preparedStatement.setLong(1,id);
            ResultSet resultSet = preparedStatement.executeQuery();
            if (!resultSet.next()) {
                throw new RuntimeException("Course with id " + id + "not found");
            }
            course.setId(resultSet.getLong(1));
            course.setName(resultSet.getString(2));
            course.setDescription(resultSet.getString(3));
            course.setDuration(resultSet.getByte(4));
            return course;

        }catch (SQLException e){
            throw new RuntimeException(e.getMessage());
        }
    }

    @Override
    public String updateCourseById(Long id, Course newCurse) {
        String sql = "update course set name = ?,description = ?, duration = ? where id = ?";
        try(PreparedStatement preparedStatement = connection.prepareStatement(sql)){
            preparedStatement.setString(1, newCurse.getName());
            preparedStatement.setString(2, newCurse.getDescription());
            preparedStatement.setInt(3, newCurse.getDuration());
            preparedStatement.executeUpdate();
            return "Course with id "+id+" Successfully updated!";
        }catch (SQLException e){
            return e.getMessage();
        }
    }

    @Override
    public String deleteCourseById(Long id) {
        String sql = "delete from course where id = ?";
        try(PreparedStatement preparedStatement = connection.prepareStatement(sql)){
            preparedStatement.setLong(1,id);
            preparedStatement.executeUpdate();
            return "Course with id" +id+" Successfully deleted!";
        }catch (SQLException e){
            return e.getMessage();
        }
    }

    @Override
    public Course groupCourseByName(String courseName) {
        String sql = "select * from course ";
        return null;
    }

    @Override
    public Course getLongestCourses() {

        return null;
    }
}
