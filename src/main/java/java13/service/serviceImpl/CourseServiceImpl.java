package java13.service.serviceImpl;

import java13.dao.CourseDao;
import java13.dao.daoImpl.CourseDaoImpl;
import java13.entity.Course;
import java13.service.CourseService;

/**
 * Author: Bektur Duyshenbek uulu
 */
public class CourseServiceImpl implements CourseService {

    private  CourseDao courseDao = new CourseDaoImpl();
    @Override
    public String create(Course course) {
        return courseDao.create(course);
    }

    @Override
    public Course getCourseById(Long id) {
        return courseDao.getCourseById(id);
    }

    @Override
    public String updateCourseById(Long id, Course newCurse) {
        return courseDao.updateCourseById(id,newCurse);
    }

    @Override
    public String deleteCourseById(Long id) {
        return courseDao.deleteCourseById(id);
    }

    @Override
    public Course groupCourseByName(String courseName) {
        return courseDao.groupCourseByName(courseName);
    }

    @Override
    public Course getLongestCourses() {
        return courseDao.getLongestCourses();
    }
}
