package java13.dao;

import java13.entity.User;

/**
 * Author: Bektur Duyshenbek uulu
 */
public interface UserDao {
    String createUser(User user);
    User getUserById(Long id);
    String updateUserById(Long id,User user);
    String deleteUserById(Long id);

    //Unique Methods
    String changeRoleByUserNameAndPassword();
    User getUserByRole(String role);
}
