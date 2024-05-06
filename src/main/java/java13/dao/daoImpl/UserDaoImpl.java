package java13.dao.daoImpl;

import java13.config.DatabaseConfig;
import java13.dao.UserDao;
import java13.entity.User;
import java13.enums.Role;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

/**
 * Author: Bektur Duyshenbek uulu
 */
public class UserDaoImpl implements UserDao {

    private final Connection connection = DatabaseConfig.getConnection();
    @Override
    public String createUser(User user) {
        String sql ="""
        create table if not exists users (
        id serial primary key, 
        first_name varchar,
        password varchar,
        role varchar)
        """;
        String query = """
                insert into users (
                first_name, password, role)
                values(?,?,?);
                """;
        try(PreparedStatement preparedStatement = connection.prepareStatement(query)){
            preparedStatement.setString(1,user.getUserName());
            preparedStatement.setString(2,user.getPassword());
            preparedStatement.setString(3,user.getRole().toString());
            preparedStatement.executeUpdate();
        }catch (SQLException e){
            System.out.println(e.getMessage());
        }
        return "Successfully created!";
    }

    @Override
    public User getUserById(Long id) {
        User  user = new User();
        String sql = "select * from users where id=?";
        try(PreparedStatement preparedStatement = connection.prepareStatement(sql)){
            preparedStatement.setLong(1,id);
            ResultSet resultSet = preparedStatement.executeQuery();
            if (!resultSet.next()) {
                throw new RuntimeException("User with id " + id + "not found");
            }
            user.setId(resultSet.getLong(1));
            user.setUserName(resultSet.getString(2));
            user.setPassword(resultSet.getString(3));
            user.setRole(Role.valueOf(resultSet.getString(4)));
            return user;

        }catch (SQLException e){
            throw new RuntimeException(e.getMessage());
        }
    }

    @Override
    public String updateUserById(Long id, User user) {
        String sql = "update users set first_name = ?, password = ?, role = ? where id = ?";
        try(PreparedStatement preparedStatement = connection.prepareStatement(sql)){
            preparedStatement.setString(1, user.getUserName());
            preparedStatement.setString(2, user.getPassword());
            preparedStatement.setString(3, user.getRole().toString());
            preparedStatement.executeUpdate();
            return "Successfully updated!";
        }catch (SQLException e){
            return e.getMessage();
        }
    }

    @Override
    public String deleteUserById(Long id) {
        String sql = "delete from users where id = ?";
        try(PreparedStatement preparedStatement = connection.prepareStatement(sql)){
            preparedStatement.setLong(1,id);
            preparedStatement.executeUpdate();
            return "Successfully deleted!";
        }catch (SQLException e){
            return e.getMessage();
        }
    }

    @Override
    public String changeRoleByUserNameAndPassword() {
        return "";
    }

    @Override
    public User getUserByRole(String role) {
        return null;
    }
}
