package java13.service.serviceImpl;

import java13.dao.UserDao;
import java13.dao.daoImpl.UserDaoImpl;
import java13.entity.User;
import java13.service.UserService;

/**
 * Author: Bektur Duyshenbek uulu
 */
 ;
public class UserServiceImpl implements UserService {
    private final UserDao userDao = new UserDaoImpl();
    @Override
    public String createUser(User user) {
        return userDao.createUser(user);
    }

    @Override
    public User getUserById(Long id) {
        return userDao.getUserById(id);
    }

    @Override
    public String updateUserById(Long id, User user) {
        return userDao.updateUserById(id,user);
    }

    @Override
    public String deleteUserById(Long id) {
        return userDao.deleteUserById(id);
    }

    @Override
    public String changeRoleByUserNameAndPassword() {
        return userDao.changeRoleByUserNameAndPassword();
    }

    @Override
    public User getUserByRole(String role) {
        return userDao.getUserByRole(role);
    }
}
