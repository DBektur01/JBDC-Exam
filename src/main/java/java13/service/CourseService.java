package java13.service;

import java13.entity.Course;

/**
 * Author: Bektur Duyshenbek uulu
 */
public interface CourseService {
    String create(Course course);
    Course getCourseById(Long id);
    String updateCourseById(Long id, Course newCurse);
    String deleteCourseById(Long id);

    //Unique methods

    Course groupCourseByName(String courseName);
    Course getLongestCourses();
}
