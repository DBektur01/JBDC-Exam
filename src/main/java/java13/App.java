package java13;

import java13.dao.CourseDao;
import java13.dao.UserDao;
import java13.dao.daoImpl.CourseDaoImpl;
import java13.dao.daoImpl.CustomerDaoImpl;
import java13.dao.daoImpl.UserDaoImpl;
import java13.entity.*;
import java13.enums.Role;
import java13.service.ProjectService;
import java13.service.serviceImpl.ProductServiceImpl;
import java13.service.serviceImpl.ProjectServiceImpl;

/**
 * Hello world!
 *
 */
public class App {
    public static void main( String[] args){

       // CourseDao courseDao = new CourseDaoImpl();
        //System.out.println(courseDao.create(new Course("Peaksoft","Java",9)));
        //System.out.println(courseDao.getCourseById(1L));

      //  UserDao userDao = new UserDaoImpl();
        //System.out.println(userDao.createUser(new User("Bektur", "bek9977", Role.USER)));

        //CustomerDaoImpl customerDao = new CustomerDaoImpl();
        //System.out.println(customerDao.addCustomer(new Customer()));

        //ProjectService projectService = new ProjectServiceImpl();
        //System.out.println(projectService.createProject(new Project()));

        ProductServiceImpl productService = new ProductServiceImpl();
       // System.out.println(productService.addProduct(new Product()));
    }
}
