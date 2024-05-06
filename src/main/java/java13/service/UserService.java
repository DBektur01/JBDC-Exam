package java13.service;

import java13.entity.User;

/**
 * Author: Bektur Duyshenbek uulu
 */
public interface UserService {
    String createUser(User user);
    User getUserById(Long id);
    String updateUserById(Long id,User user);
    String deleteUserById(Long id);

    //Unique Methods
    String changeRoleByUserNameAndPassword();
    User getUserByRole(String role);
}
